package com.spring.learning;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloSpring implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		 System.out.println("AfterInitialization : " + beanName);
	     return bean;  // you can return any other object as well
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		 System.out.println("BeforeInitialization : " + beanName);
	     return bean;  // you can return any other object as well
	}

}
