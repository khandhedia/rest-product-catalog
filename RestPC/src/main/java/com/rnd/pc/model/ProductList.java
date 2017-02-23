package com.rnd.pc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductList {
	
	private List<Object> productList;

	public List<Object> getProductList() {
		return productList;
	}

	public void setProductList(List<Object> productList) {
		this.productList = productList;
	}
	
	

}
