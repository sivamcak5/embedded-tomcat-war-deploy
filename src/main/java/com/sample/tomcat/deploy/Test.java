package com.sample.tomcat.deploy;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

public class Test {
	
	@Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
		return new TomcatEmbeddedServletContainerFactory() {

	        @Override
	        protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
	                Tomcat tomcat) {
	            new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();

	            try {
	                Context context = tomcat.addWebapp("/simplewar", "I:/git/embedded-tomcat-war-deploy/src/main/resources/simplewar.war");
	                context.setParentClassLoader(getClass().getClassLoader());
	            } catch (ServletException ex) {
	                throw new IllegalStateException("Failed to add webapp", ex);
	            }
	            return super.getTomcatEmbeddedServletContainer(tomcat);
	        }

	    };
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 SpringApplication.run(Test.class, args);
		 
		
		 
	}

}
