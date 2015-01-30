package com.actimem.example.jmx.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
public class JmxSpringMain {
    @Bean
    public Resource jmxResource() {
        return new Resource();
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JmxSpringMain.class);
        Resource resource = context.getBean(Resource.class);
        resource.addItem("Item");
        Thread.sleep(Long.MAX_VALUE);
    }
}
