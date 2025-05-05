package testRunner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/NaukriProfileUpdate.feature", glue = "stepDefinations", plugin = {
		"pretty", "html:target/cucumber-reports.html" }, tags = "@NaukriUpdate", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public void openReport() {
		try {
			File reportFile = new File("target/cucumber-reports.html");
			System.out.println("Checking for report at: " + reportFile.getAbsolutePath());

			if (reportFile.exists()) {
				System.out.println("Opening report...");
				Desktop desktop = Desktop.getDesktop();

				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					desktop.browse(reportFile.toURI());
				} else {
					System.out.println("Desktop browse action not supported.");
				}
			} else {
				System.out.println("Report file not found!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
