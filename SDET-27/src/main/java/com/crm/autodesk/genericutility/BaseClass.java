package com.crm.autodesk.genericutility;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.beust.jcommander.Parameter;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {


		public DataBaseUtility dLib = new DataBaseUtility();
		public FileUtiltiy fLib = new FileUtiltiy();
		public WebDriverUtility wlib = new WebDriverUtility();
		public JavaUtility jLib = new JavaUtility();
		public ExcelUtility elib =new ExcelUtility();
		public WebDriver driver;
		public static WebDriver sdriver;

		@BeforeSuite
		public void dbconnection()
		{
			dLib.connectToDB();
			System.out.println("====== Database connection successful ======");
		}
      
		@BeforeClass(groups = {"smokesuite"})
		public void launchbrowser() throws Throwable 	{
			// read the data

			String URL =fLib.getPropertykeyValue("url");
			String BROWSER = fLib.getPropertykeyValue("browser");
			if(BROWSER.equalsIgnoreCase("CHROME"))
			{
				driver = new ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invlid browser");
			}
			sdriver =driver;
			wlib.waitForPageToLoad(driver);
			driver.get(URL);
			System.out.println("======== Login Successful ========");
		}
		@BeforeMethod
		public void loginToApp() throws Throwable
		{
			String USERNAME = fLib.getPropertykeyValue("username");
			String PASSWORD = fLib.getPropertykeyValue("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
	        System.out.println(" ===== login successful =====");		
		}
		@AfterMethod 
		public void logoutOfApp()
		{
			HomePage hp = new HomePage(driver);
			hp.logout(driver);
			System.out.println("======= logout successful =====");
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
			System.out.println(" ===== Browser close =====");
		}
		@AfterSuite
		public void closeDbconnection()
		{
			dLib.closeDB();
			System.out.println();
		}
		
	}






