package com.automation.pim.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
			

	public String getApplicationURL() {
		
		String url=pro.getProperty("baseURL");
		return url;
	
	}
	
	public String getUsername() {
		
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getUsername1() {
		
		String username=pro.getProperty("username1");
		return username;
	}
	
	public String getPassword1() {
		
		String password=pro.getProperty("password1");
		return password;
	}
	
	public String getSignUpUsername() {
		
		String signUpUsername=pro.getProperty("signupid");
		return signUpUsername;
	}
	
	public String getSignUpPassword() {
		
		String signUpPassword=pro.getProperty("signupPass");
		return signUpPassword;
	}
	
	
	public String getChromePath() {
		
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath() {
		
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath() {
		
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}

}
