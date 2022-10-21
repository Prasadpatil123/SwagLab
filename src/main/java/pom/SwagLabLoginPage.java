package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parameterization;

public class SwagLabLoginPage {
	@FindBy (xpath = "//input[@id='user-name']") private WebElement username;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']") private WebElement login;
	@FindBy (xpath = "//button[@class='error-button']") private WebElement errorMsg;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(int row, int cell) throws EncryptedDocumentException, IOException
	{
		username.sendKeys(Parameterization.getExcelData("data", row, cell));
	}
	
	public void enterPassword(int row, int cell) throws EncryptedDocumentException, IOException
	{
		password.sendKeys(Parameterization.getExcelData("data", row, cell));
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnError()
	{
		errorMsg.click();
	}
}
