package com.java.app.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.ws.soap.Addressing;

@org.springframework.data.elasticsearch.annotations.Document(indexName = "employee", type = "employee")
@Data
public class FullEmployee {
	@Id
	@NotNull(message = "Please Provide Id")
	private String id;
	@NotNull(message = "Please Provide Employee Type Like fresher or Exp")
	private String empType;
	@NotNull(message = "Please Provide Employee Post Title")
	private String empPostTitle;
	@NotNull(message = "Please Provide Employee Phone number")
	private String employeePhone;
	@NotNull(message = "Please Provide Employee Previous organisation")
	private String employeepreviousorg;

	public void FullEmployee() {

	}

	public FullEmployee(String id, String empType, String empPostTitle, String employeePhone,
			String employeepreviousorg) {
		super();
		this.id = id;
		this.empType = empType;
		this.empPostTitle = empPostTitle;
		this.employeePhone = employeePhone;
		this.employeepreviousorg = employeepreviousorg;
	}

	@Override
	public String toString() {
		return "FullEmployee [id=" + id + ", empType=" + empType + ", empPostTitle=" + empPostTitle + ", employeePhone="
				+ employeePhone + ", employeepreviousorg=" + employeepreviousorg + "]";
	}

}
