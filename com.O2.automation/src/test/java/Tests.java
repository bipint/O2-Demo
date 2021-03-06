

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

public class Tests extends TestCase{
	
	WebDriver driver;

	private static String loadUrl = "https://www.google.co.uk/";
	private static String fname = "Bipin";
	private static String lname = "Tiwari";
	private static String uname = "John6578";
	private static String password = "P@ssw0rd534532";
	private static String month = "August";
	private static String day = "23";
	private static String year = "1985";
	private static String gender = "Male";
	private static String phone = "9867549890";
	
	private static String email = "test@test.com";
	
	@Before
	public void setUp() throws Exception {
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	
	
	@Test
	public void test_fillValidDetails() throws Exception {
		driver.get(loadUrl);
		driver.manage().window().maximize();
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		
		LoginPage loginPage = launchPage.getLoginPage();
		RegistrationPage registerPage = loginPage.createAccount();
		UserSignUpIdvChallengePage finalPage = registerPage.fillValidDetails(uname, fname,lname, password, month, day, year,gender, phone, email);
		//Follows the testing
		finalPage.verifyAccountlink();
	}
	
	@Test
	public void test_fillINValidDetails() throws Exception {
		driver.get(loadUrl);
		driver.manage().window().maximize();
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		
		LoginPage loginPage = launchPage.getLoginPage();
		RegistrationPage registerPage = loginPage.createAccount();
		RegistrationPage finalPage = registerPage.fillINValidDetails(uname, fname,lname, password, month, day, year,gender, phone, email);
		finalPage.verifyMissingUserName();
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
