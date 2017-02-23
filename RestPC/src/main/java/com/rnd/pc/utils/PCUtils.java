package com.rnd.pc.utils;

import com.rnd.pc.model.Product;
import com.rnd.pc.model.Service;
import com.rnd.pc.model.ServiceSpecification;

public class PCUtils {

	public static ServiceSpecification createSpec(String serviceQuality, String specId) {
		return new ServiceSpecification(serviceQuality, specId);
	}

	public static Service createService(ServiceSpecification serviceSpecification, String serviceId, String serviceDescription, String serviceType) {
		return new Service(serviceId, serviceDescription, serviceType, serviceSpecification);
	}

	public static Product createProduct(String productId, String productDescription, Service[] customerServices, Service[] resourceServices) {
		return new Product(productId, productDescription, customerServices, resourceServices);
	}

}
