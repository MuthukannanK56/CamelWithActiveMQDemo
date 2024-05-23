package com.demowithcamel.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqMessageProducerRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		//Generate a message in every 60 seconds
		from("timer:active-mq-timer?period=6000")
		
		//msg that send to consumer
		.transform().constant("If you are able to read this. Wow it's working...")
		
		.log("${body}")
		  .process(exchange -> {
              String convertedMessage = exchange.getMessage().getBody() + " is converted";
              exchange.getMessage().setBody(convertedMessage);
          })
		
		//send message to activemq
		.to("activemq:Producer");
		
		
		

		}
		
	}
	

