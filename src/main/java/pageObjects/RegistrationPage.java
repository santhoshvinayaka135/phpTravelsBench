package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	WebElement first;

	@FindBy(name = "lastname")
	WebElement last;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement pass;

	@FindBy(name = "confirmpassword")
	WebElement confirm;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement button;

	public WebElement firstName() {
		return first;
	}

	public WebElement lastName() {
		return last;
	}

	public WebElement contact() {
		return phone;
	}

	public WebElement emailId() {
		return email;
	}

	public WebElement password() {
		return pass;
	}

	public WebElement confirmPassword() {
		return confirm;
	}

	public WebElement signUpButton() {
		return button;
	}

	public afterLoginPage LoginProcess() throws IOException {
		// Create a object for dataDriver class
		dataDriven a = new dataDriven();
		ArrayList<String> data = a.getDataa("Registration");
		// Enter first name
		first.sendKeys(data.get(1));
		//data.get(2);
		// Enter last name
		last.sendKeys(data.get(2));
		// Enter contact
		phone.sendKeys(data.get(3));
		// Enter email
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		email.sendKeys("username" + randomInt + "@gmail.com");
		// email.sendKeys("tz2@gmail.com");
		// Enter password
		String s = RandomStringUtils.randomAlphanumeric(8);
		pass.sendKeys(s);
		// Confirm password
		confirm.sendKeys(s);
		// Click on signUp button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
		button.click();

		return new afterLoginPage(driver);
	}

}
