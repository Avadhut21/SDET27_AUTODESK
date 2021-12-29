package com.crm.product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtiltiy;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class Testcase27 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtiltiy fLib = new FileUtiltiy();
		


		
		String BROWER = fLib.getPropertykeyValue("browser");
		String URL = fLib.getPropertykeyValue("url");
		String USERNAME = fLib.getPropertykeyValue("username");
		String PASSWORD = fLib.getPropertykeyValue("password");

		//get random num
		int randomNum = jlib.getRandomNumber();



		WebDriver driver;
		if(BROWER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWER.equals("chrome")){
			driver= new ChromeDriver();
		}
		else if(BROWER.equals("ie")){
			driver= new InternetExplorerDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("SubmitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		WebElement plist = driver.findElement(By.id("viewname"));
		By Filters = By.id("viewname");
		Select select = new Select(driver.findElement(Filters));
		select.deselectByVisibleText(PASSWORD);
	}
}
