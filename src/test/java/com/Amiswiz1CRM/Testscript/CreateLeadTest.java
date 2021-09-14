package com.Amiswiz1CRM.Testscript;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Amiswiz1CRM.GenericLibs.BaseTest;
import com.Amiswiz1CRM.GenericLibs.FileLib;
import com.Amiswiz1CRM.GenericLibs.WebDrivercommonLib;
import com.Amiswiz1CRM.Pages.CreateLeadPage;
import com.Amiswiz1CRM.Pages.CustomViewPage;
import com.Amiswiz1CRM.Pages.Homepage;
import com.Amiswiz1CRM.Pages.Loginpage;

public class CreateLeadTest extends BaseTest {
	@Test

	public void CreateLead() throws Throwable {
		// BaseTest bt = new BaseTest();
		// bt.openBrowser();

		Loginpage lp = new Loginpage();
		FileLib flib = new FileLib();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "username"), flib.readPropertyData(PROP_PATH, "password"));

		WebDrivercommonLib wlib = new WebDrivercommonLib();
		wlib.verify(wlib.getpageTitle(), flib.readPropertyData(PROP_PATH, "homeTitle"), "Home Page");

		Homepage hp = new Homepage();
		hp.ClickLeadsTab();

		// ExplictWait
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.titleContains(flib.readPropertyData(PROP_PATH, "CustomViewTitle")));
		wlib.verify(wlib.getpageTitle(), flib.readPropertyData(PROP_PATH, "CustomViewTitle"), "Custom view page");
		
		CustomViewPage cv = new CustomViewPage();
		cv.ClickNewLeadBtn();
		//wait.until(ExpectedConditions.titleContains(flib.readPropertyData(PROP_PATH, "createLeadTitle")));
		wlib.verify(wlib.getpageTitle(), flib.readPropertyData(PROP_PATH, "createLeadTitle"), "create Lead Page");
		
		
		CreateLeadPage cl = new CreateLeadPage();
		cl.createLeadwithMandatoryDetails(flib.readExcelData(EXCEL_PATH, "Sheet1", 2, 1),
				flib.readExcelData(EXCEL_PATH, "Sheet1", 3, 1));
		//wait.until(ExpectedConditions.titleContains(flib.readPropertyData(PROP_PATH, "leadDatailsTitle")));
		wlib.verify(wlib.getpageTitle(), flib.readPropertyData(PROP_PATH, "leadDatailsTitle"), "Lead Details Page");

	}

}
