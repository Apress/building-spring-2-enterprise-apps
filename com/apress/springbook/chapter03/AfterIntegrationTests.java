package com.apress.springbook.chapter03;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;

public class AfterIntegrationTests extends TestCase {

  private static BeanFactory beanFactory = new XmlBeanFactory(
    new ClassPathResource(
        "com/apress/springbook/chapter03/after-tests.xml"
      )
    );

  private static InitializingBeanNameClass testBean;

    public static void main(String[] args) {
	testBean = (InitializingBeanNameClass)beanFactory.getBean("afterBean");

	testBean.showValues();
    }

}
