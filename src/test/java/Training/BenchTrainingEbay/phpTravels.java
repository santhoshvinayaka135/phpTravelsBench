package Training.BenchTrainingEbay;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.RegistrationPage;
import pageObjects.afterLoginPage;

public class phpTravels {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\santvina\\Desktop\\new\\chromedriver.exe");
		// Initiate chrome driver
		driver = new ChromeDriver();
		// Maximize the window
		driver.manage().window().maximize();
		// navigate to URL
		driver.get("https://www.phptravels.net/home");
		// delete cookies
		driver.manage().deleteAllCookies();
	}

	@Test()
	public void One() throws InterruptedException, IOException {

		homePage hp = new homePage(driver);
		RegistrationPage rp= hp.SignUpProcess();
		afterLoginPage alp = rp.LoginProcess();
		alp.VerifyProcess();

	}

	@AfterMethod
	public void afterMethod() {
		// close the browser window
		driver.close();

	}

	@AfterTest
	public void afterTest() {
		// close the browser
		driver.quit();
		driver = null;
	}

}
