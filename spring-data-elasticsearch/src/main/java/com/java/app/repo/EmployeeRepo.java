package com.java.app.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.java.app.model.FullEmployee;
@Repository
public interface EmployeeRepo extends ElasticsearchRepository<FullEmployee, Long>{
	 List<FullEmployee> findByEmpPostTitle(String name);
	  List<FullEmployee> findByEmpType(String name);
}
