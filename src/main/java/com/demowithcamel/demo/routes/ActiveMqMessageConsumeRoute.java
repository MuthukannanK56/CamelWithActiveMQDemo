package com.demowithcamel.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import com.nys.corban.service.EmailalertService;

@Component

public class ActiveMqMessageConsumeRoute extends RouteBuilder {

//	private final Logger Log = LoggerFactory.getLogger(ActiveMqMessageConsumeRoute.class);
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		//receiving message from "Producer" queue 
		 from("activemq:Producer")
		 
		 //log message
		 .to("log:Received")

		 
		 //creating receiving queue "Receiver"
         .to("activemq:Receiver");
		
		
		    
//		    public void  handleBarEvent(Message in) {
//		        Log.info(in);
//		    }
//
//		    public void handleOtherEvent(Message in) {
//		        Log.info(in);
//		    }
		
	}
}
