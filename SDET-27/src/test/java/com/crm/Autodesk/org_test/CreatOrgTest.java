package com.crm.Autodesk.org_test;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;


public class CreatOrgTest extends BaseClass {

	@Test(groups="smokeSuite")

	public void CreateOrgTest() throws Throwable {
		//read common data from properties File
		//FileInputStream fis=new FileInputStream("./Data/Data.properties");
		/*Properties pobj=new Properties();
			pobj.load(fis);*/


		/*JavaUtility jLib=new JavaUtility();
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			WebDriverUtility wLib=new WebDriverUtility();

			String URL = fLib.getPropertyKeyValue("url");
			String USERNAME =fLib.getPropertyKeyValue("username");
			String PASSWORD =fLib.getPropertyKeyValue("password");
			String BROWSER =fLib.getPropertyKeyValue("browser");*/

		//getRanDom Num
		int randomNum = jLib.getRandomNumber();

		//read test data from Excel File
		String orgName = elib.getDataFromExcel("org",1,2)+randomNum;



		//get random num
		//Random ran = new Random();
		//int randomnum = ran.nextInt(10000);// 
		//read test data from excel file
		//FileInputStream fis_e=new FileInputStream("./Data/Testdata.xlsx");
		/*Workbook wb = WorkbookFactory.create(fis_e); 
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(1);
			String orgName=row.getCell(2).getStringCellValue()+randomnum;*/
		/*WebDriver driver;
			if(BROWSER.equals("firefox")) 
			{
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equals("ie"))
			{
				driver=new InternetExplorerDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			LoginPage lp=new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);*/

		//step 1: login
		/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/

		//step 2: navigate to Organization module

		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();

		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);

		OrganizationinfoPage oip=new OrganizationinfoPage(driver);
		String actMsg=oip.getOrgInfo();

		//step 2:navigate to organization module
		/*driver.findElement(By.linkText("Organizations")).click();
			//step 3: click on "create organization" Button
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			//step 4:enter all the details and create new organization

			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();*/
		/*SoftAssert sa=new SoftAssert();
			sa.assertTrue(actMsg.contains("abc"));

			String actIndustries=oip.getIndustryName();*/


		//step 5:verify organization name in header of the msg
		String actSuc_msg = driver.findElement(By.className("lvtHeaderText")).getText();


		if(actMsg.contains(orgName)) 
		{
			System.out.println("org is successfully created..Pass");
		}
		else 
		{
			System.out.println("org is not created..Fail");
			//step 6: logout
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[src=\"themes/softed/images/user.PNG\"]"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
		}

	}


}


