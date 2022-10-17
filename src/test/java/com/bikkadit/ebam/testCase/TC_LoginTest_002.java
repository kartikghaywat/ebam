package com.bikkadit.ebam.testCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bikkadit.ebam.pageobject.LoginPage;
import com.bikkadit.ebam.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass{
@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
	
LoginPage lp=new LoginPage(driver);
lp.setUsername(user);
	logger.info("user name Provider");
	lp.setPassword(pwd);
	logger.info("password provider");
	lp.clickSubmit();
	
	Thread.sleep(3000);
	if (isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		
		logger.warn("Login failed"); // username and password galt dalne to ye alter windwo aayega
	}
	else {
		Assert.assertTrue(true);
	logger.info("Login passed");
	lp.clickLogout();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();// alter window nh aayega to ye condition pass hogi
	
	}
	
	 }
public boolean isAlertPresent ()
{
	try {
		driver.switchTo().alert();
		return true;
		
	}
	catch (NoAlertPresentException e) {
		return false;
	}
}
 @DataProvider(name="LoginData")
 String [][] getData() throws IOException{
	String path=System.getProperty("user.dir")+"/src/test/java/com/bikkadit/ebam/testData/LoginData.xlsx";
	 
		 int rownum = XLUtils.getRowCount(path, "Sheet1");
	int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata [][]=new String [rownum] [colcount];
	for (int i=1;i<=rownum;i++) {
		for (int j=0;j<colcount;j++) {
		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	return logindata;			
 }
}