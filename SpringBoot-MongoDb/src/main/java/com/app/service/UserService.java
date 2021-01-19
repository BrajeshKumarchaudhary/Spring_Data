package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.app.model.FaceBookUser;
import com.app.model.User;
import com.app.repo.FaceBookUserRepo;
import com.app.repo.UserRepo;
import com.app.request.FBUserRequest;
import com.app.request.UserRequest;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	FaceBookUserRepo faceBookUserRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public User createUser(UserRequest requestBody) {
		User user = new User();
		user.setName(requestBody.getName());
		user.setUserContactData(requestBody.getUserContactData());
		return userRepo.save(user);
	}

	public FaceBookUser createFBUser(FBUserRequest requestBody) {
		FaceBookUser fbUser = new FaceBookUser();
		fbUser.setName(requestBody.getName());
		fbUser.setUserFriendsData(requestBody.getUserFriendsData());
		fbUser.setUserPostData(requestBody.getUserPostData());
		return faceBookUserRepo.save(fbUser);
	}

	public FaceBookUser getFbUser(String userId) {
		return faceBookUserRepo.findById(userId).get();
	}

	public User getUser(String userId) {
		return userRepo.findById(userId).get();
	}

	public List<FaceBookUser> getAllUser() {
		Query query = new Query();
		query.addCriteria(Criteria.where("_class").is("com.app.model.FaceBookUser"));
		List<FaceBookUser> users = mongoTemplate.find(query, FaceBookUser.class);
		return users;
	}

}
