package com.rnd.pc.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private String productId;
	
	private String productDescription;
	
	private Service customerServices[];
	
	private Service resourceServices[];
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Service[] getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(Service[] customerServices) {
		this.customerServices = customerServices;
	}

	public Service[] getResourceServices() {
		return resourceServices;
	}

	public void setResourceServices(Service[] resourceServices) {
		this.resourceServices = resourceServices;
	}

	public Product(String productId, String productDescription, Service[] customerServices,
			Service[] resourceServices) {
		super();
		this.productId = productId;
		this.productDescription = productDescription;
		this.customerServices = customerServices;
		this.resourceServices = resourceServices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(customerServices);
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + Arrays.hashCode(resourceServices);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (!Arrays.equals(customerServices, other.customerServices))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (!Arrays.equals(resourceServices, other.resourceServices))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDescription=" + productDescription + ", customerServices="
				+ Arrays.toString(customerServices) + ", resourceServices=" + Arrays.toString(resourceServices) + "]";
	}
	
	

}
