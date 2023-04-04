package com.questionpro.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.questionpro.entity.TopStory;
import com.questionpro.service.TopStoryService;

@RestController
@RequestMapping("/stories")
public class TopStoriesController {
	@Autowired
	private TopStoryService topStoryService;
	private RestTemplate restTemplate;

//	public TopStoriesController(RestTemplate restTemplate) {
//		super();
//		this.restTemplate = restTemplate;
//	}

	@GetMapping("/top-stories")
	public List<TopStory> getTopStories() {
		// Get the IDs of the top stories
		String topStoriesUrl = "https://hacker-news.firebaseio.com/v0/topstories.json";
		int[] topStoryIds = restTemplate.getForObject(topStoriesUrl, int[].class);

		// Get the details of each top story
		List<TopStory> topStories = new ArrayList<>();

		for (int i = 0; i < 10 && i < topStoryIds.length; i++) {
			String storyUrl = String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", topStoryIds[i]);
			Map<String, Object> story = restTemplate.getForObject(storyUrl, Map.class);

			// Check if the story was submitted in the past 15 minutes
			long submissionTime = (Integer) story.get("time") * 1000L;
			long fifteenMinutesAgo = Instant.now().minusSeconds(900).toEpochMilli();

			if (submissionTime >= fifteenMinutesAgo) {
				// Create a new TopStory object and add it to the list
				// TopStory ts = new TopStory(1, "topstory", "www.stories.com", 68, 12,
				// "Abhijit");
				TopStory ts = new TopStory(1, "title", "url", 67, (float) 12.34, "storyurl");
				topStories.add(ts);
			}
		}

		return topStories;
	}

	@GetMapping("/comments")
	public List<Map<String, Object>> getComments(@PathVariable int storyId) {
		String storyUrl = String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", storyId);
		Map<String, Object> story = restTemplate.getForObject(storyUrl, Map.class);
		// Get the IDs of the top-level comments for the story
		int[] commentIds = (int[]) story.get("kids");
		// Get the details of each top-level comment
		List<Map<String, Object>> comments = new ArrayList<>();

		for (int commentId : commentIds) {
			String commentUrl = String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", commentId);
			Map<String, Object> comment = restTemplate.getForObject(commentUrl, Map.class);
//
//			// Get the details of the user who submitted the comment
			String userUrl = String.format("https://hacker-news.firebaseio.com/v0/user/%s.json", comment.get("by"));
			Map<String, Object> user = restTemplate.getForObject(userUrl, Map.class);
//			// Add the comment to the list
			comments.add(Map.of("text", comment.get("text"), "user", user.get("id"), "childCount",
					comment.get("descendants")));
		}

		// Sort the comments by total number of child comments in descending order
		comments.sort(Comparator.comparingInt(s -> (Integer) s.get("childCount")));
		//comments.sort(Comparator.reverseOrder());
		// Limit the comments to 10
		if (comments.size() > 10) {
			comments = comments.subList(0, 10);
		}

		return comments;
	}

	@GetMapping("/past-stories")
	public ResponseEntity<Iterable<TopStory>> getPastStories() {
		Iterable<TopStory> l = topStoryService.getPastStories();
		return ResponseEntity.ok().body(l);
	}

}
