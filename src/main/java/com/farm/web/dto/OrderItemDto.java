package com.farm.web.dto;

public class OrderItemDto {
	
	private int id;
	private int status;
	private String field;
	private String query;
	private int size;
	private int offset;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
		return "OrderItemDto [id=" + id + ", status=" + status + ", field=" + field + ", query=" + query + ", size="
				+ size + ", offset=" + offset + "]";
	}
	

}
