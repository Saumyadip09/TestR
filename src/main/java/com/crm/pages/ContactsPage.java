package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsText;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company_Name;
	
	@FindBy(xpath = "//input[@type='submit' and @value ='Save']")
	WebElement savebtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean contactsLabel()
	{
		return contactsText.isDisplayed();
	}
	
	public void selectContacts(String name)
	{
		
	}
	
	public void createNewContact(String title,String firstname,String lastname,String company)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company_Name.sendKeys(company);
		savebtn.click();
		
	}

}
