package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.SwagLabsPageElements;

@Listeners(utility.Listeners.class)
public class SwagLabLoginPageTest extends SwagLabsPageElements{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.openChromeBrowser();
	}
	
	@Test
	public void SwagLabLoginTest() throws Exception
	{
		test = reports.createTest("validateSwagLabLogin");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName(0, 0);
		swagLabLoginPage.enterPassword(1, 0);
		swagLabLoginPage.clickOnLogin();
		
		String expectedurl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
	}
	
	@AfterMethod
	public void captureResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void flushResults()
	{
		reports.flush();
		driver.close();
	}
	
}
