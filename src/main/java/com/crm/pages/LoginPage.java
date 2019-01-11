 package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath ="//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	@FindBy(name = "username")
	WebElement Username;
	
	@FindBy(name ="password")
	WebElement Password;
	
	@FindBy(xpath ="//input[@class='btn btn-small']" )
	WebElement LoginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean crmLogoValidation()
	{
		return crmLogo.isDisplayed();
	}
	
	public String crmLoginPageTitleValidation()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String Uname,String Pword)
	{
		Username.sendKeys(Uname);
		Password.sendKeys(Pword);
		LoginButton.click();
		
		return new HomePage();
	}

}
