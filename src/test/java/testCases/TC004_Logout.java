package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.BaseClass;

public class TC004_Logout extends BaseClass{
	
	
	@Test()
	public void logout() throws InterruptedException
	{
		Homepage hp= new Homepage(driver);
		hp.clickaccount();
		hp.clicklogin();
		Loginpage lpage = new Loginpage(driver);
		lpage.emailaddress(p.getProperty("username"));
		lpage.password(p.getProperty("password"));
		lpage.login();
		Thread.sleep(2000);
		hp.clickaccount();
		lpage.logout();
		Thread.sleep(2000);
		boolean status =lpage.logouttext();
		System.out.println("logout is displayed ---  "+status);
		Assert.assertEquals(status, true);
		
	}

}
