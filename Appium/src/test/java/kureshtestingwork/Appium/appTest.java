package kureshtestingwork.Appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class appTest {

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3");
		options.setApp("D:\\API_Testing_PetStoreAutomation\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		URL url = new URL(" http://127.0.0.1:4723");
		AndroidDriver driver = new AndroidDriver(url, options);
		driver.quit();

	}
}
