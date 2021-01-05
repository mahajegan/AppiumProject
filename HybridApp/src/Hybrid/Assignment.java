package Hybrid;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Assignment extends Capability{
		AndroidDriver<AndroidElement> driver;
		
	
		@BeforeTest
		public void bt() throws MalformedURLException {
			driver = capability();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		}
		
		@Test(enabled=false)
		public void signup() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Dismiss']")));	
		    TouchAction t = new TouchAction(driver);
			AndroidElement dismiss = driver.findElement(By.xpath("//*[@text='Dismiss']"));
			if (dismiss.isDisplayed()) {
	        t.longPress(longPressOptions().withElement(element(dismiss)).withDuration(ofSeconds(3))).release().perform();
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign in']")));
			driver.findElement(By.xpath("//*[@text='Sign in']")).click();
			System.out.println("Performed  Click on Sign In");
			driver.findElement(By.xpath("//*[@text='Sign up with email']")).click();
			Thread.sleep(3000);
			driver.findElement(MobileBy.AccessibilityId("First name")).sendKeys("Maha");
			driver.findElement(MobileBy.AccessibilityId("Last name")).sendKeys("Lakshmi");
			driver.findElement(MobileBy.AccessibilityId("Email address")).sendKeys("mahasensri@gmail.com");
			driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("Mithran@6190");
			driver.findElement(By.xpath("//*[@text='Birthday']")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/numberpicker_input\")).scrollIntoView(textMatches(\"Jul\"))"));
			driver.findElement(MobileBy.id("android:id/button1")).click();
			driver.findElement(By.xpath("//*[@text='CREATE']")).click();
			Thread.sleep(3000);
			
			
		}
		@Test
		public void signin() throws InterruptedException {
			
				WebDriverWait wait = new WebDriverWait(driver,60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Dismiss']")));	
			    TouchAction t = new TouchAction(driver);
				AndroidElement dismiss = driver.findElement(By.xpath("//*[@text='Dismiss']"));
				if (dismiss.isDisplayed()) {
		        t.longPress(longPressOptions().withElement(element(dismiss)).withDuration(ofSeconds(3))).release().perform();
				}
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign in']")));
			driver.findElement(By.xpath("//*[@text='Sign in']")).click();
			driver.findElement(By.xpath("//*[@text='Sign in']")).click();
			Thread.sleep(3000);
			driver.findElement(MobileBy.AccessibilityId("Enter an e-mail address or username")).sendKeys("mahasensri@gmail.com");
			driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("Mithran@6190");
			driver.findElement(MobileBy.AccessibilityId("Sign in")).click();
			
			
		}
		
		@Test(enabled=false)
		public void joinclass() throws InterruptedException {

			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Join class']")));	
			driver.findElement(By.xpath("//*[@text='Join class']")).click();
			driver.findElement(MobileBy.AccessibilityId("e.g. ABC123 or teacher@example.com")).sendKeys("class@gmail.com");
			driver.findElement(By.xpath("//*[@text='ADD']")).click();
			driver.findElement(By.xpath("//*[@text='ADD']")).click();
			Thread.sleep(3000);
			AndroidElement alerttitle = driver.findElement(By.xpath("//*[@text='Teacher added']"));
			AndroidElement dismisstitle = driver.findElement(By.id("android:id/button1"));
			//AndroidElement alert = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/alertTitle\"))"));
			if(alerttitle.isDisplayed()) {
				System.out.println("successfully added class teacher");
				dismisstitle.click();
				
			}
			else {
				System.out.println("Error adding teacher Retry");
			}
		}
		
		@Test(enabled=false)
		public void termsofservice() {
			driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
			driver.findElement(By.xpath("//*[@text='Terms of service']")).click();
			/*driver.findElement(By.xpath("//*[@text='Chrome']")).click();
			driver.findElement(By.xpath("//*[@text='ALWAYS']")).click();
			driver.findElement(By.xpath("//*[@text='Accept & continue']")).click();
			driver.findElement(By.id("com.android.chrome:id/next_button")).click();
			driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
			driver.findElement(By.className("android.widget.Button")).click();
			 */
			Set<String> contextNames = driver.getContextHandles();
	        for (String contextName:contextNames) {
	        	System.out.println(contextName);
	        }
	        driver.context("NATIVE_APP");
	        driver.navigate().back();
		}
		
		@Test(enabled=false)
		public void manageteachers() {
			driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
			driver.findElement(By.xpath("//*[@text='Manage teachers']")).click();
			//driver.findElement(By.xpath("//*[@text='Add a teacher']")).click();
			driver.findElements(MobileBy.AccessibilityId("Delete")).get(0).click();
		}
		
		@Test(enabled=false)
		public void scroll() {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Recent Lessons\"))").click();
		}
}
