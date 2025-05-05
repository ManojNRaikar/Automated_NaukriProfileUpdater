package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass; // Import this to access shared WebDriver
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import utils.ConfigReader;

public class NaukriStepDefinitions {

	LoginPage loginPage;
	ProfilePage profilePage;
	ConfigReader config;
	WebDriver driver = BaseClass.getDriver(); // Correctly initialize driver

	// Reusable login method
	private void loginToNaukri() throws InterruptedException {
		config = new ConfigReader();
		loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.clickLogin();
		Thread.sleep(2000);
		loginPage.login(config.getProperty("user.name"), config.getProperty("pass.word"));
		Thread.sleep(3000);
	}

	@Given("user navigates to Naukri login page")
	public void openLoginPage() {
		System.out.println("Naukri Home Page Launched......");
	}

	@When("user enters username and password")
	public void enterCredentials() throws InterruptedException {
		loginToNaukri();
		Thread.sleep(3000);
	}

	@Then("user is logged in")
	public void verifyLogin() {
		Assert.assertEquals(loginPage.getUserName(), config.getProperty("User.Name.Verify"));
	}

	@Given("user is on Naukri profile page")
	public void openProfilePage() throws InterruptedException {
		loginToNaukri();
	}

	@When("user added Key skill {string}")
	public void updateKeyskills(String skill) throws InterruptedException {
		profilePage = new ProfilePage(driver); // Make sure profilePage is initialized here
		profilePage.clickViewProfile();
		Thread.sleep(2000);
		profilePage.clickKeySkill();
		Thread.sleep(2000);
		profilePage.clickKeySkilIcon();
		Thread.sleep(2000);
		profilePage.addSkill(skill);
		profilePage.saveSkillBtn();
		Thread.sleep(2000);

	}

	@Then("skill is updated successfully")
	public void SkillUpdated() {
		// Add proper assert here
		Assert.assertTrue(profilePage.isSkillPresent());
	}

	@When("user uploads new resume from {string}")
	public void uploadResume(String path) throws InterruptedException {
		profilePage = new ProfilePage(driver); // Initialize before use

		profilePage.clickViewProfile();
		Thread.sleep(2000);
		profilePage.ClickUpdateResume();
		Thread.sleep(3000);
		profilePage.uploadResume(path);
		Thread.sleep(2000);
	}

	@Then("resume is uploaded successfully")
	public void resumeUploaded() {

		Assert.assertEquals(profilePage.getActualDate(), profilePage.getExpectedDate());

	}
}
