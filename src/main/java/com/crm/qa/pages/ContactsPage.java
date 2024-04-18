package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id='dashboard-toolbar']//child::span[normalize-space()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(css="input[name='company']")
	WebElement company;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement createContact;

	@FindBy(xpath="//button[normalize-space()='Public']")
	WebElement publicButton;
	
	@FindBy(xpath="//label[text()='Category']/following-sibling::div//span")
	List<WebElement> categoryList;
	
	@FindBy(xpath="//label[text()='Status']/following-sibling::div//span")
	List<WebElement> statusList;
	
	@FindBy(xpath="//div[normalize-space()='Select users allowed access.']/following-sibling::div//span[.='Ratnasree Pantham']")
	List<WebElement> accessList;
	
	@FindBy(xpath="//label[text()='Source']/following-sibling::div//span")
	List<WebElement> sourceList;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title, String ftName, String ltName, String comp) throws InterruptedException{
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
		createContact.click();
//		WebDriverWait wait=new WebDriverWait(driver, 20); 
//		wait.until(ExpectedConditions.elementToBeClickable(firstName));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
//		company.click();
//		company.sendKeys(comp);
javaScript();
		
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		selectDropdown("category","Customer");
		selectDropdown("source","Google");
		selectDropdown("status","Active");
		publicButton.click();
		selectDropdown("access","Ratnasree Pantham");
		Thread.sleep(5000);
		saveBtn.click();
		
	}
	public void selectDropdown(String dropDownLabel,String dropdownValue){
		
		String elementlabel=dropDownLabel.toLowerCase().concat("List");
		for(WebElement e:categoryList) {
			if(e.getText().equalsIgnoreCase(dropdownValue)) {
			e.click();
			}
		}
		
		
	}
	public void javaScript() {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement jselement= (WebElement)js.executeScript("return document.querySelector(\"div[name='company']>input\")");
//	js.executeScript("arguments[0].click();",jselement);
	
	js.executeScript("arguments[0].setAttribute('value','google')",jselement);
	}

}
