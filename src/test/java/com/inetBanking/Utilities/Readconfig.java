package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Readconfig {

	Properties prop;

	public Readconfig(){

		/* ./ -- > POINTS TO PROJECT DIRECTORY{use in java and utilities files)
		 * SYSTEM.GET PROPERTY ---> points to PROJECT DIECTORY{usein java class only}
		 */
		try {
		File src = new File("./Configuration/config.properties");

		FileInputStream oFIS = new FileInputStream(src);
		prop = new Properties();
		prop.load(oFIS);
		}
		catch(Exception e) {
			System.out.println("Emptyfile");
		}
	}

	public String getAppUrl() {

		String url = prop.getProperty("URL");
		return url;
	}

	public String getUsrName() {

		String usr = prop.getProperty("UserId");
		return usr;
	}
	
	public String getchromePath() {

		String cPath = prop.getProperty("ChromePath");
		return cPath;
	}
	
	public String getFirefoxPath() {

		String fPath = prop.getProperty("FirefoxPath");
		return fPath;
	}
	
}
