


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {
	final WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a.gb_m")
	private WebElement gmailLink;
	
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickGmailLink() {
	(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return  gmailLink.isEnabled();
            }
        });

	
		new WebDriverWait(driver, 40).until(ExpectedConditions
		        .elementToBeClickable(gmailLink));
		
//		Actions action = new Actions(driver);
//		//loginLink.getAttribute("rel");
//		WebElement we = driver.findElement(By.cssSelector("ul#AccountNavigation.AccountNavigation li a.ajaxLogin"));
//		action.moveToElement(we).build().perform();
		
		
		gmailLink.click();

	}

	public LoginPage getLoginPage() {
		clickGmailLink();
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
