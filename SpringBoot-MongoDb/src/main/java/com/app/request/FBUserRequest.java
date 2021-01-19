package com.app.request;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FBUserRequest {
	private String name;
	private Map<String, String> userFriendsData = new HashMap<>();
	private Map<String, String> userPostData = new HashMap<>();
	
}
