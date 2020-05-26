package com.java.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.app.service.ElasticSchemaHandellerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Create and Delete Index")
public class ElasticSchemaController {
	Logger log = LoggerFactory.getLogger(ElasticSchemaController.class);
	@Autowired
	ElasticSchemaHandellerService elasticservice;

	@GetMapping(value = "/createindex/{indexname}/{indextype}")
	@ApiOperation(value = "Create index by passing index name")
	public String createIndex(
			@RequestParam(value = "indexname", required = true) @ApiParam(value = "example:employee", required = true, name = "indexname") String indexname,
			@RequestParam(value = "indextype", required = true) @ApiParam(value = "example:fulltime", required = true, name = "indextype") String indextype) {
		String message = "";
		boolean check = false;
		try {
			switch (indexname) {
			case "employee":
				log.info("Controller called");
				check = elasticservice.createIndex(indexname);
				break;
			default:
				check = false;
			}
			if (check) {
				message = "Indexed created Successfully";
			} else {
				message = "Index Not Created due to some Issue";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("Exception occured--" + ex.getMessage());
		}
		return message;
	}
	@GetMapping(value = "/deleteindex/{indexname}/{indextype}")
	@ApiOperation(value = "Delete index by passing index name")
	public String deleteIndex(
			@RequestParam(value = "indexname", required = true) @ApiParam(value = "example:employee", required = true, name = "indexname") String indexname,
			@RequestParam(value = "indextype", required = true) @ApiParam(value = "example:fulltime", required = true, name = "indextype") String indextype) {
		String message = "";
		boolean check = false;
		try {
			switch (indexname) {
			case "employee":
				log.info("Controller called");
				check = elasticservice.deleteIndex(indexname);
				break;
			default:
				check = false;
			}
			if (check) {
				message = "Indexed deleted Successfully";
			} else {
				message = "Index Not deleted due to some Issue";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("Exception occured--" + ex.getMessage());
		}
		return message;
	}
	@GetMapping(value = "/createindexwithsetting/{indexname}/{indextype}")
	@ApiOperation(value = "Create  index by passing index name and setting value")
	public String createIndexWithSetting(
			@RequestParam(value = "indexname", required = true) @ApiParam(value = "example:employee", required = true, name = "indexname") String indexname,
			@RequestParam(value = "indextype", required = true) @ApiParam(value = "example:fulltime", required = true, name = "indextype") String indextype) {
		String message = "";
		boolean check = false;
		try {
			switch (indexname) {
			case "employee":
				log.info("Controller called");
				check = elasticservice.createIndexwithSetting(indexname);
				break;
			default:
				check = false;
			}
			if (check) {
				message = "Indexed deleted Successfully";
			} else {
				message = "Index Not deleted due to some Issue";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("Exception occured--" + ex.getMessage());
		}
		return message;
	}
	
	
}
