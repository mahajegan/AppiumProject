package Hybrid;

import static org.testng.Assert.*;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.testng.Assert.assertEquals;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class TC_01 extends Capability{
	AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver = capability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test(enabled=false)
	public void testcase1() throws MalformedURLException {
		//driver = capability();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Maha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		//to work in drop down 	- click in the default value and scroll till India
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();        
	}
	
	@Test(enabled=false)
	public void testcase2() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Maha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		//to work in drop down 	- click in the default value and scroll till India
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        //every error message is called toast message
        String errormessage= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(errormessage);
        String expected = "Please enter your name";
        Assert.assertEquals(errormessage, expected);
        
	}
	
	@Test(enabled=false)
	public void testcase3() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Maha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		//to work in drop down 	- click in the default value and scroll till India
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Australia']")).getText();
        String Expected = "Australia";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        //find out how many products are there and select jordan 6 rings
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Jordan 6 Rings\"))");
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println(count);
        for(int i=0;i<count;i++)
        {
        	String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equals("Jordan 6 Rings"))
            {
                System.out.println(productName);
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        String checkoutname = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Thread.sleep(3000);
        String expectedname = "Jordan 6 Rings";
        Assert.assertEquals(expectedname, checkoutname);
	
	}
	
	@Test(enabled=true)
	public void testcase4() throws InterruptedException, MalformedURLException {
		driver = capability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Maha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		//to work in drop down 	- click in the default value and scroll till India
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Australia']")).getText();
        String Expected = "Australia";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        //Scroll and click on first two add to cart button
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        amount1 = amount1.substring(1);
        double amount1value = Double.parseDouble(amount1);
        
        
        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        amount2 = amount2.substring(1);
        double amount2value = Double.parseDouble(amount2);
        
        //Sum of the amount of first two product
        double TotalAmount = amount1value + amount2value;
        
        //Final one
        String finalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        finalamount = finalamount.substring(1);
        double FinalTotal = Double.parseDouble(finalamount);
        
        Assert.assertEquals(FinalTotal, TotalAmount);
        //Tap on the checkbox
        //Long press on terms and conditions
        //click ok on the pop up
        //click on visit the website
        AndroidElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        AndroidElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.id("android:id/message")).getText());
        driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(8000);
        //To shift from native app to web app in hybrid application
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName:contextNames) {
        	System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(5000);
        driver.context("NATIVE_APP");


	}
        
	
}
