package com.crm.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class HomePageTest extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public DealsPage dealsPage;
	public TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();//creation of object
		testUtil = new TestUtil();//Creation of the testUitl object
		homePage=loginPage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		
	}
	
	@Test(priority =1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.validateTitle();
		Assert.assertEquals("CRMPRO", homePageTitle,"Home Page Title doesn't match");
	}
	
	@Test(priority =2)
	public void verifyCorrectUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority =3)
	public void clickOnContactsLink()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.contactsPageLink();
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
