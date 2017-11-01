package com.sample.boot.User.Data;

import javax.validation.constraints.NotNull;

public class UserDTO {

	private int userIdx;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String externalId;
	
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}	
}
