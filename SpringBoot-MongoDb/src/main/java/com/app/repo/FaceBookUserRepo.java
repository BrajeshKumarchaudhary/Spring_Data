package com.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.FaceBookUser;

@Repository
public interface FaceBookUserRepo extends MongoRepository<FaceBookUser, String> {

//	@Query("_class:com.app.model.FaceBookUser")
//	List<FaceBookUser> findAll();
}
