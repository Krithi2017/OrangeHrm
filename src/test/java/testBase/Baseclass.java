package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;






public class Baseclass {
	
	
	public	static WebDriver driver;
		public Logger logger;
		public ResourceBundle br;

		@BeforeClass
		@Parameters({"browser"})
		public void setUp(String browser)
		{
			br = ResourceBundle.getBundle("config");//Load the config properties file
			logger=LogManager.getLogger(this.getClass());
			
			if(browser.equals("chrome")) {
		  driver = new ChromeDriver();
		  logger.info("Launched chromebrowser");
			}
			else if(browser.equals("edge"))
			{
				driver=new EdgeDriver();
				logger.info("Launched edge browser");
			}
			else
			{
				driver=new ChromeDriver();
				logger.info("Launched chrome browser");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(br.getString("appurl"));
			logger.info("Navigated to webside");
		     
					
		}
		
		@AfterClass
		public void browserClose()
		{
			driver.close();

}

		public void captureScreenshot(String tname) throws IOException
		{
			String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"//screenshots\\"+tname+timestamp+".png");
			FileUtils.copyFile(source, target);
			
			
		}
	}
