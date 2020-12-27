package com.app.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Certificate {
    private String course;
    private int certificate_year;
    
    
    
	public Certificate(String course, int certificate_year) {
		this.course = course;
		this.certificate_year = certificate_year;
	}
	public Certificate() {
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getCertificate_year() {
		return certificate_year;
	}
	public void setCertificate_year(int certificate_year) {
		this.certificate_year = certificate_year;
	}

}
