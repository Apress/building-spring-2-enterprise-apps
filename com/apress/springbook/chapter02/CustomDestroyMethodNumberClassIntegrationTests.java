package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class CustomDestroyMethodNumberClassIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
      ConfigurableListableBeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
              "com/apress/springbook/chapter02/custom-destroy-method.xml"
            )
         );

      CustomDestroyMethodNumberClass numberClass =
         (CustomDestroyMethodNumberClass)beanFactory.getBean("numberClass");

      beanFactory.destroySingletons();

      assertNull(numberClass.getNumbers());
   }
}
