package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Loginpage 
{
	public WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")WebElement txtusername;
	@FindBy(name="password")WebElement txtpassword;
	@FindBy(xpath="//*[@type='submit']")WebElement btnlogin;

	public void enterUsername(String username)
	{
		txtusername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
	}


}


