package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	//step 1: Create a Seperate file for WebPage.
		// step 2: identifing all webElement and Declearing them as private
		@FindBy(name = "user_name")
		private WebElement usernameEdt;
		
		@FindBy(name = "user_password")
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement loginbtn;
		
		
		// step 3: Initialise the element using constructor
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		//step 4: Utilization provied Getter Method
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
	    //business library
		public void login (String username, String password) {
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginbtn.click();
	}
		}


