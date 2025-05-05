package pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")
	WebElement ViewProfile;

	@FindBy(css = "ul.collection > li.collection-item")
	List<WebElement> QuickLinks;

	@FindBy(css = "#lazyKeySkills span.edit.icon")
	WebElement clickKeySkillEditBtn;

	@FindBy(css = "input[id='keySkillSugg']")
	WebElement AddskillTestBox;

	@FindBy(css = "button[id='saveKeySkills']")
	WebElement SkillSaveBtn;

	@FindBy(css = "span.chip.typ-14Medium")
	List<WebElement> verifyKeyskill;

	@FindBy(xpath = "//*[@id='root']/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/a")
	WebElement ResumeClick;
	
	@FindBy(xpath = "//*[@id='lazyAttachCV']/div/div[2]/div[1]/div/div[1]/div/div[2]")
	WebElement dateElement;
	

	// Actions

	public void clickViewProfile() {

		ViewProfile.click();

	}

	public void clickKeySkill() {
		for (WebElement link : QuickLinks) {
			String text = link.getText().trim();
			if (text.equalsIgnoreCase("Key skills")) {
				link.click();
				break;
			}
		}

	}

	public void clickKeySkilIcon() {

		clickKeySkillEditBtn.click();
	}

	public void addSkill(String skill) throws InterruptedException {

		AddskillTestBox.click();
		Thread.sleep(2000);
		AddskillTestBox.sendKeys(skill);

	}

	public void saveSkillBtn() {
		SkillSaveBtn.click();
	}

	public boolean isSkillPresent() {
		for (WebElement link1 : verifyKeyskill) {
			String text = link1.getText().trim();
			if (text.equalsIgnoreCase("Automation Test")) {
				return true;
			}
		}
		return false;
	}

	public void ClickUpdateResume() {
		ResumeClick.click();
	}

	public void uploadResume(String path) {

		ResumeClick.sendKeys(path);
	}
	
	public String getActualDate() {
		String fullText = dateElement.getText().trim();  // e.g., "Uploaded on May 04, 2025"
	    System.out.println("Full text: " + fullText);

	    // Extract just the date
	     return fullText.replace("Uploaded on", "").trim();  // May 04, 2025
	   
	}
	
	public String getExpectedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        return sdf.format(new Date());
	}
}
