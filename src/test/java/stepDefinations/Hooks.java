package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    // Before scenario hook to initialize the browser
    @Before
    public void initBrowser() throws IOException {
        initializeBrowser();  // Use method from BaseClass to initialize the browser
    }

    // After scenario hook to quit the browser and capture screenshots on failure
    @After
    public void quitBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); // Cast driver to TakesScreenshot
            scenario.attach(screenshot, "image/png", scenario.getName());  // Attach the screenshot to the report
        }
        
        tearDown();  // Use method from BaseClass to close the browser
    }
}
