package Utilities;

import java.util.*;
import java.util.stream.Collectors;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils extends Drivers{
	
	public String website = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	//Login functionality Xpaths
	public String usernamePath = "//input[@name = 'username']";
	public String passwordPath = "//input[@name = 'password']";
	public String loginButtonPath = "//button[@type = 'submit']";
	
	public String profileIconPath = "(//img[@alt = 'profile picture'])[1]";
	public String aboutPath = "//*[text() = 'About']";
	public String supportPath = "//*[text() = 'Support']";
	public String changePasswordPath = "//*[text() = 'Change Password']";
	public String logoutPath = "//*[text() = 'Logout']";
	
	public String timeAtWorkPath = "//*[text() = 'Time at Work']";
	public String myActionsPath = "//*[text() = 'My Actions']";
	public String quickLaunchPath = "//*[text() = 'Quick Launch']";
	public String buzzLatestPosts = "//*[text() = 'Buzz Latest Posts']";
	public String employeesLeavePath = "//*[text() = 'Employees on Leave Today']";
	public String employeeDistributionSubUnitPath = "//*[text() = 'Employee Distribution by Sub Unit']";
	public String employeeDistributionLocation = "//*[text() = 'Employee Distribution by Location']";
	
	public String username = "Admin";
	
	public String[] wrongUsernames = {"admin", "@^^&&^*&*", "a", "Adminldofoekfoeadlrodoadorlgl"};
	public String wrongUsername = "admin";
	public String wrongUsernameSplChr = "@^^&&^*&*";
	public String wrongUsername1Chr = "a";
	public String wrongUsernamelengthy = "Adminldofoekfoeadlrodoadorlgl";
	
	public String[] wrongPasswords = {"123admin", "^&^%$$&*()", "A",  "admin123i()*i3kxsekde34k*()$ad"};
	public String password = "admin123";
	public String wrongPassword = "123admin";
	public String wrongPasswordSplChr = "^&^%$$&*()";
	public String worngPassword1Chr = "A";
	public String wrongPasswordlengthy = "admin123i()*i3kxsekde34k*()$ad";
	
	//PIM functionality Xpaths
	public String pimPath = "//*[text() = 'PIM']";
	public String empInfo = "//*[text() = 'Employee Information']";
	public String searchButtonPath = "//button[@type = 'submit']";
	public String employeeNamePath = "(//input[@placeholder = 'Type for hints...'])[1]";
	public String totalEmployeeRecordsPath = "(//span[@class= 'oxd-text oxd-text--span'])[1]";
	public String employeeIdPath = "(//input[@class = 'oxd-input oxd-input--active'])[2]";
	public String employeeStatusPath = "(//div[@class = 'oxd-select-text-input'])[1]";
	public String[] employeeStatusList = {"Freelance", "Full-Time Contract", "Full-Time Permanent", "Full-Time Probation", "Part-Time Contract", "Part-Time Internship"};
	public String includePath = "(//div[@class = 'oxd-select-text-input'])[2]";
	public String[] includeList = {"Current Employees Only", "Current and Past Employees", "Past Employees Only"};
	public String supervisornamePath = "(//input[@placeholder = 'Type for hints...'])[2]";
	public String jobTitlePath = "(//div[@class = 'oxd-select-text-input'])[3]";
	public String[] jobTitlesList = {"Account Assistant", "Automaton Tester", "Chief Executive Officer", "Chief Financial Officer", "Chief Technical Officer",
			"Content Specialist", "Customer Success Manager", "Database Administrator", "Finance Manager", "Financial Analyst", "Head of Support", "HR Associate", "HR Manager",
			"IT Manager", "Network Administrator", "Payroll Administrator", "Pre-Sales Coordinator", "QA Engineer", "QA Lead", "Sales Representative",
			"Software Architect", "Software Engineer", "Support Specialist", "VP - Client Services", "VP - Sales & Marketing"};
	public String subUnitPath = "(//div[@class = 'oxd-select-text-input'])[4]";
	public String[] subUnitList = {"Administration", "Engineering", "Development", "Quality Assurance", "TechOps", "Sales & Marketing", "Sales", "Marketing",
			"Client Services", "Technical Support", "Finance", "Human Resources", "hola", "juan perez"};
	public String employeeTableXpath = "//div[@class = 'orangehrm-container']";
	public String employeeTableRowsXpath = "//div[@role = 'row']";
	public String employeeTableCellsXpath = "//div[@role = 'cell']";
	public String addEmployeeButtonPath = "//*[text() = ' Add ']";
	public String saveButtonPath = "//*[text() = ' Save ']";
	public String errorMessagePath = "//span[@class = 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
	public String addEmployeeFirstNamePath = "//input[@name = 'firstName']";
	public String addEmployeeLastNamePath = "//input[@name = 'lastName']";
	public String addEmployeeIdPath = "(//input[@class = 'oxd-input oxd-input--active'])[2]";
	public String employeeListPath = "//*[text() = 'Employee List']";
	public String[] invalidPasswords = {"", "jk1064", " aRZANj3H-u\"Q\\D3qQaI*?%Vaw}zALi<?^&ybp`80L6,X~)&mgYLzXLJ#Q0?F`zGu6"};
	public String[] invalidConfirmPasswords = {"", "jk1064", " aRZANj3H-u\"Q\\D3qQaI*?%Vaw}zALi<?^&ybp`80L6,X~)&mgYLzXLJ#Q0?F`zGu6"};
	public String credentialsTogglePath = "//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']";
	public String employeeIdTextPath = "//*[text() = 'Employee Id']";
	public String disabledRadioButtonPath = "//*[text() = 'Disabled']";
	public String addEmployeeUsernamePath = "(//input[@class = 'oxd-input oxd-input--active'])[3]";
	public String addEmployeePasswordPath = "(//input[@class = 'oxd-input oxd-input--active'])[4]";
	public String addEmployeecConfirmPasswordPath = "(//input[@class = 'oxd-input oxd-input--active'])[5]";
	public String createdNamePath= "//*[text() = 'Krishna ']";
	public String otherIdPath = "(//input[@class = 'oxd-input oxd-input--active'])[3]";
	public String drivingLicensePath = "(//input[@class = 'oxd-input oxd-input--active'])[4]";
	public String nationalityDropdownPath = "(//div[@class = 'oxd-select-text-input'])[1]";
	public String nationalityPath = "//*[text() = 'Indian']";
	public String maritalStatusDropdownPath = "(//div[@class = 'oxd-select-text-input'])[2]";
	public String maritalStatusPath = "//*[text() = 'Single']";
	public String dateOfBirthPath = "(//input[@class = 'oxd-input oxd-input--active'])[6]";
	public String genderMalePath = "//*[text() = 'Male']";
	public String bloodDropdownPath = "(//div[@class = 'oxd-select-text-input'])[3]";
	public String bloodSelectPath = "//*[text() = 'B+']";
	public String serviceInputPath = "(//input[@class = 'oxd-input oxd-input--active'])[7]";
	public String driverLicencePath = "C:\\Users\\jayak\\Downloads\\fake_driving_license.jpg";
	public File driverLicenceFile = new File(driverLicencePath);
	public String attachmentsText = "//*[text() = 'Attachments']";
	public String addAttachmentPath = "(//button[@type = 'button'])[4]";
	public String uploadFilePath = "//*[@class = 'oxd-icon bi-upload oxd-file-input-icon']";
	public String commentSectionPath = "//textarea[@placeholder = 'Type comment here']";
	public String personalDetailsSaveButtonPath = "(//*[text() = ' Save '])[2]";
	public String contactDetailsPath = "//*[text() = 'Contact Details']";
	public String homePhonePath = "(//input[@class = 'oxd-input oxd-input--active'])[7]";
	public String homeTextPath = "//*[text() = 'Home']";
	public String mobilePhonePath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input";
	public String mobileTextPath = "//*[text() = 'Mobile']";
	public String workPhonePath  = "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input";
	public String workTextPath = "//*[text() = 'Work']";
	public String contactDetailsSaveButtonPath = "//button[@type = 'submit']";
	public String workEmailInputPath = "(//input[@class = 'oxd-input oxd-input--active'])[10]";
	public String workEmailTextPath = "//*[text() = 'Work Email']";
	public String otherEmailInputPath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input";
	public String otherEmailTextPath = "//*[text() = 'Other Email']";
	
;	public void syncWait(Integer timeInSeconds) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}
	
	public WebElement getWebEle(String Xpath) {
		return getDriver().findElement(By.xpath(Xpath));
	}
	
	public List<WebElement> getEleList(String Xpath) {
		return getDriver().findElements(By.xpath(Xpath));
	}
	
	public List<String> getWebEleTextList(String Xpath) {
		List<String> textList = getEleList(Xpath).stream().map(WebElement:: getText).collect(Collectors.toList());
		return textList;
	}
	
	public List<String> getWebEleAttrList(String Xpath, String attributeName) {
		List<WebElement> elements = getEleList(Xpath);
		List<String> attributes = new ArrayList<String>();
		
		for (WebElement element: elements) {
			String attribute = element.getAttribute(attributeName);
			attributes.add(attribute);
		}
		
		return attributes;
	}
	
	public String getInputString() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input a Relateble String:");
		String str = input.nextLine();
		input.close();
		return str;
	}
	
	public String getWebEleText(String Xpath) {
		String text = getWebEle(Xpath).getText();
		return text;
	}
	
	public void inputSearch(String searchXpath, String findButtonPath, String totalRecordsPath) {
		String strInput = getInputString();
		getWebEle(searchXpath).click();
		getWebEle(searchXpath).sendKeys(strInput);
		getWebEle(findButtonPath).click();
		
		try {
			String records = getWebEleText(totalRecordsPath);
			System.out.println(records);
		} catch (Exception e) {
			System.out.println("Unable to fetch Records");
			e.printStackTrace();
		}
	}
	
	public void dropdownSearchPath(String dropdownXpath, String[] array, String findButtonPath, String totalRecordsPath, String selectObject) {
		
		for (String option: array) {
			getWebEle(dropdownXpath).click();
			syncWait(5);
			String xPath = "(//*[text() = '" + option + "'])[" + selectObject + "]";
			getWebEle(xPath).click();
			getWebEle(findButtonPath).click();
			
			try {
				String records = getWebEleText(totalRecordsPath);
				System.out.println(records);
			} catch (Exception e) {
				System.out.println("Unable to fetch Records");
				e.printStackTrace();
			}
			
		}
	}
	
	public void tableRecords(String tableXpath, String rowXpath, String cellXpath) {
		
		WebElement table = getWebEle(tableXpath);
		
		List<WebElement> rows = table.findElements(By.xpath(rowXpath));
		
		for (WebElement row: rows) {
			List<WebElement> cells = row.findElements(By.xpath(cellXpath));
			
			for (WebElement cell: cells) {
				String value = cell.getText();
				System.out.println(value);
			}
		}
	}
	
	public Integer getWebEleListSize(String xPath) {
		List<WebElement> elements = getEleList(xPath);
		return elements.size();
	}
	
	
}
