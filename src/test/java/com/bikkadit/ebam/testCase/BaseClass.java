package com.bikkadit.ebam.testCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bikkadit.ebam.utilities.ReadConfig;
public class BaseClass {

	ReadConfig config =new ReadConfig();
	public static WebDriver driver;
    public static Logger logger;
	
	
	public String baseUrl =config.getApplicationURL(); 
	public String username= config.getusername();
	public String password = config.getpassword();
	
	
	
	@Parameters ("browser") 
	
	@BeforeClass
	public void setup () {
		
//	System.setProperty("webdriver.chrome.driver", "D:\\KARTIK\\kartik\\kartik java programmer\\MavenProject new\\ebam\\Driver\\chromedriver.exe");
	
		System.setProperty("webdriver.chrome.driver", config.getchromepath() );
		
	//	System.setProperty("webdriver.chrome.driver", "./\\Driver\\chromedriver.exe");

		// create the chrome object
		
	 driver = new ChromeDriver();
	 
	 logger = Logger.getLogger("ebam");
	 PropertyConfigurator.configure("log4j.properties");
	 
	// if (br.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", config.getchromepath());
		 driver= new ChromeDriver();
	/* }
	 else if(br.equals("firefox"))	{
		 System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());
		 driver= new FirefoxDriver();
	 }*/
		 
	 driver.get(baseUrl);
	 
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
