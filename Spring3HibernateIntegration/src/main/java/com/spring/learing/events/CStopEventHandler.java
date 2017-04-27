/**
 * 
 */
package com.spring.learing.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author as47775
 *
 */
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("ContextStoppedEvent Received");
	}

}
