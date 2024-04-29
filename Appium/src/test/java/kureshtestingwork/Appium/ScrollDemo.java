package kureshtestingwork.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// if we know where to scroll prior to scroll
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		scrollToEndAction();
	}
}
