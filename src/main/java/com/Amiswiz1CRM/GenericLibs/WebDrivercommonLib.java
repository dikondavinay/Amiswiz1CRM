package com.Amiswiz1CRM.GenericLibs;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this generic class contains all the webdriver utility methods
 * @author vinay
 *
 */

 public class WebDrivercommonLib 
 {
	public String getpageTitle()
	{
		String pageTitle = BaseTest.driver.getTitle();
		return pageTitle;
	}
	
 public void verify(String actual,String expected,String page) {
	if(actual.equals(expected)) {
		System.out.println(page + " is displayed,PASS");
	}else {
		System.out.println(page + " is not displayed, FAIL");
	}
 }

  public void selectOption(WebElement element, int index)
 {
	Select sel = new Select(element);
	sel.selectByIndex(index);
 }
 public void selectOption(WebElement element,String value)
 {
    Select sel = new Select(element);
    sel.selectByValue(value);
 }
 public void selectOption(String text, WebElement element) {
	  Select sel = new Select(element);
	   sel.selectByVisibleText(text);
 }

  public void mouseHover(WebElement element) {
	  Actions ac = new Actions(BaseTest.driver);
	  ac.moveToElement(element).perform();
  }
  public void rightClick(WebElement element) {
	         Actions ac = new Actions(BaseTest.driver);
	ac.contextClick(element).perform();  
  }
  public void dragAndDropElement(WebElement source, WebElement target) {
	             Actions ac = new Actions(BaseTest.driver);
	  ac.dragAndDrop(source, target).perform();
  }
      public void switchToFrame(int index) {
     BaseTest.driver.switchTo().frame(index);
   }
    public void switchToFrame(String value) {
      BaseTest.driver.switchTo().frame(value);
    }
   
    public void switchToFrame(WebElement element) {
    	BaseTest.driver.switchTo().frame(element);
    }
   public void getFullPageScreenshot(String screenshotpath)
   {
	   
	   TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	         File dest = new File(screenshotpath);
	         try {
	                Files.copy(src, dest);
	         } catch(IOException e)
	         {
	        	 e.printStackTrace();
               }
   }
	   public void getElementScreenshot(WebElement element, String Screenshotpath)
	   {
		   TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
		   File src = ts.getScreenshotAs(OutputType.FILE);
		   File dest = new File(Screenshotpath);
		   try {
			Files.copy(src, dest);
		} catch (IOException e)
		   {	
			e.printStackTrace();
		}
	   }	   
	public void  waitForPageTitle(String Title) {
		   WebDriverWait wait = new WebDriverWait(BaseTest.driver,30);
			wait.until(ExpectedConditions.titleContains(Title));
		}
	}
 
