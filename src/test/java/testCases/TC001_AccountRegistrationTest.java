package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Sanity","Regression","Master"})
	public void accountregistration() throws InterruptedException
	{
		//logger.info("****Testcasestarted****");
		Homepage hp = new Homepage(driver);
		hp.clickaccount();
		hp.clickregister();
		//logger.info("openedregistrationpage");
		AccountRegistration ar = new AccountRegistration(driver);
		
		ar.setFirstName(randomstring().toUpperCase());
		ar.setLastName(randomstring().toUpperCase());
		
		ar.setEmail(randomstring()+"@gmail.com");
		ar.setTelephone(randomnumber());
		
		String password = randomalphanumeric();
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		Thread.sleep(3000);
		ar.setPrivacyPolicy();
		ar.clickContinue();
		String conmsg= ar.getConfirmationMsg();
		
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
		//logger.info("Account created....Testcase passed");
	}
}
