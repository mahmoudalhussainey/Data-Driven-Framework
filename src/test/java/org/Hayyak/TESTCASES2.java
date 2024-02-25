package org.Hayyak;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class TESTCASES2 extends  Hayyak_Base {
	
	
public TESTCASES2(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//	@BeforeMethod
//	public void presetup () {
//	Activity activity =new Activity ("com.google.android.apps.nexuslauncher","com.google.android.apps.nexuslauncher.NexusLauncherActivity");	
//	driver.startActivity(activity);
//	}
//	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException {
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
  	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMessage, "please enter your name");
	}
		
		@Test
		public void FillForm_PositiveFlow()throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rasha");
		Thread.sleep(5);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		Thread.sleep(5);
		driver.findElement(By.id("android:id/text1")).click();
  	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		AssertJUnit.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast[1]")).size()<1);
		
		
		
		
		
		
		
		
		
	}
	
	}
