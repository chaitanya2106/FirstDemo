package com.questionpro.service;

import java.util.List;
import java.util.Map;

import com.questionpro.entity.TopStory;

public interface TopStoryService {

	List<List<TopStory>> getTopStories();

	public List<Map<String, Object>> getComments(int storyId);

	public Iterable<TopStory> getPastStories();
}
