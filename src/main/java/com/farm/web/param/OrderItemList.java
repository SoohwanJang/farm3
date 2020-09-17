package com.farm.web.param;

public class OrderItemList {
	
	private int id;
	private String status;
	private String field;
	private String query;
	private int size;
	private int offset;
	
	public OrderItemList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderItemList(int id, String status, String field, String query, int size, int offset) {
		super();
		this.id = id;
		this.status = status;
		this.field = field;
		this.query = query;
		this.size = size;
		this.offset = offset;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@Override
	public String toString() {
		return "OrderItemListParam [id=" + id + ", status=" + status + ", field=" + field + ", query=" + query
				+ ", size=" + size + ", offset=" + offset + "]";
	}
	
	

}
