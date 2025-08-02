package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(id = "input-email")
	WebElement inputemail;
	
	@FindBy(id = "input-password")
	WebElement inputpwd;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement btnlogin;
	
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	WebElement lnklogout;
	
	@FindBy(xpath = "(//a[text()=\"Forgotten Password\"])[1]")
	WebElement lnkfgtpwd;
	
	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement txtlogout;
	
	@FindBy(xpath = "//h1[text()=\"Forgot Your Password?\"]")
	WebElement txtfrgtpwd;
	
	
	public void emailaddress(String email)
	{
		inputemail.sendKeys(email);
	}
	
	public void password(String password)
	{
		inputpwd.sendKeys(password);
	}
	
	public void login()
	{
		btnlogin.click();
	}
	
	public void logout()
	{
		lnklogout.click();
	}
	
	public void forgotpassword()
	{
		lnkfgtpwd.click();
	}
	
	
	public boolean textfrgtpwd()
	{
		boolean status =txtfrgtpwd.isDisplayed();
		
		return status;
	}
	
	public boolean logouttext()
	{
		boolean status =txtlogout.isDisplayed();
		return status;
	}
}
