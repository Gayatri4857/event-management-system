package org.dnyanyog.controller;

import org.dnyanyog.dto.FeedBackRequest;
import org.dnyanyog.dto.FeedBackResponse;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;

import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userService;
	
	@Autowired
	UserManagementService feedbackService;
	
	@PostMapping(path="/auth/user",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public UserResponse addUpdateUser(@RequestBody UserRequest userRequest) {	
		return userService.addUpdateUser(userRequest);
	}
	
	@PostMapping(path="/auth/feedback",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public FeedBackResponse addFeedBack(@RequestBody FeedBackRequest feedbackRequest) {	
		return feedbackService.addFeedback(feedbackRequest);
	}
}
	
