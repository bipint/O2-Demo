

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	final WebDriver driver;
	

	@FindBy(how = How.CSS, using = "input#FirstName")
	private WebElement textFirstName;
	@FindBy(how = How.CSS, using = "input#LastName")
	private WebElement textLastName;
	@FindBy(how = How.CSS, using = "input[id$='mailAddress']")
		private WebElement textUserName;
	@FindBy(how = How.CSS, using  = "div#username-errormsg-and-suggestions span")
	private WebElement unameValidation;
	@FindBy(how = How.CSS, using = "input#Passwd")
		private WebElement txtPwd;
	@FindBy(how = How.CSS, using = "input#PasswdAgain")
		private WebElement txtconfPwd;
	@FindBy(how = How.CSS, using = "span#BirthMonth div")
	private WebElement drpMonth;
	@FindBy(how = How.CSS, using = "span#BirthMonth div.goog-menu div div")
	private WebElement drpMonth2;
	@FindBy(how = How.CSS, using = "input#BirthDay")
	private WebElement txtDay;
	@FindBy(how = How.CSS, using = "input#BirthYear")
	private WebElement txtYear;
	
	@FindBy(how = How.CSS, using = "div#Gender div")
	private WebElement drpGender;
	@FindBy(how = How.CSS, using = "div#Gender div.goog-menu div div")
	private WebElement drpGenderlst;
	
	@FindBy(how = How.CSS, using = "input#RecoveryPhoneNumber")
	private WebElement txtPhone;
	@FindBy(how = How.CSS, using = "input#RecoveryEmailAddress")
	private WebElement txtEmail;
	
	@FindBy(how = How.CSS, using = "input#TermsOfService")
	private WebElement chkTermsAccept;
	
	
	
	@FindBy(how = How.CSS, using = "input#submitbutton")
	private WebElement btnNextStep;
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitToLoad() {

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return  d.findElement(By.cssSelector("input#submitbutton")).isEnabled();
            }
        });	
		new WebDriverWait(driver, 40).until(ExpectedConditions
		        .elementToBeClickable(btnNextStep));

	}
	
	public void enteruserName(String uname) {
		textUserName.clear();
		textUserName.sendKeys(uname);
	}
	
	public void enterflNames(String first, String last) {
		textFirstName.clear();
		textFirstName.sendKeys(first);
		
		textLastName.clear();
		textLastName.sendKeys(last);
	}
	
	public void enterpwd(String pwd) {
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
	}
	
	public void enterconfpwd(String cpwd) {
		txtconfPwd.clear();
		txtconfPwd.sendKeys(cpwd);
	}
	

	
	// Method to put DOB
	public void enterDOB(String month, String day, String year) {
		drpMonth.click();
		
		List<WebElement>  lst = driver.findElements(By.cssSelector("span#BirthMonth div.goog-menu div div"));
		for (WebElement option : lst) {
			if (option.getText().contains(month)) {
				option.click();
			}

		}

		//txtDay.clear();
		txtDay.sendKeys(day);
		//txtYear.clear();
		txtYear.sendKeys(year);
	}
	
	public void enterGender(String gender) {
		drpGender.click();
		
		List<WebElement>  lst = driver.findElements(By.cssSelector("div#Gender div.goog-menu div div"));
		for (WebElement option : lst) {
			if (option.getText().contains(gender)) {
				option.click();
			}

		}
	}
	public void enterPhone(String pno) {
		txtPhone.clear();
		txtPhone.sendKeys(pno);
	}
	
	
	public void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void agreeTerms() {
		chkTermsAccept.click();
	}
	
	public void submitForm() {
		btnNextStep.click();
	}
	
	public void verifyMissingUserName() {
		
		junit.framework.Assert.assertEquals(unameValidation.getText(), "You can't leave this empty.");
	}
	

	

	public UserSignUpIdvChallengePage fillValidDetails(String uname, String first, String last,  String pwd, String month,
			String day, String year,String gender, String pno, String email) {
		waitToLoad();
		enterflNames(first,last);
		enteruserName(uname);
		enterpwd(pwd);
		enterconfpwd(pwd);
		enterDOB(month,day,year);
		enterPhone(pno);
		enterEmail(email);
		agreeTerms();
		submitForm();
			return PageFactory.initElements(driver, UserSignUpIdvChallengePage.class);
	}
	
	public RegistrationPage fillINValidDetails(String uname,String first, String last,  String pwd, String month,
			String day, String year,String gender, String pno, String email) {
		waitToLoad();
		enterflNames(first,last);
		enterpwd(pwd);
		enterconfpwd(pwd);
		enterDOB(month,day,year);
		enterPhone(pno);
		enterEmail(email);
		agreeTerms();
		submitForm();
		
			return PageFactory.initElements(driver, RegistrationPage.class);
	}
	


}
