package com.farm.web.entity;

public class SimpleCountView {
	private String element;
	private int count;
	
	public SimpleCountView() {
		// TODO Auto-generated constructor stub
	}
	
	public SimpleCountView(String element, int count) {
		this.element = element;
		this.count = count;
	}

	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SimpleCountView [element=" + element + ", count=" + count + "]";
	}
	
	
	
}
