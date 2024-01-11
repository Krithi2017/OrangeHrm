package testCases;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.Loginpage;
import testBase.Baseclass;

public class Logintest  extends Baseclass {
	
	
	  @Test
	  @Parameters(("browser"))
	  public void loginTest() throws InterruptedException   {
		  Loginpage lp=new Loginpage(driver);
		  lp.enterUsername(br.getString("username"));
		  logger.info("Entered username");
		  lp.enterPassword(br.getString("password"));
		  lp.clickLogin();
		  logger.info("Clicked login");
		  Thread.sleep(5000);
		  


		  
		  if(driver.getTitle().equals("OrangeHRM"))
		  {
			  Assert.assertTrue(true);
			  logger.info("Test is passed");
		  }
		  else
		  {
			  Assert.assertTrue(false);
			logger.info("test is failed");  
		  }

	  }
}
