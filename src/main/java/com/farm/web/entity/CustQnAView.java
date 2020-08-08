package com.farm.web.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustQnAView extends CustQnA {

	private String name;
	
	public CustQnAView() {
		
	}

	public CustQnAView(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustQnAView [name=" + name + "]";
	}
	
}
