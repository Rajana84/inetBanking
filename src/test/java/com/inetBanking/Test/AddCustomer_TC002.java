package com.inetBanking.Test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.NewCustomer;

import com.inetBanking.Utilities.ReadExcel;

import junit.framework.Assert;

public class AddCustomer_TC002 extends BaseClass {
	
	
	@DataProvider(name="Cust")
	public Object[][]dp() throws IOException{
		
		ReadExcel oExcelRd = new ReadExcel(System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/TestData1.xlsx","AddCust");
		return oExcelRd.readcelldata();
	}
	
	@Test(dataProvider="Cust")
	public void AddCust(String UserId,String Password, String cName,String date,String gender,String adrs,String city,String state,String pin,String mobNum,String email,String pwd) throws IOException {
		
	LoginPage lp = new LoginPage(driver);
	logger.info("Login Started");
	lp.UsrLogin(UserId, Password);
	logger.info("Login successful"); 
	
	 NewCustomer oAddCust = new NewCustomer(driver);
	 logger.info("Add New Customer");
	 oAddCust.cusDtls(cName, date, gender);
	 oAddCust.locDtls(adrs, city, state, pin);
	 oAddCust.commDtls(mobNum, email, pwd);
	 oAddCust.submit();
	 logger.info("New Customer dtls entered");
	 
	 
	 	if (Isalert()==true) {
	 		
	 		logger.info("Customer not added succsfully");
			screenshot(driver,"AddCust");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			Assert.assertTrue(false);
		}
			
	 	else 
	 	{
	 	  Assert.assertTrue(true);
		  boolean text = driver.getPageSource().contains("Customer Registered Successfully!!!");
		  if (text==true) {
		   logger.info("Customer Added successfully");
	    }
			
	}
	 
	  
	}
	
	
}
