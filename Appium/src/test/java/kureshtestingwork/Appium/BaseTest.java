package kureshtestingwork.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		// coding for starting of the server
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\purna\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3");
//		options.setUdid("mn99wwrweivcnvlr");
		options.setApp("D:\\Appium_Testing\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		URL url = new URL(" http://127.0.0.1:4723");
		//below command for session new creation
		//adb uninstall io.appium.uiautomator2.server
		//adb uninstall io.appium.uiautomator2.server.test
		
		driver = new AndroidDriver(url, options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
	}
	
	
	public void scrollToEndAction() {
	    int count = 0;
	    boolean canScrollMore;
	    do {
	        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	                "left", 100, "top", 100, "width", 200, "height", 200,
	                "direction", "down",
	                "percent", 1.0
	        ));
	        count++;
	        System.out.println("Scroll attempt: " + count);
	        System.out.println("Can scroll more? " + canScrollMore);
	    } while (canScrollMore);
	}
	
	
	public void swipeAction(WebElement wb, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)wb).getId(),
				"direction", direction,
		        "percent", 0.75
		));
	}
	
	//for closing activity
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}
}
