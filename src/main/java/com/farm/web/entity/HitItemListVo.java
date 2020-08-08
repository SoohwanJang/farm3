package com.farm.web.entity;

import com.farm.web.entity.Item;

public class HitItemListVo extends Item{

	private int itemId;
	private int count;
	
	
	
	
	

	public HitItemListVo(int itemId, int count) {
		super();
		this.itemId = itemId;
		this.count = count;
	}
	
	int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
