package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class InitializingBeanNameClassIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
      BeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
               "com/apress/springbook/chapter02/initializing-bean.xml"
            )
         );

      InitializingBeanNameClass nameClass =
            (InitializingBeanNameClass)beanFactory.getBean("nameClass");

      assertEquals("Roger", nameClass.getFirstName());
   }
}
