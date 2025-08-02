package testCases;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
	
	@Test(dataProvider = "dp",groups={"Sanity","Regression","Master"})
	public void login(String username,String pwd) throws InterruptedException
	{
		Homepage hp= new Homepage(driver);
		hp.clickaccount();
		hp.clicklogin();
		Loginpage lpage = new Loginpage(driver);
		lpage.emailaddress(username);
		lpage.password(pwd);
		lpage.login();
		Thread.sleep(2000);
	}

	
	@org.testng.annotations.DataProvider(name="dp")
	Object[][] logindata()
	{
		Object data[][]= {
				{"venkat1234321@gmail.com","venkat123321"}
				};
		return data;
	}
		
	}


