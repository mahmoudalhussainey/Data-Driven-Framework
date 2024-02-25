package org.Hayyak.pageObjects.android;

import org.Hayyak.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {

	AndroidDriver driver;
	
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);//Call parent class constructor
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rasha");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
//			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

	@AndroidFindBy (xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy (xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	@AndroidFindBy (id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	
	
	
	//بدنا نعمل  scrolldown  حتى يلاقي اسم البلد اذا ما كانت مبينة
//	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));
//	driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
	@AndroidFindBy (id= "android:id/text1")
	private WebElement countrySelection;
	
	public void setNamefield (String name)
	{
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void setGender(String gender)
	{
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
		
	}
	public void setCountrySelection(String counryName)
	{
		countrySelection.click();
		ScrollToText(counryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+counryName+"']")).click();

		
	}
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return new ProductCatalogue(driver);
	}
	

}
