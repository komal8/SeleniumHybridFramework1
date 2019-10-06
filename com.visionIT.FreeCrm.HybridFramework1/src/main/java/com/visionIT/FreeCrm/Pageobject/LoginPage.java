package com.visionIT.FreeCrm.Pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class LoginPage {
	@FindBy(name="username")
	WebElement userField;
	
	@FindBy(name="password")
	WebElement passField;
	
	@FindBy(xpath="//input[@value='Login' or @type ='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
	//	Reporter.log("initializing web element on login page ..", true);
		
		this.driver=driver;
		//PageFactory.initElements(driver, LoginPage.class);		
		PageFactory.initElements(driver,this);
		
	}
	
	
	public String verifyFreeCrmLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean verifyCrmProLogo()
	{
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed();
	}
	
	
	public void  verifyloginToCrmPro(String uname, String upass)
	{
		userField.sendKeys(uname);
		passField.sendKeys(upass);
		
		loginBtn.click();
			
	}
	
	public void verifyLogoutCrmPro()
	{
		driver.switchTo().frame("mainpanel");
	
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).click();
	
		driver.switchTo().defaultContent();
	}
}

	

	