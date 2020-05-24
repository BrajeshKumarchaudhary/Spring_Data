package com.java.app.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.java.app.model.FullEmployee;
import com.java.app.repo.EmployeeRepo;
import com.java.app.utill.ElasticUtil;

@Service
public class ElasticSchemaHandellerService {
	@Autowired
	ElasticsearchTemplate elsticTemplate;
	@Autowired
	EmployeeRepo emprepo;

	/**
	 * @param index
	 * @return
	 */
	public boolean createIndex(String index) {
		boolean isindexedcreated;
		switch (index) {
		case "employee":
			isindexedcreated = elsticTemplate.createIndex(FullEmployee.class);
			break;
		default:
			isindexedcreated = false;

		}
		return isindexedcreated;

	}

	/**
	 * @param emp
	 * @returnit
	 */
	public FullEmployee indexEmployee(FullEmployee emp) {

		return emprepo.save(emp);
	}

	public Optional<FullEmployee> findEmployeeById(Long id) {
		return emprepo.findById(id);
	}

	public List<FullEmployee> findEmployeePostTitle(String post) {
		return emprepo.findByEmpPostTitle(post);
	}

	public Iterable<FullEmployee> fetchAllEmployee() {
		return emprepo.findAll();
	}

	public boolean deleteIndex(String indexname) {
		boolean isindexeddeleted;
		switch (indexname) {
		case "employee":
			isindexeddeleted = elsticTemplate.deleteIndex(FullEmployee.class);
			break;
		default:
			isindexeddeleted = false;

		}
		return isindexeddeleted;

	}

	public boolean createIndexwithSetting(String indexname) throws ExecutionException, InterruptedException {
		boolean isindexedcreated;
		switch (indexname) {
		case "employee":
			isindexedcreated = ElasticUtil.createSettings(indexname);
			break;
		default:
			isindexedcreated = false;

		}
		return isindexedcreated;	
	}

	public void  deleteAllEmployee() {
		 emprepo.deleteAll();
	}

}
