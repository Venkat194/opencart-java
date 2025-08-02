package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends BasePage{
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath = "//a[normalize-space()=\"Register\"]")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement lnklogin;
	
	public void clickaccount()
	{
		lnkmyaccount.click();
	}
	
	public void clickregister()
	{
		lnkRegister.click();
	}
	
	public void clicklogin()
	{
		lnklogin.click();
	}
}

