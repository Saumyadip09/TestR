package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	 LoginPage loginPage;
	 HomePage homePage;
	 TestUtil testUtil;
	 ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage =loginPage.Login(prop.getProperty("Username"),prop.getProperty("Password"));
		testUtil.switchToFrame();
		contactsPage = homePage.contactsPageLink();
	}
	
	//@Test(priority =1)
	public void validateContactsLabelTest()
	{
		
		Assert.assertTrue(contactsPage.contactsLabel(),"Contacts Label is missing on the page");
	}
	
	@Test(priority =2)
	public void validateCreateNewContact() throws InterruptedException
	{
		homePage.clickonNewContactLink();
		contactsPage.createNewContact("Dr.","Saumyadip","Dasgupta","ABC");
	}
	
	

	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
