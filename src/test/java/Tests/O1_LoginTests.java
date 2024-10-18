package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Functionalities.F1_Login;

public class O1_LoginTests extends F1_Login{

	String reportPath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\OrangeHRM\\Reports\\loginTest.html";
	String reportName = "Login Tests";
	String docTitle = "OrangeHRM Login Tests";
	String author = "Jaya Krishna Sekhar";
	String screenShotPath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\ScreenShots\\";
	//Valid Logins
	String validTestName = "Valid Login Test";
	String validTestInfo = "This test is being done to check for successfull Login";
	String validPassInfo = "Test Passed: User successfully logged In";
	String validFailInfo = "Test Failed: User unable to log In";
	String validFailscreenShotName = "unable_to_login.jpg";
	//Invalid Logins
	String invalidTestName = "Invalid Login Test";
	String invalidTestInfo = "User should not able to login with invalid Credentials";
	String invalidPassInfo = "Test Passed: User unable to login";
	String invalidFailInfo = "Test Failed: User able to login with invalid Credentials";
	String invalidFailscreenShotName = "able_to_login.jpg";
	
	@BeforeTest
	public void report() {
		reports(reportPath, reportName, docTitle);
	}
	
	@Test (priority = 1, groups = {"Smoke", "Regression"})
	public void validLogin() throws Exception{
		navigate();
		Thread.sleep(2000);
		logIn(username, password);
		syncWait(5);
		result(profileDisplayed(), validTestName, validTestInfo, author, 
				validPassInfo, validFailInfo, validFailscreenShotName, screenShotPath);
		Thread.sleep(2000);
		logOut();
	}
	
	@Test (priority = 2)
	public void invalidLogin() throws Exception {
		navigate();
		Thread.sleep(2000);
		logIn("", "");
		syncWait(5);
		result(!profileDisplayed(), invalidTestName, invalidTestInfo, author, 
				invalidPassInfo, invalidFailInfo, invalidFailscreenShotName, screenShotPath);
		Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public void invalidLogin2() throws Exception{
		navigate();
		Thread.sleep(2000);
		logIn(username, "");
		syncWait(5);
		result(!profileDisplayed(), invalidTestName, invalidTestInfo, author, 
				invalidPassInfo, invalidFailInfo, invalidFailscreenShotName, screenShotPath);
		Thread.sleep(2000);
	}
	
	@Test (priority = 4)
	public void invalidLogin3() throws Exception{
		navigate();
		Thread.sleep(2000);
		logIn("", password);
		syncWait(5);
		result(!profileDisplayed(), invalidTestName, invalidTestInfo, author, 
				invalidPassInfo, invalidFailInfo, invalidFailscreenShotName, screenShotPath);
		Thread.sleep(2000);
	}
	
	@Test (priority = 5)
	public void invalidLogin4() throws Exception{
		for (int i = 0; i < wrongUsernames.length; i++) {
			
			for (int j = 0; j < wrongPasswords.length; j++) {
				navigate();
				Thread.sleep(2000);
				logIn(wrongUsernames[i], wrongPasswords[j]);
				syncWait(5);
				result(!profileDisplayed(), invalidTestName, invalidTestInfo, author, 
						invalidPassInfo, invalidFailInfo, invalidFailscreenShotName, screenShotPath);
				Thread.sleep(2000);
			}
		}
	}
	
	@AfterTest
	public void reportQuit() throws Exception{
		quitReport(reportPath);
	}
}
