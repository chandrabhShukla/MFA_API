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
	@SerializedName("device_name")
	@Valid
	private String deviceName;
	
	@Expose
	@SerializedName("mobile_number")
	@Valid
	private String mobileNumber;
	@Expose
	@SerializedName("mobile")
	@Valid
	private int mobile;
	

	@Expose
	@SerializedName("first_name")
	@Valid
	private String firstName;
    
	@Expose
	@SerializedName("last_name")
	@Valid
	private String lastName;
	
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Expose
	@SerializedName("location")
	@Valid
	private String location;
	

	@JsonProperty("user_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}
    @JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    @JsonProperty("device_name")
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
    @JsonProperty("mobile_number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    @JsonProperty("mobile")
	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
    
    

}