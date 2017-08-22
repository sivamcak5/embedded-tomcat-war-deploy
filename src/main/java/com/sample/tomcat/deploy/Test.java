package com.sample.tomcat.deploy;

public class Test {
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TomcatEmbedded embedded = TomcatEmbedded.getInstance(8989,"", "I:/git/embedded-tomcat-war-deploy/src/main/resources/ROOT.war");
		embedded.start();
		
		try {
			Thread.currentThread().wait(10000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		embedded.stop();
		 
	}

	
}
