/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
TestUtil.runTimeInfo("error", "login successful");
//		testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
	}
	
//	@Test(priority=1)
//	public void verifyContactsPageLabel(){
//		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
//	}
//	
//	@Test(priority=2)
//	public void selectSingleContactsTest(){
//		contactsPage.selectContactsByName("test2 test2");
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest(){
//		contactsPage.selectContactsByName("test2 test2");
//		contactsPage.selectContactsByName("ui uiii");
//
//	}
	
	
//	
//	@Test(enabled=false)
//	public void passengerTraintimeTable() {
//		
//		
//		driver.switchTo().alert().dismiss();
//
//		WebElement table=driver.findElement(By.xpath("//h2[normalize-space()='List of Indian Railway Trains and their Time Table']/../child::div/table/tbody"));
//		
//		Actions action=new Actions(driver);
//		action.moveToElement(table).build().perform();
//		List<WebElement> tablerows=table.findElements(By.tagName("tr"));
//		HashMap<String,List<String>> traintimetable=new HashMap<String, List<String>>();
//		
//		for(int i=1;i<tablerows.size();i++) {
//			List<WebElement> tablecolumns=tablerows.get(i-1).findElements(By.tagName("td"));
//			
//			for(int j=1;j<tablecolumns.size();j++) {
//			List<String> tableData=new ArrayList<String>();
//			tableData.add(tablecolumns.get(j).getText());
//			}
//		}
//		
//	}

	@Test
	public void BrokenLinks() throws IOException {
		
		
		List<WebElement> linkstags=driver.findElements(By.tagName("a"));
		List<String> urls=new ArrayList<String>();
		for(WebElement e:linkstags) {
			
			if(e.getAttribute("href").contains("https")) {
				
			String s=e.getAttribute("href");
			System.out.println(s);
			urls.add(s.substring(s.indexOf("https")));
			brokenLinks(s.substring(s.indexOf("https")));
			}
		}
		
		
	}
	
	
	public void brokenLinks(String url) throws  IOException {

		URL httpurl=new URL(url);
		HttpURLConnection connection=(HttpURLConnection) httpurl.openConnection();
		connection.connect();
		if(connection.getResponseCode()>=400) {
			System.out.println(url+"--------"+connection.getResponseCode());
		}
		}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
