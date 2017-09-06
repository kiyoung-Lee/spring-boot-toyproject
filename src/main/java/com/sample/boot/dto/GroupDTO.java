package com.sample.boot.dto;

import org.joda.time.DateTime;

public class GroupDTO {
	
	private int groupIdx;
	private String groupName;
	private String thumbnail;
	private String date;
	
	public int getGroupIdx() {
		return groupIdx;
	}
	public void setGroupIdx(int groupIdx) {
		this.groupIdx = groupIdx;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
