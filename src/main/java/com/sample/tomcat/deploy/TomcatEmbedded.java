package com.sample.tomcat.deploy;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;

public class TomcatEmbedded extends TomcatEmbeddedServletContainer{

     public TomcatEmbedded(Tomcat tomcat) {
		super(tomcat);
		// TODO Auto-generated constructor stub
	}

	public static void start(String contextPath, String warLocation){
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8989);
		//tomcat.addContext(contextPath,  new File(warLocation).getAbsolutePath());
		new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
		try {
			tomcat.addWebapp(contextPath, warLocation);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TomcatEmbedded embedded = new TomcatEmbedded(tomcat);
		embedded.start();
     }
}
