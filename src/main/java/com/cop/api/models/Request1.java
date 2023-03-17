package com.cop.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request1 {
	@JsonProperty
	private String name;
	@JsonProperty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	private String job;
}
