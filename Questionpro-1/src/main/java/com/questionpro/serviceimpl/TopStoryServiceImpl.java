package com.questionpro.serviceimpl;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.questionpro.dao.TopStoryRepository;
import com.questionpro.entity.TopStory;
import com.questionpro.service.TopStoryService;

@Service
public class TopStoryServiceImpl implements TopStoryService {
	@Autowired
	private TopStoryRepository topStoryRepository;

	public TopStoryServiceImpl(TopStoryRepository topStoryRepository) {
		super();
		this.topStoryRepository = topStoryRepository;
	}

	@Override
	public List<List<TopStory>> getTopStories() {
		// TODO Auto-generated method stub
		// Calculate time 15 minutes ago
		long fifteenMinutesAgo = Instant.now().getEpochSecond() - 900;
		// Build the URL for 15 minutes ago
		String apiUrl = String.format("url", fifteenMinutesAgo);

		// Use a REST to retrieve the story IDs from the API
		RestTemplate restTemplate = new RestTemplate();
		Long[] storyIds = restTemplate.getForObject(apiUrl, Long[].class);
		// Retrieve the top 10 stories from the repository and map them to TopStory
		// objects
		return Arrays.stream(storyIds).limit(10).map(id -> topStoryRepository.getTopStories())
				.collect(Collectors.toList());

	}

	@Override
	public Iterable<TopStory> getPastStories() {
		// TODO Auto-generated method stub
		return topStoryRepository.findAll();
	}

	@Override
	public List<Map<String, Object>> getComments(int storyId) {
		// TODO Auto-generated method stub
		return topStoryRepository.getComments(storyId);
	}

}
