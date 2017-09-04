package com.sample.boot.dto;

import org.joda.time.DateTime;

public class GroupDTO {
	
	private int groupIdx;
	private String groupName;
	private String thumbnail;
	private DateTime date;
	
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
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
}
