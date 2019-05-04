package com.inetBanking.Test;

import java.io.IOException;
import org.testng.annotations.Test;
import com.inetBanking.PageObjects.LoginPage;
import junit.framework.Assert;

public class Login_TC001 extends BaseClass {
	
	
	@Test()
	public void LoginTest() throws IOException {
	
	logger.info("URLis opened");
	
	driver.manage().window().maximize();
	
	LoginPage lp = new LoginPage(driver);
	
	logger.info("Login Testcase Started");
	logger.info("Validate Login");
	lp.ValidateLogin(UserId);
	logger.info("Login with UserId & Pwd");
	lp.UsrLogin(UserId, Password);
	
	if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager Home Page")) {
		
		Assert.assertTrue(true);
		logger.info("Login Sucessful");
	}
	
	else {
		Assert.assertTrue(false);
		logger.info("Login Failed");
		screenshot(driver,"LoginTest");
		
	}
	
}

}