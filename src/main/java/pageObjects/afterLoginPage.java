package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class afterLoginPage {

	WebDriver driver;

	public afterLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div/h3)[1]")
	WebElement verify;

	public WebElement Verify() {
		return verify;
	}

	public void VerifyProcess() throws InterruptedException {
		
		Thread.sleep(2000);
		//Expected result
		String expected = "Hi, Tensa Zangetsu";
		//Actual result
		String actual = verify.getText();
		Assert.assertEquals(actual, expected);

	}

}
