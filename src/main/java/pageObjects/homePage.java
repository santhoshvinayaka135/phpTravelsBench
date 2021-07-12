package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='dropdown dropdown-login dropdown-tab']/a")
	WebElement account;

	@FindBy(xpath = "//div/a[contains(text(),'Sign Up')]")
	WebElement signUp;

	public WebElement Account() {
		return account;
	}

	public WebElement SignUp() {
		return signUp;
	}

	public RegistrationPage SignUpProcess() {

		// Click on myAccount button
		account.click();
		// Click on Sign up button
		signUp.click();
		return new RegistrationPage(driver);
	}
}
