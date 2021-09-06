package com.Amiswiz1CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amiswiz1CRM.GenericLibs.BaseTest;



public class Homepage {

	@FindBy(xpath = "//a[text()='Leads']") private WebElement leadsTab;
	
	public Homepage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void ClickLeadsTab()
	{
		leadsTab.click();
	}
	
	
	
	
}
