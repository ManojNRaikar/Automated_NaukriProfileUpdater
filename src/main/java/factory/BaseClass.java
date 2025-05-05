package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	protected static WebDriver driver;

	// Method to initialize the browser (run before each test)
	public static WebDriver initializeBrowser() {
		if (driver == null) {
			// Setup ChromeDriver or any other browser of choice
			driver = new ChromeDriver();
			driver.manage().window().maximize(); // Maximize the browser window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.naukri.com/");

		}
		return driver;
	}

	// Method to access the WebDriver instance (used in Step Definitions or Hooks)
	public static WebDriver getDriver() {
		return driver;
	}

	// Method to quit the browser (run after each test)
	public static void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser
			driver = null; // Reset the WebDriver instance
		}
	}
}
