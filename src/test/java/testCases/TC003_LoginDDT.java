package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/


public class TC003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void verify_loginDDT(String email, String password, String exp)
	{
	
		//Home page
			Homepage hp=new Homepage(driver);
			hp.clickaccount();
			hp.clicklogin();
			
				
			//Login page
			Loginpage lp=new Loginpage(driver);
			lp.emailaddress(email);
			lp.password(password);
			lp.login();
				
			//My Account Page
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
//			if(exp.equalsIgnoreCase("Valid"))
//			{
//				if(targetPage==true)
//				{
//					macc.clickLogout();
//					Assert.assertTrue(true);
//				}
//				else
//				{
//					Assert.assertTrue(false);
//				}
//			}
//			
//			if(exp.equalsIgnoreCase("Invalid"))
//			{
//				if(targetPage==true)
//				{
//					macc.clickLogout();
//					Assert.assertTrue(false);
//				}
//				else
//				{
//					Assert.assertTrue(true);
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			Assert.fail("An exception occurred: " + e.getMessage());
//		}
//			
//		logger.info("**** Finished TC_003_LoginDDT *****");
}
	
}








