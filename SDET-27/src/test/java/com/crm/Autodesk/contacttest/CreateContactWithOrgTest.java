package com.crm.Autodesk.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.JavaUtility;

public class CreateContactWithOrgTest extends BaseClass {

	public static void main(String[] args) throws IOException {
		JavaUtility jlib = new JavaUtility();
		FileInputStream fis =new  FileInputStream("./data/commonData.property");
		Properties pobj = new Properties();
		pobj.load(fis);

		//		Random ran = new Random();
		//		int ran1=ran.nextInt(1000);
		int randomnumber = jlib.getRandomNumber();

		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String browser = pobj.getProperty("browser");
		String cname = pobj.getProperty("contactname");



		FileInputStream fos_e = new FileInputStream("./data/TestScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fos_e);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgname =row.getCell(2).getStringCellValue();

		WebDriver driver;
		if(browser.equals("firebox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}

		// step 1:Login
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("SubmitButton")).click();

		// step 2: Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// step 3: click on "create Orgnizations" Button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step 4: Enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Wait element to be active
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));

		// step 5: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// step 6: click on "create contact"button 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step 7: enter all the details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(cname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		Set<String> set = driver.getWindowHandles();
		java.util.Iterator<String> it = set.iterator();	

		while(it.hasNext())
		{
			String currentid = it.next();
			driver.switchTo().window(currentid);
			String Currentpagetitle = driver.getTitle();
			if(Currentpagetitle.contains("Accounts"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();


		Set<String> set1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = set1.iterator();

		while(it1.hasNext())
		{
			String currentid = it1.next();
			driver.switchTo().window(currentid);
			String Currentpagetitle = driver.getTitle();
			if(Currentpagetitle.contains("Contacts"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println(orgname+"is successfully created......pass");
		driver.quit();
	}
}


