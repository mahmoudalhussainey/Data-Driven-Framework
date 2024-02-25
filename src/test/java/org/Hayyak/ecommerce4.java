package org.Hayyak;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.Hayyak.pageObjects.android.CartPage;
import org.Hayyak.pageObjects.android.FormPage;
import org.Hayyak.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class ecommerce4 extends Hayyak_Base {
	
	public ecommerce4(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void starts()
	{        
		//adb shell dumpsys window | grep -E 'mCurrentFocus' -MAC
		//adb shell dumpsys window | find "mCurrentFocus" -Windows
//		Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//  	  driver.startActivity(activity);
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));//To return to the same page after rub the scripts and clear the all data
		
	}
	
	@Test(dataProvider="getData")
	public void FillForm(String name, String gender, String country) throws InterruptedException {
//		FormPage formpage = new FormPage(driver);
		formpage.setNamefield("Mahmoud");
		formpage.setGender("female");
		formpage.setCountrySelection("Argentina");
		ProductCatalogue productCatalogue = formpage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartpage = productCatalogue.goToCartPage();
		//xpath=//tagname[@attribute='value']		
//        driver.pressKey(new KeyEvent(AndroidKey.BACK )); 	   
//        String toastvalue=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//  	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));")); 
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		double totalSum = cartpage.getProductsSum();
		double displayFormattedSum = cartpage.getTotalAmountDisplayed();
         AssertJUnit.assertEquals(totalSum, displayFormattedSum);
         cartpage.acceptTermsConditions();
         cartpage.submitOrder();    
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data = getJsonData(System.getProperty("user.dir") + "\\src\\test\\java\\org\\Hayyak\\testDatDriven\\ecommerce4.json");
		return new Object[][] {{"Mahmoud","female","Argentina"},{"Kamel","male","Brazil"}}; //Parameterize to send different data for the same test 
		// How to import data from json file and whats the dependency we nedded 1- Parse Json file -> Json String (Ommons-io)
		//Json String-> Hash Map (jakson)
		//HashMap->is key name and value name -> Testcase (Testng Data provider)
		
		}

//	@Test
//	public void FillgForm()  {
//		}
        	
}
