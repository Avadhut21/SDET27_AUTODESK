package com.crm.Autodesk.contacttest;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtiltiy;
/**
 * 
 * @author Avadhut
 * @param <ContactPage>
 *
 */
public class CreateContactTest extends BaseClass{
    @Test(groups ="smokeSuite")
	public void main(String[] args) throws Throwable {
    	SoftAssert sa = new SoftAssert();
    	// getRanDom Num
    	int ranDomNum = jLib.getRandomNumber();
    	
    	// read test data from excel file
    	String lastName =elib.getDataFromExcel("org", 1, 2);  
    	
    	// step 2: navigate to contact module
    	HomePage hp = new HomePage(driver);
    	hp.clickOnOrgLnk();
    	sa.fail();
    	// step 3 : click on "create Contact" button
    	//ContactsPage cp = new ContactsPage( driver);
    	//cp.cl
    	
    	// step 4 : verify Con
		FileUtiltiy flib = new FileUtiltiy();
		String URL = flib.getPropertykeyValue("url");
		String USERNAME = flib.getPropertykeyValue("username");
		String PASSWORD = flib.getPropertykeyValue("password");
		//		FileInputStream fis = new FileInputStream("./data/TestScriptdata.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);

		WebDriver driver;
		driver=new ChromeDriver();
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		//		driver.findElement(By.name("user_name")).sendKeys("admin");
		//		driver.findElement(By.name("user_password")).sendKeys("admin");
		//		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Patil");
		driver.findElement(By.xpath("//input[@title ='Save [Alt+S]']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(""))));
		String title = driver.findElement(By.className("dvHeaderText")).getText();
		if(title.contains("Patil"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}

	}

}
