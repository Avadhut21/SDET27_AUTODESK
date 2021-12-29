package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{



	//step 1:create a seperate class for homepage

	// Step 2 :Declaration 
	@FindBy(linkText = "Organizations")
	private WebElement organizationslink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement Opportunities;

	@FindBy(linkText = "Products")
	private WebElement Products;

	@FindBy(linkText = "Documents")
	private WebElement Documents;

	@FindBy(linkText = "Email")
	private WebElement EmailLnk;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement  administratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;

	// Step 3 Initialization
	public HomePage (WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}


	// step 4 Utilization

	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOpportunities() {
		return Opportunities;
	}

	public WebElement getDocuments() {
		return Documents;
	}

	public WebElement getEmailLnk() {
		return EmailLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

//business labrary
	public void clickOnOrgLnk()
	{
		organizationslink.click();	
	}
	public void logout(WebDriver driver)
	{
		mouseOverOnElemnet(driver, administratorImg);
		SignOutLnk.click();
	}
	}



