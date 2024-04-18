package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='Ratnasree Pantham']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]//parent::a")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]//parent::a")
	WebElement calenderLink;
	

	@FindBy(xpath = "//span[contains(text(),'Deals')]//parent::a")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]//parent::a")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
		action.click(contactsLink).build().perform();
		
	}
	public void clickOnNewCalenderLink(){
		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
		action.click(calenderLink).build().perform();
		
	}
	
	
	
	
	
	

}
