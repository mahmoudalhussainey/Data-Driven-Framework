package org.Hayyak;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.Hayyak.pageObjects.android.FormPage;
import org.Hayyak.utils.AndroidActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Hayyak_Base extends AndroidActions {
	public Hayyak_Base(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formpage;

	@BeforeClass
 
	public void ConfigureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\mahmo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("mmm");
//		options.setChromedriverExecutable("C:\\Users\\User\\Desktop\\driver fo APP");
//		options.setApp("C:\\Users\\User\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\mahmo\\OneDrive\\Desktop\\General-Store.apk");
//		options.setApp("C:\\Users\\User\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\application-7b10788e-50bc-40ad-bdab-c1400f033c27.apk");
//		options.setApp("C:\\Users\\mahmo\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\application-929b8f24-968f-4e65-91a1-09a265638851.apk");

//		"C:\\Users\\mahmo\\OneDrive\\Desktop\\General-Store.apk"

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 formpage = new FormPage(driver);


	}
	public void login() throws InterruptedException{
		
		driver.findElement(AppiumBy.accessibilityId("Next-button")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-phoneNumber\"]")).sendKeys("786178460");
//		Thread.sleep(200);
		driver.findElement(AppiumBy.accessibilityId("confirm-button")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).sendKeys("123456");
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Traveler client, member, 󰐽\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"next-button\"]")).click();
		Thread.sleep(200);
	}
	public void Date() {
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"input-select-date\"]/android.view.ViewGroup")).click();
		driver.findElement(AppiumBy.accessibilityId("Next month")).click();
		driver.findElement(AppiumBy.accessibilityId("15 February 2024")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	public void Subscription() {
		
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"input-btn-subscription\"]")).click();

	}
//	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
//		
//		String jsonContent = FileUtils.readFileToString(System.getProperty("user.dir") + "//src//test//java//org//Hayyak//testDatDriven//ecommerce4.json");
//		ObjectMapper mapper = new ObjectMapper();
//		List<HashMap><String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
//			
//		});
//		return data;
//	}

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
	public void SwipeAction(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) ele).getId(), 
				
				"direction", direction, "percent", 0.75));	
		
		
		
	}
	public Double getFormattedAmount(String amount)
	{
		Double price =Double.parseDouble(amount.substring(1));
		return price;	
	}

//	@AfterMethod
//	@AfterMethod
	@AfterClass
	public void tearDown() {

//		driver.quit();
		service.stop();
	}

}

