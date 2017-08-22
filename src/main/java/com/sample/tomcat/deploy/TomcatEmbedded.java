package com.sample.tomcat.deploy;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;

public class TomcatEmbedded extends TomcatEmbeddedServletContainer{
	
	private static TomcatEmbedded embedded;
	
	public static TomcatEmbedded getInstance(int port,String contextPath, String warLocation) {
		if(embedded==null){
			Tomcat tomcat = new Tomcat();
			tomcat.setPort(8989);
			new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
			tomcat.setBaseDir("I:/temp");
			tomcat.getServer().setParentClassLoader(TomcatEmbedded.class.getClassLoader());
			try {
				tomcat.addWebapp(contextPath, warLocation);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			embedded = new TomcatEmbedded(tomcat);
		}
		return embedded;
	}
	
	

     public TomcatEmbedded(Tomcat tomcat) {
		super(tomcat);
		// TODO Auto-generated constructor stub
	}

	 
}
