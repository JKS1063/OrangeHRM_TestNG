package Functionalities;

import Utilities.Reports;

//import org.openqa.selenium.WebElement;

//import Utilities.Utils;

public class F1_Login extends Reports{
	
	public void navigate() {
		getDriver().get(website);
		getDriver().manage().window().maximize();
	}
	
	public boolean profileDisplayed() {
		try {
			boolean profile = getWebEle(profileIconPath).isDisplayed();
			
			if (profile) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Unable to located the 'profile' Element");
		}
		
		return false;
	}
	
	public boolean timeAtWorkDisplayed() {
		
		try {
			boolean timeAtWork = getWebEle(timeAtWorkPath).isDisplayed();
			
			if (timeAtWork) {
				return true;
			}
			}  catch (Exception e) {
				System.out.println("Unable to locate 'time at work' Element");
			}
		
			return false;
		}
	
	
	public void logIn(String username, String password) {
		try {
			getWebEle(usernamePath).sendKeys(username);
			getWebEle(passwordPath).sendKeys(password);
			getWebEle(loginButtonPath).click();
			Thread.sleep(3000);
			if (profileDisplayed() && timeAtWorkDisplayed()) {
				System.out.println("Successfully logged In");
			} else {
				System.out.println("Login not successfull");
			}
			
		}
		catch (Exception e) {
			System.out.println("Unable to login");
		}
	}
	
	public void logOut() {
		
		try {
			syncWait(5);
			getWebEle(profileIconPath).click();
			syncWait(5);
			getWebEle(logoutPath).click();
		} catch (Exception e) {
			System.out.println("Unable to logout");
		}
	}
}
