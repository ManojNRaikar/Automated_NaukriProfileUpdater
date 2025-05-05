package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locater
	@FindBy(xpath = "//a[text()='Login']")
	WebElement LoginBtn;

	@FindBy(css = "input[placeholder='Enter your active Email ID / Username']")
	WebElement UserName;

	@FindBy(css = "input[placeholder='Enter your password']")
	WebElement Password;

	@FindBy(css = "button[type='submit']")
	WebElement LoginSubmitBtn;
	
	@FindBy(css = "div[title='Manoj N Raikar']")
	WebElement UserNameVerify;

	// Actions

	public void clickLogin() {
		Actions actions = new Actions(driver);
        actions.moveToElement(LoginBtn).click().build().perform();

        System.out.println("Hovered and clicked on Login!");

	}
	

	public void login(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginSubmitBtn.click();
	}
	
	public String getUserName() {
		
		return UserNameVerify.getText();
	}
}
