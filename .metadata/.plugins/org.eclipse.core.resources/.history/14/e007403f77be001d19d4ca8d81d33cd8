package com.questionpro.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.questionpro.entity.TopStory;

@Repository
public interface TopStoryRepository extends CrudRepository<TopStory, Serializable> {
	public List<TopStory> getTopStories();
	 public List<Map<String, Object>> getComments(int storyId);
}
