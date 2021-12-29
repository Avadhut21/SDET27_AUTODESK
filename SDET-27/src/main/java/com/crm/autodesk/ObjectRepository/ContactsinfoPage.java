package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsinfoPage {

	@FindBy(className ="dvHeaderText")
	private WebElement contactHeaderInfoText;

	public ContactsinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactHeaderInfoText() {
		return contactHeaderInfoText;
	}

	public String getContactInfo()
	{
		return(contactHeaderInfoText.getText());
	}

}
