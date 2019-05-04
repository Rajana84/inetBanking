package com.inetBanking.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='menusubnav']//a[text()='New Customer']")WebElement NewCustlink;
	@FindBy(xpath="//input[@name='name']")WebElement CustName;
	@FindBy(xpath="//input[@id='dob']")WebElement DoB;
	@FindBy(xpath="//textarea[@name='addr']")WebElement Addrs;
	@FindBy(xpath="//input[@name='city']")WebElement City;
	@FindBy(xpath="//input[@name='state']")WebElement State;
	@FindBy(xpath="//input[@name='pinno']")WebElement PIN;
	@FindBy(xpath="//input[@name='telephoneno']")WebElement MobileNum;
	@FindBy(xpath="//input[@name='emailid']")WebElement Email;
	@FindBy(xpath="//input[@name='password']")WebElement Password;
	@FindBy(xpath="//input[@value='Submit']") WebElement Submit;
	
	public NewCustomer(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void cusDtls(String cName,String date,String gender) {
		
		NewCustlink.click();
		CustName.sendKeys(cName);
		
		List<WebElement> gen = driver.findElements(By.xpath("//input[@name='rad1']"));
		int cnt = gen.size();
		for(int i=0;i<cnt;i++) {
		 gen.get(i).getAttribute("value").equals(gender);
		 gen.get(i).click();
		}
		 DoB.sendKeys(date);
		 
		}
	
	
	public void locDtls(String adrs,String city,String state,String pin ) {
		
		Addrs.sendKeys(adrs);	
		City.sendKeys(city);
		State.sendKeys(state);
		PIN.sendKeys(pin);
	}
		
	public void commDtls(String mobNum,String email,String pwd) {
		
		MobileNum.sendKeys(mobNum);
		Email.sendKeys(email);
		Password.sendKeys(pwd);
	}
	
	
	public void submit() {
		Submit.click();
	}
	
	
	

}
