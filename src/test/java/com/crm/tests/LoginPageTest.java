package com.crm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	
	public  LoginPage loginPage;
	public  HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority =1)
	public void crmLogoDisplay()
	{
		Assert.assertTrue(loginPage.crmLogoValidation());
		
	}
	
	@Test(priority =2)
	public void crmLoginPageTitleValidation()
	{
		String title = loginPage.crmLoginPageTitleValidation();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	}
	
	@Test(priority =3)
	public void LogintoCrmApplication() throws InterruptedException
	{
		Thread.sleep(2000);
		homePage =loginPage.Login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
