package com.inetBanking.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

import com.inetBanking.Utilities.ReadExcel;

import junit.framework.Assert;

public class Login_DD001 extends BaseClass{
	
	@DataProvider(name="NetBanking")
	public Object[][]dp() throws IOException{
		
		ReadExcel oExcelRd = new ReadExcel(System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/TestData1.xlsx","Login");
		return oExcelRd.readcelldata();
		
	}
	
	@Test(dataProvider="NetBanking")
	
	public void LoginTest01(String UserId,String Password ) throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Login validation Started");
			
		lp.UsrLogin(UserId, Password);
		
		if (Isalert()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			Assert.assertTrue(false);
			logger.warning("Login Failed");
			screenshot(driver,"LoginTest01");
			
		} else {
			
			Assert.assertTrue(true);
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			logger.info("Login succesful");
		}
		
	}

	public boolean Isalert() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e) {
			
		return false;
		}
		
	}

}
