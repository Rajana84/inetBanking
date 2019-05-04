package com.inetBanking.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	@FindBy(name="uid") WebElement UserId;
	@FindBy(name="password")WebElement Password;
	@FindBy(name="btnLogin")WebElement Login;
	@FindBy(xpath="//ul[@class='menusubnav']//a[text()='Log out']")WebElement Logout;
	
	
	public LoginPage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void UsrLogin(String Unam,String Pwd) {
	
		UserId.sendKeys(Unam);
		Password.sendKeys(Pwd);
		Login.click();

	}
	
	public void logout() {
		Logout.click();
	}
	
	public void ValidateLogin(String Unam) {
		UserId.sendKeys(Unam);
		Login.click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
	}

}