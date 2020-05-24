package com.java.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.java.app.model.FullEmployee;
import com.java.app.service.ElasticSchemaHandellerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Employee")
@RequestMapping(value = "/employee")
public class EmployeeController {
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	ElasticSchemaHandellerService elasticservice;

	@RequestMapping(value = "/createemployee", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" })
	public String createEmployee(
			@ApiParam(name = "employee", value = "request Data:{\n" + "\"id\":1,\n" + "\"empType\":fulltime,\n"
					+ "\"empPostTitle\":\"Software Engineer\",\n" + "\"employeePhone\":\"9956230356\",\n"
					+ "\"employeepreviousorg\":\"Square Yards\"\n"
					+ "}", required = true) @Valid @RequestBody FullEmployee employee)
			throws JsonMappingException, JsonProcessingException {
		FullEmployee check = null;
		String message = "";
		check = elasticservice.indexEmployee(employee);
		try {
			if (check != null) {
				message = "Indexed Successfully";
			} else {
				message = "Indxed Not Done";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("Exception occured--" + ex.getMessage());
		}
		return message;
	}

	@GetMapping(value = "/fetch/{id}")
	@ApiOperation(value = "Fetch Employee by employee id")
	public Optional<FullEmployee> getBydId(@RequestParam("id") @ApiParam(value = "id") Long id) {
		try {
			return elasticservice.findEmployeeById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/fetch/{postTtile}")
	@ApiOperation(value = "Fetch Employee by passing post title")
	public List<FullEmployee> getByPostTitle(@RequestParam("postTtile") @ApiParam(value = "postTtile") String post) {
		try {
			return elasticservice.findEmployeePostTitle(post);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/fetch/all")
	@ApiOperation(value = "Fetch  All Employee")
	public List<FullEmployee> fetchAll() {
		List<FullEmployee> documents = new ArrayList<>();
		try {
			for (FullEmployee doc : elasticservice.fetchAllEmployee()) {
	            documents.add(doc);
	        }
			return documents ;
		} catch (Exception ex) {
			log.info("Something went wrong--"+ex.getMessage());
			ex.printStackTrace();
			
		}
		return documents;
	}
	
	@GetMapping(value = "/delete/all")
	@ApiOperation(value = "delete  All Employee")
	public String deleteAll() {
		try {
			 elasticservice.deleteAllEmployee();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "All data deleted successfully!";
	}

}
