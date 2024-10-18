package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Functionalities.F2_PIM;

public class O2_PIMTests extends F2_PIM{
	String reportPath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\OrangeHRM\\Reports\\PIM_Test.html";
	String reportName = "PIM Tests";
	String docTitle = "OrangeHRM PIM Tests";
	String author = "Jaya Krishna Sekhar";
	String screenShotPath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\OrangeHRM\\ScreenShots\\";
	
	@BeforeTest
	public void report() {
		reports(reportPath, reportName, docTitle);
	}
	
	//PIM navigate
	String pimTestName = "PIM Navigation";
	String pimTestInfo = "Navigate to PIM Page";
	String pimPassInfo = "Test Passed: Sucessfully navigated to PIM Page";
	String pimFailInfo = "Test Failed: Unable to navigate to PIM Page";
	String pimFailScreenShotName = "pim_navigate_fail.jpg";
	
	public void pim() {
		navigate();
		syncWait(5);
		logIn(username, password);
		syncWait(5);
		navigate_PIM();
		syncWait(5);
	}
	
	@Test (priority = 1)
	public void navigatePIM(){
		pim();
		result(employeeInfo(), pimTestName, pimTestInfo, author, pimPassInfo, pimFailInfo, pimFailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName1 = "Employee Name Search";
	String empSearchTestInfo1 = "Searching employee using name";
	String empSearchPassInfo = "Test Passed: Successfully listed out employees, ";
	String empSearchFailInfo = "Test Failed: Unable to search employees";
	String empSearchScreenShotName = "employee_search_fail.jpg";
	
	@Test (priority = 2)
	public void employeeSearch1() {
		pim();
		empNameSearch();
		String records = getWebEle(totalEmployeeRecordsPath).getText();
		result(employeeRecords(), empSearchTestName1, empSearchTestInfo1, author, empSearchPassInfo + records,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName2 = "Employee Id Search";
	String empSearchTestInfo2 = "Searching employee using employee Id";
	@Test (priority = 3)
	public void employeeSearch2() {
		pim();
		empIdSearch();
		syncWait(10);
		String records = getWebEle(totalEmployeeRecordsPath).getText();
		result(employeeRecords(), empSearchTestName2, empSearchTestInfo2, author, empSearchPassInfo + records,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName3 = "Employee Status Search";
	String empSearchTestInfo3 = "Searching employee using employee Status selection";
	@Test (priority = 4)
	public void employeeSearch3() {
		pim();
		employeeStatusSearch();
		syncWait(5);
		result(employeeRecords(), empSearchTestName3, empSearchTestInfo3, author, empSearchPassInfo,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		syncWait(5);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName4 = "Employee Include Search";
	String empSearchTestInfo4 = "Searching employee using Include selection";
	@Test (priority = 5)
	public void employeeSearch4() {
		pim();
		employeeIncludeSearch();
		syncWait(5);
		result(employeeRecords(), empSearchTestName4, empSearchTestInfo4, author, empSearchPassInfo,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
//	String empSearchTestName5 = "Employee Search";
//	String empSearchTestInfo5 = "Searching employee using input";
//	@Test (priority = 6)
//	public void employeeSearch5() {
//		navigate();
//		syncWait(5);
//		logIn(username, password);
//		syncWait(5);
//		navigate_PIM();
//		syncWait(5);
//		employeeSupervisorSearch();
//		String records = getWebEle(totalEmployeeRecordsPath).getText();
//		result(employeeRecords(), empSearchTestName2, empSearchTestInfo2, author, empSearchPassInfo + records,
//				empSearchFailInfo, empSearchScreenShotName, empSearchScreenShotName);
//		syncWait(5);
//		logOut();	
//	}
	
	//Employee Search
	String empSearchTestName6 = "Employee Job Title Search";
	String empSearchTestInfo6 = "Searching employee using Job Title selection";
	@Test (priority = 7)
	public void employeeSearch6() {
		pim();
		employeeJobTitleSearch();
		syncWait(6);
		result(employeeRecords(), empSearchTestName4, empSearchTestInfo4, author, empSearchPassInfo,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName7 = "Employee Sub Unit Search";
	String empSearchTestInfo7 = "Searching employee using Sub Unit selection";
	@Test (priority = 8)
	public void employeeSearch7() {
		pim();
		employeeSubUnitSearch();
		syncWait(6);
		result(employeeRecords(), empSearchTestName4, empSearchTestInfo4, author, empSearchPassInfo,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Employee Search
	String empSearchTestName8 = "Employee Multi Input Search";
	String empSearchTestInfo8 = "Searching employee by giving mutiple inputs";
	@Test (priority = 9)
	public void employeeSearch8() throws Exception{
		pim();
		mutipleInputSearch(); 
		syncWait(6);
		String records = getWebEle(totalEmployeeRecordsPath).getText();
		result(employeeRecords(), empSearchTestName8, empSearchTestInfo8, author, empSearchPassInfo + records,
				empSearchFailInfo, empSearchScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName1 = "Add Employee 1";
	String addEmployeeTestInfo1 = "Adding Employee with no details";
	String addEmployeePassInfo1 = "Test Passed: Unable to add employee to list";
	String addEmployeeFailInfo1 = "Test Failed: Employee add to list with no details";
	String addEmployee1FailScreenshotName = "Employee_added.jpg";
	
	@Test (priority = 10)
	public void addEmployee1() {
		pim();
		emptyEmployeedetails();
		result(errorMessage(), addEmployeeTestName1, addEmployeeTestInfo1, author, addEmployeePassInfo1,
				addEmployeeFailInfo1, addEmployee1FailScreenshotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName2 = "Add Employee 2";
	String addEmployeeTestInfo2 = "Adding Employee with out creating log in details";
	String addEmployeePassInfo2 = "Test Passed: Employee successfully added to list";
	String addEmployeeFailInfo2 = "Test Failed: Unable to add Employee without log n details";
	String addEmployee2FailScreenShotName = "Employee_failed_to_add.jpg";
	
	@Test (priority = 11)
	public void addEmployee2() throws Exception{
		pim();
		noCredentialEmployeedetails();
		result(employeeRecord(), addEmployeeTestName2, addEmployeeTestInfo2, author, addEmployeePassInfo2,
				addEmployeeFailInfo2, addEmployee2FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName3 = "Add Employee 3";
	String addEmployeeTestInfo3 = "Adding employee with empty log in details with status enabled";
	String addEmployeePassInfo3 = "Test Passed: Employee Unable to add to list";
	String addEmployeeFailInfo3 = "Test Failed: Employee added to list with empty log In details";
	String addEmployee3FailScreenShotName = "Employee_added_to_list.jpg";
	@Test (priority = 12)
	public void addEmployee3() {
		pim();
		addEmployeeNoCredentials();
		result(errorMessage(), addEmployeeTestName3, addEmployeeTestInfo3, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName4 = "Add Employee 4";
	String addEmployeeTestInfo4 = "Adding employee with empty log in details with status disabled";
	@Test (priority = 13)
	public void addEmployee4() {
		pim();
		addEmployeeNoCredentials2();
		result(errorMessage(), addEmployeeTestName4, addEmployeeTestInfo4, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName5 = "Add Employee 5";
	String addEmployeeTestInfo5 = "Adding employee with only username in log in details with status enabled";
	@Test (priority = 14)
	public void addEmployee5() throws Exception{
		pim();
		addEmployeeNoCredentials3();
		result(errorMessage(), addEmployeeTestName5, addEmployeeTestInfo5, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName6 = "Add Employee 6";
	String addEmployeeTestInfo6 = "Adding employee without confirm password in log details with status disabled";
	@Test (priority = 15)
	public void addEmployee6() throws Exception{
		pim();
		addEmployeeNoCredentials4();
		result(errorMessage(), addEmployeeTestName6, addEmployeeTestInfo6, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName7 = "Add Employee 7";
	String addEmployeeTestInfo7 = "Adding employee without confirm password again with minimum password length with status enabled";
	@Test (priority = 16)
	public void addEmployee7() throws Exception{
		pim();
		addEmployeeNoCredentials5();
		result(errorMessage(), addEmployeeTestName7, addEmployeeTestInfo7, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName8 = "Add Employee 8";
	String addEmployeeTestInfo8 = "Adding employee without confirm password with more than allowable length with status enabled";
	@Test (priority = 17)
	public void addEmployee8() throws Exception{
		pim();
		addEmployeeNoCredentials6();
		result(errorMessage(), addEmployeeTestName8, addEmployeeTestInfo8, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName9 = "Add Employee 9";
	String addEmployeeTestInfo9 = "Adding employee with login details with mismatching password and confirm password";
	@Test (priority = 18)
	public void addEmployee9() throws Exception{
		pim();
		addEmployeeWithIncorrectCredentials();;
		result(errorMessage(), addEmployeeTestName9, addEmployeeTestInfo9, author, addEmployeePassInfo3,
				addEmployeeFailInfo3, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Employee
	String addEmployeeTestName10 = "Add Employee 10";
	String addEmployeeTestInfo10 = "Adding Employee with all correct Credentials";
	@Test (priority = 19)
	public void addEmployee10() throws Exception{
		pim();
		addEmployeeWithCorrectCredentials();
		result(employeeRecord(), addEmployeeTestName10, addEmployeeTestInfo10, author, addEmployeePassInfo2,
				addEmployeeFailInfo2, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Personal Details
	String addPDTestName = "Add Personal Details";
	String addPDTestInfo = "Add Personal Details to the created employee";
	String addPDPassInfo = "Test Passed: Personal details sucessfully updated";
	String addPDFailInfo = "Test Failed: Unable to update Personal details";
	@Test (priority = 20)
	public void personalDetails() throws Exception{
		pim();
		addPersonalDetails();
		result(employeeRecord(), addPDTestName, addPDTestInfo, author, addPDPassInfo,
				addPDFailInfo, addEmployee3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Phone numbers
	String addCDTestName1 = "Add Telephone Details 1";
	String addCDTestInfo1 = "Update TelePhone Details to user with Special Characters";
	String addCDPassInfo1 = "Test Passed: Unable to add Special Characters to Phone numbers";
	String addCDFailInfo1 = "Test Failed: Telephone updated with special Characters";
	String addCD1FailScreenShotName = "Teleophone_Updated.jpg";
			
	@Test (priority = 21)
	public void contactDetails1() throws Exception{
		pim();
		contactDetailsSplChr();
		result(errorMessage(), addCDTestName1, addCDTestInfo1, author, addCDPassInfo1,
				addCDFailInfo1, addCD1FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Phone numbers
	String addCDTestName2 = "Add Telephone Details 2";
	String addCDTestInfo2 = "Updating Telephone numbers with just single digit";
	String addCDPassInfo2 = "Test Passed: Telephone input is not accepting single Digit and not saved";
	String addCDFailInfo2 = "Test Failed: Telephone number saved with single digit";
	String addCD2FailScreenShotName = "single_digit_phone.jpg";
	@Test (priority = 22)
	public void contactDetails2() throws Exception{
		pim();
		contactDetailsSingleDigit();
		result(errorMessage(), addCDTestName2, addCDTestInfo2, author, addCDPassInfo2,
				addCDFailInfo2, addCD2FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Phone numbers
	String addCDTestName3 = "Add Telephone Details 3";
	String addCDTestInfo3 = "Updating Telephone numbers with more than required numbers";
	String addCDPassInfo3 = "Test Passed: Telephone input is not accepting more Digits and not saved";
	String addCDFailInfo3 = "Test Failed: Telephone number saved with more digit";
	String addCD3FailScreenShotName = "more_digit_phone.jpg";
	@Test (priority = 23)
	public void contactDetails3() throws Exception{
		pim();
		contactDetailsOverDigits();
		result(errorMessage(), addCDTestName3, addCDTestInfo3, author, addCDPassInfo3,
				addCDFailInfo3, addCD3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Phone numbers
	String addCDTestName4 = "Add Telephone Details 4";
	String addCDTestInfo4 = "Updating Telephone numbers with Alphabets";
	String addCDPassInfo4 = "Test Passed: Telephone unable to update with Alphabets";
	String addCDFailInfo4 = "Test Failed: Telephone number saved with Alphabets";
	String addCD4FailScreenShotName = "alphabets_digit_phone.jpg";
	@Test (priority = 24)
	public void contactDetails4() throws Exception{
		pim();
		contactDetailsAlphabets();
		result(errorMessage(), addCDTestName4, addCDTestInfo4, author, addCDPassInfo4,
				addCDFailInfo4, addCD4FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Phone numbers
	String addCDTestName5 = "Add Telephone Details 5";
	String addCDTestInfo5 = "Updating Telephone numbers with correct Digits";
	String addCDPassInfo5 = "Test Passed: Telephone number updated with correct number of digits";
	String addCDFailInfo5 = "Test Failed: Telephone number unable to udpate";
	String addCD5FailScreenShotName = "telephone_update_failed.jpg";
	@Test (priority = 25)
	public void contactDetails5() throws Exception{
		pim();
		contactDetailsCorrectDigits();
		result(!errorMessage(), addCDTestName5, addCDTestInfo5, author, addCDPassInfo5,
				addCDFailInfo5, addCD5FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName1 = "Add Emails Details 1";
	String addCETestInfo1 = "Updating Email details with just usernames";
	String addCEPassInfo1 = "Test Passed: Unable to update Email details with just usernames";
	String addCEFailInfo1 = "Test Failed: User details updated with just usernames";
	String addCE1FailScreenShotName = "username_emails.jpg";
	@Test (priority = 26)
	public void contactEmails1() throws Exception{
		pim();
		addEmailsUsernames();
		result(errorMessage(), addCETestName1, addCETestInfo1, author, addCEPassInfo1,
				addCEFailInfo1, addCE1FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName2 = "Add Emails Details 2";
	String addCETestInfo2 = "Updating Email details containing just usernames madeup of Special Characters";
	String addCEPassInfo2 = "Test Passed: Unable to update Email details with just usernames madeup of Special Characters";
	String addCEFailInfo2 = "Test Failed: User details updated with just usernames madeup of special Characters";
	String addCE2FailScreenShotName = "username_SplChrs_emails.jpg";
	@Test (priority = 27)
	public void contactEmails2() throws Exception{
		pim();
		addEmailSplChrs();
		result(errorMessage(), addCETestName2, addCETestInfo2, author, addCEPassInfo2,
				addCEFailInfo2, addCE2FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName3 = "Add Emails Details 3";
	String addCETestInfo3 = "Updating Email details containing no Domains";
	String addCEPassInfo3 = "Test Passed: Unable to update Email details with no Domains";
	String addCEFailInfo3 = "Test Failed: User details updated with emails with no Domains";
	String addCE3FailScreenShotName = "No_Domain_emails.jpg";
	@Test (priority = 28)
	public void contactEmails3() throws Exception{
		pim();
		addEmailNoDomain();
		result(errorMessage(), addCETestName3, addCETestInfo3, author, addCEPassInfo3,
				addCEFailInfo3, addCE3FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName4 = "Add Emails Details 4";
	String addCETestInfo4 = "Updating Email details made up of Special Characters with No domain";
	String addCEPassInfo4 = "Test Passed: Unable to update Email details with Special Characters with No domain";
	String addCEFailInfo4 = "Test Failed: User details updated with emails with Special Characters with No domain";
	String addCE4FailScreenShotName = "Special_Characters_emails.jpg";
	@Test(priority = 29)
	public void contactEmails4() throws Exception{
		pim();
		addEmailSplChrs2();
		result(errorMessage(), addCETestName4, addCETestInfo4, author, addCEPassInfo4,
				addCEFailInfo4, addCE4FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName5 = "Add Emails Details 5";
	String addCETestInfo5 = "Updating Email details made up of Special Characters with Domain";
	String addCEPassInfo5 = "Test Passed: Unable to update Email details with Special Characters with domain";
	String addCEFailInfo5 = "Test Failed: User details updated with emails with Special Characters with domain";
	String addCE5FailScreenShotName = "Special_Characters_emails2.jpg";
	@Test (priority = 30)
	public void contactEmails5() throws Exception{
		pim();
		addEmailSplChrs3();
		result(errorMessage(), addCETestName5, addCETestInfo5, author, addCEPassInfo5,
				addCEFailInfo5, addCE5FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName6 = "Add Emails Details 6";
	String addCETestInfo6 = "Updating Email details with username made up of Special Characters";
	String addCEPassInfo6 = "Test Passed: Unable to update Email details username with Special Characters with domain";
	String addCEFailInfo6 = "Test Failed: User details updated with emails username with Special Characters with domain";
	String addCE6FailScreenShotName = "Special_Characters_emails2.jpg";
	@Test (priority = 31)
	public void contactEmails6() throws Exception{
		pim();
		addEmailSplChrs4();
		result(errorMessage(), addCETestName6, addCETestInfo6, author, addCEPassInfo6,
				addCEFailInfo6, addCE6FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Emails
	String addCETestName7 = "Add Emails Details 7";
	String addCETestInfo7 = "Updating Email details ";
	String addCEPassInfo7 = "Test Passed: Successfully updated user with email details";
	String addCEFailInfo7 = "Test Failed: Unable to update email details";
	String addCE7FailScreenShotName = "email_update_failed.jpg";
	@Test (priority = 32)
	public void contactEmails7() throws Exception{
		pim();
		addEmailsCorrect();
		result(errorMessage(), addCETestName7, addCETestInfo7, author, addCEPassInfo7,
				addCEFailInfo7, addCE7FailScreenShotName, screenShotPath);
		logOut();
	}
	
	//Add Contact Details
	String addCDTestName = "Add Contact Details";
	String addCDTestInfo = "Updating user contact details like Telephone numbers, Emails of user";
	String addCDPassInfo = "Test Passed: Successfully updated user with contact details";
	String addCDFailInfo = "Test Failed: Failed update contact details of the user";
	String addCDFailScreenShotName = "Contact_Details_update_failed.jpg";
	@Test (priority = 33)
	public void contactDetails() throws Exception{
		pim();
		addContactDetails();
		result(errorMessage(), addCDTestName, addCDTestInfo, author, addCDPassInfo,
				addCDFailInfo, addCDFailScreenShotName, screenShotPath);
		logOut();
	}
	
	@AfterTest
	public void reportQuit() throws Exception{
		quitReport(reportPath);
	}
}
