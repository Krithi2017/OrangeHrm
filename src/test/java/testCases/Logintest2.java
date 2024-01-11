package testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Loginpage;
import testBase.Baseclass;

public class Logintest2 extends Baseclass {
	
	@Test
	public void loginTest()
	{
    logger=LogManager.getLogger(this.getClass());
    Loginpage lp=new Loginpage(driver);
    lp.enterUsername(br.getString("username"));
    logger.info("Entered username");
    lp.enterPassword(br.getString("password"));
    logger.info("Enter password");
    lp.clickLogin();
    logger.info("Clicked login");
    
   // Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    
    if(driver.getTitle().equals("OrangeHRM"))
    {
    	logger.info("Test is passed");
    }
    else
    {
      logger.info("Test is failed");	
    }
	}

}


    
    
