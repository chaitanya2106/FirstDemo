package com.questionpro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class TopStory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	public TopStory() {
		// TODO Auto-generated constructor stub
	}

	public TopStory(int id, String title, String url, int score, float time, String user) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.score = score;
		this.time = time;
		this.user = user;
	}

	@Override
	public String toString() {
		return "TopStory [id=" + id + ", title=" + title + ", comments=" + comments + ", url=" + url + ", score="
				+ score + ", time=" + time + ", user=" + user + "]";
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Comments comments;
	private String url;
	private int score;
	private float time;
	private String user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public int getScore() {
		return score;
	}

	public float getTime() {
		return time;
	}

	public String getUser() {
		return user;
	}

}