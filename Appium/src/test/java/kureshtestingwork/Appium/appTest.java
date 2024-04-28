package kureshtestingwork.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appTest extends BaseTest {

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {

		// using locater with xpath, id, accessibilityId, classname, AndroidUIAutomator,
		// for accessibilityId and AndroidUIAutomator user AppiumBy

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// tageName[@attribute=value]
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//check Assertion for validation
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("My Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
	}
}
