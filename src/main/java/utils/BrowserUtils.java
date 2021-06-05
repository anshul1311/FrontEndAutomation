package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtils implements BrowserInterface<WebDriver> {
	private static WebDriver driver;
	static String browser_driver_path;
	private String browser;



	@Override
	public void driver(WebDriver webDriver, String browserName) throws IOException {
		this.driver=webDriver;
		browser=browserName;
		invokeBrowser();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public  WebDriver invokeBrowser() throws IOException {
		File file = new File("user.dir" + "/sr/main/resources");
		if (file.exists()) {
			browser_driver_path = System.getProperty("user.dir") + "/src/main/resources/Drivers";

		} else {
			browser_driver_path = System.getProperty("user.dir") + "/src/main/resources/Drivers/";
		}

		if (browser.equals("firefox")) {
			if (OSValidator.isWindows()) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				System.setProperty("webdriver.gecko.driver", browser_driver_path + "/geckodriver.exe");
				driver = new FirefoxDriver(cap);
			}
		} else if (browser.equals("chrome")) {
			if (OSValidator.isUnix()) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				System.setProperty("webdriver.chrome.driver", browser_driver_path + "/chromedriver");
				driver = new ChromeDriver();
				//driver.get(readConfig.getUrl());

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
		}


		return driver;
	}


}

