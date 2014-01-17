package com.tsystems.lection12.servlet;

public enum ActionType {
	
	ADD ("Add"),
	DELETE ("Delete"),
	SEARCH ("Search");

	private String type;
	
	private ActionType (String type) {
		this.type = type;
	}
	
	public String getActionType () {
		return type;
	}
	
	public String toString() {
		return type;
	}
	
}
