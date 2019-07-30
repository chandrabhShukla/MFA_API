package com.tgt.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRequestDTO {

	@Expose
	@SerializedName("user_id")
	@Valid
	private String id;

	@Expose
	@SerializedName("user_name")
	@Valid
	private String name;


	@JsonProperty("user_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("user_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}