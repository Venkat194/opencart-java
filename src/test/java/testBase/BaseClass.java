package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;  //log4j
public Properties p;
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//loading config.properties file 
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		//logger = LogManager.getLogger(this.getClass())
		//logger = LogManager.getLogger(this.getClass());
		
		
		ChromeOptions option1 = new ChromeOptions();
		EdgeOptions option2 = new EdgeOptions();
		option1.addArguments("--incognito");
		option2.addArguments("--incognito");
		
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(option1); break;
		case "edge" : driver = new EdgeDriver(option2); break;
		default : System.out.println("Invalid browser name"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}

	public String randomstring()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(10);
		return generatedstring;
	}
	

	public String randomnumber()
	{
		String randomnumber = RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}
	
	public String randomalphanumeric()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(3);
		String randomnumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@!"+randomnumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
