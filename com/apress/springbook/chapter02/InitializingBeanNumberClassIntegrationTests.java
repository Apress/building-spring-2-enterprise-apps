package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class InitializingBeanNumberClassIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
       /*
      BeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
              "com/apress/springbook/chapter02/custom-initializing-method.xml"
            )
         );
       
      
      CustomInitializationMethodNumberClass numberClass =
            (CustomInitializationMethodNumberClass)beanFactory.getBean("numberClass");

      assertEquals(3, numberClass.getNumbers().size());
      */
   
      ConfigurableListableBeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
              "com/apress/springbook/chapter02/disposable-bean.xml"
            )
         );


      DisposableBeanNumberClass numberClass =
         (DisposableBeanNumberClass)beanFactory.getBean("numberClass");

      beanFactory.destroySingletons();

      assertNull(numberClass.getNumbers());

   }
}
