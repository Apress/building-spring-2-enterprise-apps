package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class FactoryObjectIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
   
      ConfigurableListableBeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
              "com/apress/springbook/chapter02/socket-factory.xml"
            )
         );

      java.net.Socket localhost =
         (java.net.Socket)beanFactory.getBean("localhost");

      java.net.Socket apressDotCom =
         (java.net.Socket)beanFactory.getBean("apress.com");

      assertTrue(localhost.isConnected());

      assertTrue(apressDotCom.isConnected());

   }
}
