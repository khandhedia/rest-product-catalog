package com.rnd.pc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceSpecification {
	
	private String serviceQuality;
	private String specId;
	
	
	
	public ServiceSpecification(String serviceQuality, String specId) {
		super();
		this.serviceQuality = serviceQuality;
		this.specId = specId;
	}
	
	public ServiceSpecification() {
		super();
	}


	public String getServiceQuality() {
		return serviceQuality;
	}
	public void setServiceQuality(String serviceQuality) {
		this.serviceQuality = serviceQuality;
	}
	public String getSpecId() {
		return specId;
	}
	public void setSpecId(String specId) {
		this.specId = specId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceQuality == null) ? 0 : serviceQuality.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
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
		ServiceSpecification other = (ServiceSpecification) obj;
		if (serviceQuality == null) {
			if (other.serviceQuality != null)
				return false;
		} else if (!serviceQuality.equals(other.serviceQuality))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ServiceSpecification [serviceQuality=" + serviceQuality + ", specId=" + specId + "]";
	}

	
	

}
