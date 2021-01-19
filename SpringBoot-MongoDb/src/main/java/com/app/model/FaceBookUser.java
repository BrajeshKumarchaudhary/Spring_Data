package com.app.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userData")
public class FaceBookUser {
	@Id
	private String userId;
	private String name;
	private Date creationDate = new Date();
	private Map<String, String> userFriendsData = new HashMap<>();
	private Map<String, String> userPostData = new HashMap<>();
}
