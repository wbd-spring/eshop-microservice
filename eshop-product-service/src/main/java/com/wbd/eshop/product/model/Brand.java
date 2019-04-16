package com.wbd.eshop.product.model;

import java.io.Serializable;
/**
 * 品牌ID
 * @author zgh
 *
 */
public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//品牌名称
	private String name;
	//品牌描述
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
