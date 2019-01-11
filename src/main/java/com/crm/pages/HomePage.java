package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Saumyadip Dasgupta')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//a[contains(@title,'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	
	@FindBy(xpath="//a[@title='Combined Form']")
	WebElement CombinedContactLink;
	
	@FindBy(xpath="//a[contains(@title,'Deals')]")
	WebElement DealsPageLink;
	
	@FindBy(xpath="//a[contains(@title,'Tasks')]")
	WebElement TasksPageLink;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage contactsPageLink()
	{
		 contactsPageLink.click();
		 return new ContactsPage();
	}
	
	public DealsPage dealsPageLink()
	{
		DealsPageLink.click();
		return new DealsPage();
	}
	
	public TasksPage taksPageLink()
	{
		TasksPageLink.clear();
		return new TasksPage();
	}
	
	//Data Driven Approach
	public void clickonNewContactLink() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsPageLink);
		
		NewContactLink.click();
		//Thread.sleep(2000);
		
		
		
	}

}
