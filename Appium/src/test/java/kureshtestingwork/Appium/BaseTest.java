package kureshtestingwork.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

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
		// options.setDeviceName("Pixel 3");
		options.setUdid("mn99wwrweivcnvlr");
		options.setApp("D:\\Appium_Testing\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		URL url = new URL(" http://127.0.0.1:4723");
		//below command for session new creation
		//adb uninstall io.appium.uiautomator2.server
		//adb uninstall io.appium.uiautomator2.server.test
		
		driver = new AndroidDriver(url, options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	//for closing activity
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}
}
