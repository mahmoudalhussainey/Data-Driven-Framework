package org.Hayyak.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

//import org.Hayyak.HashMap;
//import org.Hayyak.IOException;
//import org.Hayyak.List;
//import org.Hayyak.TypeReference;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	public void LongPressAction(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	public void ScrollToEndAction()
	{
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 412, "height", 915,
			    "direction", "down",
			    "percent", 3.0));
		}while(canScrollMore);
		
	}
	public void ScrollToText(String text)
	{
  	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

	}
	public void SwipeAction(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) ele).getId(), 
				
				"direction", direction, "percent", 0.75));	
		
		
		
	}
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap <String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}
	public Double getFormattedAmount(String amount)
	{
		Double price =Double.parseDouble(amount.substring(1));
		return price;
		
		
		
	}
	public void waitForelementtoappear(WebElement ele)
	{
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
	}

}
