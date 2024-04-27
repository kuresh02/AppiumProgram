package kureshtestingwork.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appTest {

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\purna\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3");
		options.setApp("D:\\Appium_Testing\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		URL url = new URL(" http://127.0.0.1:4723");
		AndroidDriver driver = new AndroidDriver(url, options);
		
		driver.quit(); 
		service.stop();
		
	}
}
