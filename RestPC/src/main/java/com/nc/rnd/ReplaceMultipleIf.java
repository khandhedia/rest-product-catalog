package com.nc.rnd;

import java.util.HashSet;
import java.util.Set;

public class ReplaceMultipleIf {
	
	public static final String NODE_TEMP_UPLOAD = "nodeTempUpload";
	public static final String SERVER_NOTIFICATION_SEND = "serverNotificationSend";
	public static final String CREATE_NODE = "createNode";
	public static final String VNFP_NOTIFICATIONS = "vnfpNotifications";
	public static final String PROCESS_MONITORING_ACKNOWLEDGEMENT = "processMonitoringAcknowledgement";
	

	public static void main(String[] args) {
		
		String method = "A";
		
		Set orchestratorMethodSet = new HashSet<String>();
		orchestratorMethodSet.add(NODE_TEMP_UPLOAD);
		
		Set vnfmMethodSet = new HashSet<String>();
		vnfmMethodSet.add(SERVER_NOTIFICATION_SEND);
		vnfmMethodSet.add(CREATE_NODE);
		vnfmMethodSet.add(VNFP_NOTIFICATIONS);
		vnfmMethodSet.add(PROCESS_MONITORING_ACKNOWLEDGEMENT);
		
        if (orchestratorMethodSet.contains(method))
            System.out.println("Orchestrator");
        else if (vnfmMethodSet.contains(method))
            System.out.println("VNFM");
        else 
        	System.out.println("NFVO");
	
	}

}
