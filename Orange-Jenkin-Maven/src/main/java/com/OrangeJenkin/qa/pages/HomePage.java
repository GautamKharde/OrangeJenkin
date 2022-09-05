package com.OrangeJenkin.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeJenkin.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page objects or object Reository
	@FindBy(xpath = "//p[text()='Paul Collings']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath = "//span[text()='My Info']")
	WebElement myInfoLink;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboardLink;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement PIMPageLink;
	
	
	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
		
	

}
