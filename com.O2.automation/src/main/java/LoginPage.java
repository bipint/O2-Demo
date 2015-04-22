


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	final WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a#link-signup")
	private WebElement registerLink;

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickRegisterLink() {
	(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return  registerLink.isEnabled();
            }
        });
		new WebDriverWait(driver, 40).until(ExpectedConditions
		        .elementToBeClickable(registerLink));	
		registerLink.click();
	
	}

	public RegistrationPage createAccount() {
	
		clickRegisterLink();
		return PageFactory.initElements(driver, RegistrationPage.class);
	}
}
