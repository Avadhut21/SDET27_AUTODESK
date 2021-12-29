package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orgLookupbtn;
	
	
	@FindBy(name ="accountname")
	private WebElement organizationNameEdt;

	@FindBy(name ="industry")
	private WebElement industryDropDown;

	@FindBy(name ="accounttype")
	private WebElement typeDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private  WebElement saveBtn;

	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationNameEdt()
	{
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown()
	{
		return industryDropDown;
	}

	public WebElement getTypeDropDown()
	{
		return typeDropDown;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	public WebElement getOrgLookupbtn() {
		return orgLookupbtn;
	}

	//business libaray for create organization
	public void createOrg(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	//business libaray for create organization with indusrty drop down
	public void createOrgWithIndustry(String orgName) 
	{
		organizationNameEdt.sendKeys(orgName);
		
		saveBtn.click();
	}

	public void clickOnorglookUp() {
		orgLookupbtn.click();
	}
}



