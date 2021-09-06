package com.Amiswiz1CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amiswiz1CRM.GenericLibs.BaseTest;



public class CreateLeadPage {

	@FindBy(xpath = "//input[@name=\"property(Company)\"]") private WebElement companytTb;
	@FindBy(xpath = "//input[@name=\"property(Last Name)\"]") private WebElement lastNameTb;
	@FindBy(xpath ="(//input[@value=\"Save\"])[1]") private WebElement saveBtn;
	
	
	public CreateLeadPage()
	{
		PageFactory.initElements(BaseTest.driver, this);        
	}
	
	public void createLeadwithMandatoryDetails(String companyName, String ln)
	{
		
	
		companytTb.sendKeys(companyName);
		lastNameTb.sendKeys(ln);
		saveBtn.click();
		
	}
	}
