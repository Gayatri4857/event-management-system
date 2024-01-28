package org.dnyanyog.dto;

public class FeedBackRequest {
private String username;

	
	private String Email;


	private String FeedBack;
	
	private String FeedBackemoji;

	public String getFeedBackemoji() {
		return FeedBackemoji;
	}

	public void setFeedBackemoji(String feedBackemoji) {
		FeedBackemoji  = feedBackemoji;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFeedBack() {
		return FeedBack;
	}

	public void setFeedBack(String feedBack) {
		FeedBack = feedBack;
	}

}
