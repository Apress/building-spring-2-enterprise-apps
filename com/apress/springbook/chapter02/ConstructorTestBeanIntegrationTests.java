package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;

public class ConstructorTestBeanIntegrationTests extends TestCase {

  private static BeanFactory beanFactory = new XmlBeanFactory(
    new ClassPathResource(
        "com/apress/springbook/chapter02/test-bean-tests.xml"
      )
    );

  private static ConstructorTestBean testBean;

  static {
    testBean = (ConstructorTestBean)beanFactory.getBean("testBean");
  }

  public void testIsConstructor1Used() {
    assertTrue(testBean.isConstructor1Used());
  }

  public void testIsConstructor2NotUsed() {
    assertFalse(testBean.isConstructor2Used());
  }
}
