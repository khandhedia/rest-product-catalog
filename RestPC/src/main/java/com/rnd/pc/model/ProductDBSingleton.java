package com.rnd.pc.model;

import java.util.HashMap;
import java.util.Map;

import com.rnd.pc.utils.PCUtils;

public class ProductDBSingleton {

	private static ProductDBSingleton instance;

	private ProductDBSingleton() {
		if (null == productMap)
			productMap = new HashMap<String, Product>();
		if (null == CFServiceMap)
			CFServiceMap = new HashMap<String, Service>();
		if (null == RFServiceMap)
			RFServiceMap = new HashMap<String, Service>();
		if (null == specMap)
			specMap = new HashMap<String, ServiceSpecification>();
		if (productMap.isEmpty())
			addDummyProduct();
	}

	private Map<String, Product> productMap;
	private Map<String, Service> CFServiceMap;
	private Map<String, Service> RFServiceMap;
	private Map<String, ServiceSpecification> specMap;

	public Map<String, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Product> productMap) {
		this.productMap = productMap;
	}

	public Map<String, Service> getCFServiceMap() {
		return CFServiceMap;
	}

	public void setCFServiceMap(Map<String, Service> cFServiceMap) {
		CFServiceMap = cFServiceMap;
	}

	public Map<String, Service> getRFServiceMap() {
		return RFServiceMap;
	}

	public void setRFServiceMap(Map<String, Service> rFServiceMap) {
		RFServiceMap = rFServiceMap;
	}

	public Map<String, ServiceSpecification> getSpecMap() {
		return specMap;
	}

	public void setSpecMap(Map<String, ServiceSpecification> specMap) {
		this.specMap = specMap;
	}

	public static ProductDBSingleton getInstance() {
		if (null == instance)
			instance = new ProductDBSingleton();
		return instance;
	}

	private void addDummyProduct() {
		String serviceQuality = "Dummy";
		String specId1 = "spid1";
		ServiceSpecification spec = PCUtils.createSpec(serviceQuality, specId1);

		this.getSpecMap().put(specId1, spec);

		String serviceQuality2 = "Dummy2";
		String specId2 = "spid2";
		ServiceSpecification spec2 = PCUtils.createSpec(serviceQuality2, specId2);
		this.getSpecMap().put(specId2, spec2);

		String sid = "sid1";
		String sdesc = "sdesc1";
		String stype = "CFS";
		Service CFService = PCUtils.createService(spec, sid, sdesc, stype);
		this.getCFServiceMap().put(sid, CFService);

		String sid2 = "sid2";
		String sdesc2 = "sdesc2";
		String stype2 = "RFS";
		Service RFService = PCUtils.createService(spec2, sid2, sdesc2, stype2);
		this.getRFServiceMap().put(sid2, RFService);

		String pid = "pid1";
		String pdesc = "pdesc1";

		Product product = PCUtils.createProduct(pid, pdesc, new Service[] { CFService }, new Service[] { RFService });
		this.getProductMap().put(pid, product);
	}

}
