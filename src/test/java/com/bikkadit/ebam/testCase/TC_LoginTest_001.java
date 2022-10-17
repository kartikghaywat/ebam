package com.bikkadit.ebam.testCase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.bikkadit.ebam.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {
		
		driver.get(baseUrl);
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage (driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		
		if ( driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			assertTrue(true);
			logger.info("Test has pass");
		}
		
			else
			assertTrue(false);
		logger.info("Test has failed");
	   }
		
	}

	
	
	
	

