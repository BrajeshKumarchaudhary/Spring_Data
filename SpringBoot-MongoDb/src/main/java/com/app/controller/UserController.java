package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.FaceBookUser;
import com.app.model.User;
import com.app.request.FBUserRequest;
import com.app.request.UserRequest;
import com.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/createUser",consumes = "Application/json")
	public User createUser(@RequestBody UserRequest requestBody) {
		return userService.createUser(requestBody);
	}
	
	@PostMapping(value = "/createFbUser",consumes = "Application/json")
	public FaceBookUser createFBUser(@RequestBody FBUserRequest requestBody) {
		return userService.createFBUser(requestBody);
	}
	
	@GetMapping(value = "/getFbUserById")
	public FaceBookUser getFBUser(@RequestParam(name = "userId") String userId) {
		return userService.getFbUser(userId);
	}
	
	@GetMapping(value = "/getUserById")
	public User getUser(@RequestParam(name = "userId") String userId) {
		return userService.getUser(userId);
	}
	
	@GetMapping(value = "/getAllFBUser")
	public List<FaceBookUser> getAllUser() {
		return userService.getAllUser();
	}
}
