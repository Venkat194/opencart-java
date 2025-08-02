package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.BaseClass;

public class TC005_ForgotPassword extends BaseClass{
	
	
	@Test
	public void forgotpassword()
	{
		Homepage hp= new Homepage(driver);
		hp.clickaccount();
		hp.clicklogin();
		Loginpage lpage = new Loginpage(driver);
		lpage.forgotpassword();
		lpage.textfrgtpwd();
		Assert.assertEquals(lpage.textfrgtpwd(), true);
		
	}

}
