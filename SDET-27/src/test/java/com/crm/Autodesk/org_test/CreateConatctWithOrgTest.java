package com.crm.Autodesk.org_test;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtiltiy;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;




/**
 * 
 * @author avadhut
 *
 */
public class CreateConatctWithOrgTest extends BaseClass{

	public static void main(String[] args) throws Throwable {


		/* create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtiltiy fLib = new FileUtiltiy();
		ExcelUtility eLib = new ExcelUtility();

		/* get ramDomData */ 
		int randomNum = jLib.getRandomNumber();

		/* read common data from Properties File*/

		String BROWER = fLib.getPropertykeyValue("browser");
		String URL = fLib.getPropertykeyValue("url");
		String USERNAME = fLib.getPropertykeyValue("username");
		String PASSWORD = fLib.getPropertykeyValue("password");

		/* read test data from Excel File*/

		String orgName = eLib.getDataFromExcel("contact", 3, 2) + randomNum;
		String conactName = eLib.getDataFromExcel("contact", 4, 3) + randomNum;




		/* launch the Browser */ 
		WebDriver driver = null;
		if(BROWER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWER.equals("firefox")){
			driver = new FirefoxDriver();
		}else if(BROWER.equals("ie")){
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}

		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		/* step 1 : login to APP */ 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/* step 1 : navigate to Org Page */ 
		driver.findElement(By.linkText("Organizations")).click();

		/* step 2 :  navigate to CREATE  Org Page*/ 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		/* step 3 : create a new Org */
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement headerWb = driver.findElement(By.className("dvHeaderText"));

		wLib.waitForElemnetToBeClickAble(driver, headerWb);


		/* step 4 : navigate to Contact Page */ 
		driver.findElement(By.linkText("Contacts")).click();

		/* step 5 :  navigate to CREATE  Coantct Page*/ 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();


		/* step 6 : create a new contact With org Name */
		driver.findElement(By.name("lastname")).sendKeys(conactName);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();

		wLib.swithToWindow(driver, "Accounts");


		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wLib.swithToWindow(driver, "Contacts");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



		wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
