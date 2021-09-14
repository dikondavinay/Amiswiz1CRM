package com.Amiswiz1CRM.GenericLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoConstants {

	public static WebDriver driver;

	@BeforeClass
	public void openBrowser() throws Throwable {
		
		FileLib flib = new FileLib();//
		
		String browserName = flib.readPropertyData(PROP_PATH, "browser");//statement1
		
		if (browserName.equals("chrome")) {        //statment2
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		} else {
			System.out.println("enter proper browser Name");
		}
		
		driver.manage().window().maximize(); //
		String appurl = flib.readPropertyData(PROP_PATH, "url");
		
		driver.get(appurl);//statement3
		
		WebDrivercommonLib wlib = new WebDrivercommonLib();
		String expectedLoginTitle = flib.readPropertyData(PROP_PATH, "LoginTittle");
		String actualLoginTitle=wlib.getpageTitle();
		
		wlib.verify(actualLoginTitle, expectedLoginTitle, "Login page");
		
		//wlib.verify(wlib.getpageTitle(), expectedLoginTitle, "Login page");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
