package org.dnyanyog.controller;


import java.util.List;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userService;
	
	@PostMapping(path="/auth/user",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public UserResponse addUpdateUser(@RequestBody UserRequest userRequest) {	
		return userService.addUpdateUser(userRequest);
	}
}
	
