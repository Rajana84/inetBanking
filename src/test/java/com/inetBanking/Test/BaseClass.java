package com.inetBanking.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.Readconfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	Readconfig oreadconfig = new Readconfig();
	public String URL = oreadconfig.getAppUrl();
	public String UserId = oreadconfig.getUsrName();
	public String Password = "ajAgugY";
	  WebDriver driver;
	  Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String Browsr) {
		
		logger = Logger.getLogger("NetBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (Browsr.equals("Chrome")) {
			
		 System.setProperty("webdriver.chrome.driver",oreadconfig.getchromePath());
		 driver = new ChromeDriver();

		} else if (Browsr.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", oreadconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.close();
		//driver.quit();
	}
	
	
	public void screenshot(WebDriver driver,String tname) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	  }

	/*public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}	*/ 
	 
	public boolean Isalert() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e) {
			
		return false;
		}
		
	}
}
