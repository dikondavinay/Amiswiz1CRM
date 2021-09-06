package com.Amiswiz1CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amiswiz1CRM.GenericLibs.BaseTest;



public class Loginpage {

	@FindBy(id="userName") private WebElement untb;
	@FindBy(id="passWord") private WebElement pwtb;
	@FindBy(xpath = "//input[@title=\"Sign In\"]") private WebElement signBtn;
	
	public Loginpage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public WebElement getUntb()
	{
		return untb;
	}
	
	public void setuntb(WebElement untb) {
		this.untb = untb;
	}
	
	public WebElement getPwtb()
	{
		return pwtb;
	}
	
	public void setPwtb(WebElement pwtb)
	{
		this.pwtb = pwtb;
	}
	
	public WebElement getsignInBtn() {
		return signBtn;
	}
	
	public void setSignInBtn(WebElement signInBtn) {
		this.signBtn = signInBtn;
	}
	
	public void loginToApp(String un, String pwd)
	{
		untb.sendKeys(un);
		pwtb.sendKeys(pwd);
		signBtn.click();
	}
}
