package com.rnd.pc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service {
	
	private String serviceId;
	
	private String serviceDescription;
	
	private String serviceType;
	
	private ServiceSpecification serviceSpecification;

	public Service(String serviceId, String serviceDescription, String serviceType,
			ServiceSpecification serviceSpecification) {
		super();
		this.serviceId = serviceId;
		this.serviceDescription = serviceDescription;
		this.serviceType = serviceType;
		this.serviceSpecification = serviceSpecification;
	}
	
	

	public Service() {
		super();
	}



	public String getServiceId() {
		return serviceId;
	}



	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}



	public String getServiceDescription() {
		return serviceDescription;
	}



	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	public ServiceSpecification getServiceSpecification() {
		return serviceSpecification;
	}



	public void setServiceSpecification(ServiceSpecification serviceSpecification) {
		this.serviceSpecification = serviceSpecification;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceDescription == null) ? 0 : serviceDescription.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((serviceSpecification == null) ? 0 : serviceSpecification.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
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
		Service other = (Service) obj;
		if (serviceDescription == null) {
			if (other.serviceDescription != null)
				return false;
		} else if (!serviceDescription.equals(other.serviceDescription))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (serviceSpecification == null) {
			if (other.serviceSpecification != null)
				return false;
		} else if (!serviceSpecification.equals(other.serviceSpecification))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceDescription=" + serviceDescription + ", serviceType="
				+ serviceType + ", serviceSpecification=" + serviceSpecification + "]";
	}
	
	

}
