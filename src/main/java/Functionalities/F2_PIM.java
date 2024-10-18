package Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.*;

public class F2_PIM extends F1_Login {
	//test 1
	public void navigate_PIM() {
		getWebEle(pimPath).click();;
		syncWait(3);
	}
	
	public boolean employeeInfo() {
		boolean displayed = getWebEle(empInfo).isDisplayed();
		
		if (displayed) {
			return true;
		}
		
		return false;
	}
	
	public boolean employeeRecords() {
		boolean records = getWebEle(totalEmployeeRecordsPath).isDisplayed();
		
		if (records) {
			System.out.println(getWebEle(totalEmployeeRecordsPath).getText());
			return true;
		}
		
		return false;
	}
	
	//test 2
	public void empNameSearch() {
		
		inputSearch(employeeNamePath, searchButtonPath, totalEmployeeRecordsPath);
	}
	//test 3
	public void empIdSearch() {
		//getWebEle(employeeIdPath).click();
		getWebEle(employeeIdPath).sendKeys("0450");
		getWebEle(searchButtonPath).click();
		//inputSearch(employeeIdPath, searchButtonPath, totalEmployeeRecordsPath);
	}
	//test 4
	public void employeeStatusSearch() {
	
		dropdownSearchPath(employeeStatusPath, employeeStatusList, searchButtonPath, totalEmployeeRecordsPath, "1");
	}
	
	//test 5
	public void employeeIncludeSearch() {

		dropdownSearchPath(includePath, includeList, searchButtonPath, totalEmployeeRecordsPath, "1");
	}
	
	//test6
	public void employeeSupervisorSearch() {

		inputSearch(supervisornamePath, searchButtonPath, totalEmployeeRecordsPath);
	}
	
	//test 7
	public void employeeJobTitleSearch() {
		
		dropdownSearchPath(jobTitlePath, jobTitlesList, searchButtonPath, totalEmployeeRecordsPath, "1");
	}
	
	//test 8
	public void employeeSubUnitSearch() {
		
		dropdownSearchPath(subUnitPath, subUnitList, searchButtonPath, totalEmployeeRecordsPath, "1");
	}
	
	//test 9
	public void mutipleInputSearch() throws Exception{
//		System.out.println("Input Employee first/middle/last name");
//		String name = getInputString();
//		System.out.println("Input Employee Id");
//		String employeeId = getInputString();
		getWebEle(employeeNamePath).click();
		getWebEle(employeeNamePath).sendKeys("ravi");
		syncWait(5);
		//getWebEle(employeeIdPath).click();
		getWebEle(employeeIdPath).sendKeys("0303");
		syncWait(5);
		getWebEle(searchButtonPath).click();
		Thread.sleep(5000);
		syncWait(10);
		tableRecords(employeeTableXpath, employeeTableRowsXpath, employeeTableCellsXpath);
	}
	
	public boolean errorMessage() {
		Integer errorSize = getWebEleListSize(errorMessagePath);
		
		if (errorSize > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void errorSize() {
		Integer errorSize = getWebEleListSize(errorMessagePath);
		
		if (errorSize > 0) {
			System.out.println("Unable to add Employee to records");
		} else {
			System.out.println("Successfully added Employee to records");
		}
	}
	
	//test 10
	public void emptyEmployeedetails() {
		getWebEle(addEmployeeButtonPath).click();
		syncWait(5);
		getWebEle(saveButtonPath).click();
		syncWait(3);
		errorSize();
	}
	
	
	public boolean employeeRecord() {
		String record = getWebEle(totalEmployeeRecordsPath).getText();
		
		if (record.equalsIgnoreCase("(1) Record Found")) {
			return true;
		}
		
		return false;
	}
	
	//test 11
	public void noCredentialEmployeedetails() throws Exception{

		getWebEle(addEmployeeButtonPath).click();
		syncWait(5);
		getWebEle(addEmployeeFirstNamePath).sendKeys("Jaya");
		getWebEle(addEmployeeLastNamePath).sendKeys("Krishna");
		getWebEle(employeeIdPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle("//*[text() = 'Employee Id']").click();
		getWebEle(addEmployeeIdPath).sendKeys("1063");
		getWebEle(saveButtonPath).click();
		Thread.sleep(5000);
		getWebEle(employeeListPath).click();
		syncWait(5);
		getWebEle(employeeIdPath).sendKeys("1063");
		getWebEle(searchButtonPath).click();
		Thread.sleep(3000);
		syncWait(5);
		tableRecords(employeeTableXpath, employeeTableRowsXpath, employeeTableCellsXpath);
	}
	
	public void addEmployeeNoCredentialsInputs() {
		getWebEle(addEmployeeButtonPath).click();
		syncWait(5);
		getWebEle(addEmployeeFirstNamePath).click();
		getWebEle(addEmployeeFirstNamePath).sendKeys("Krishna");
		getWebEle(addEmployeeLastNamePath).click();
		getWebEle(addEmployeeLastNamePath).sendKeys("Sekhar");
		getWebEle(employeeIdPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(employeeIdTextPath).click();
		getWebEle(addEmployeeIdPath).sendKeys("1064");
		getWebEle(credentialsTogglePath).click();
		
	}
	
	public void addEmployeeSaveInputs() {
		getWebEle(saveButtonPath).click();
		syncWait(5);
		errorSize();
	}
	
	//test 12
	public void addEmployeeNoCredentials() {
		addEmployeeNoCredentialsInputs();
		addEmployeeSaveInputs();
	}
	
	//test 13
	public void addEmployeeNoCredentials2() {
		addEmployeeNoCredentialsInputs();
		getWebEle(disabledRadioButtonPath).click();
		addEmployeeSaveInputs();
	}
	
	//test 14
	public void addEmployeeNoCredentials3() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		Thread.sleep(2000);
		syncWait(5);
		addEmployeeSaveInputs();
	}
	
	//test 15
	public void addEmployeeNoCredentials4() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		syncWait(5);
		getWebEle(addEmployeePasswordPath).click();
		getWebEle(addEmployeePasswordPath).sendKeys("1064jk");
		Thread.sleep(2000);
		syncWait(5);
		addEmployeeSaveInputs();
	}
	
	//test 16
	public void addEmployeeNoCredentials5() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		syncWait(5);
		getWebEle(addEmployeePasswordPath).click();
		getWebEle(addEmployeePasswordPath).sendKeys("1064jk&");
		Thread.sleep(2000);
		syncWait(5);
		addEmployeeSaveInputs();
	}
	
	//test 17
	public void addEmployeeNoCredentials6() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		syncWait(5);
		getWebEle(addEmployeePasswordPath).click();
		getWebEle(addEmployeePasswordPath).sendKeys("aRZANj3H-u\"Q\\D3qQaI*?%Vaw}zALi<?^&ybp`80L6,X~)&mgYLzXLJ#Q0?F`zGu6");
		Thread.sleep(2000);
		syncWait(5);
		addEmployeeSaveInputs();
	}
	
	//test 18
	public void addEmployeeWithIncorrectCredentials() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		syncWait(5);
		getWebEle(addEmployeePasswordPath).click();
		getWebEle(addEmployeePasswordPath).sendKeys("1064Jk&");
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(employeeIdTextPath).click();
		getWebEle(addEmployeecConfirmPasswordPath).sendKeys("1063Jk&");
		Thread.sleep(2000);
		syncWait(2000);
		addEmployeeSaveInputs();
	}
	
	//test 19
	public void addEmployeeWithCorrectCredentials() throws Exception{
		addEmployeeNoCredentialsInputs();
		getWebEle(addEmployeeUsernamePath).sendKeys("jk1064");
		syncWait(5);
		getWebEle(addEmployeePasswordPath).click();
		getWebEle(addEmployeePasswordPath).sendKeys("1064Jk&");
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(employeeIdTextPath).click();
		getWebEle(addEmployeecConfirmPasswordPath).sendKeys("1064Jk&");
		Thread.sleep(2000);
		syncWait(2000);
		getWebEle(saveButtonPath).click();
		Thread.sleep(5000);
		getWebEle(employeeListPath).click();
		syncWait(5);
		getWebEle(employeeIdPath).sendKeys("1064");
		getWebEle(searchButtonPath).click();
		Thread.sleep(3000);
		syncWait(5);
		tableRecords(employeeTableXpath, employeeTableRowsXpath, employeeTableCellsXpath);
	}
	
	//test 20
	public void addPersonalDetails() throws Exception{
		getWebEle(employeeIdPath).sendKeys("1064");
		getWebEle(searchButtonPath).click();
		getWebEle(createdNamePath).click();
		Thread.sleep(3000);
		syncWait(5);
//		getWebEle(otherIdPath).click();
//		Thread.sleep(3000);
//		syncWait(5);
		getWebEle(otherIdPath).sendKeys("1225566");
		Thread.sleep(3000);
		syncWait(5);
		getWebEle(drivingLicensePath).click();
		getWebEle(drivingLicensePath).sendKeys("1296558");
		Thread.sleep(2000);
		syncWait(2000);
		getWebEle(nationalityDropdownPath).click();
		syncWait(5);
		getWebEle(nationalityPath).click();
		syncWait(5);
		getWebEle(maritalStatusDropdownPath).click();
		syncWait(5);
		getWebEle(maritalStatusPath).click();
		syncWait(5);
		getWebEle(dateOfBirthPath).sendKeys("1990-16-10");
		syncWait(5);
		getWebEle(genderMalePath).click();
		syncWait(5);
		getWebEle(bloodDropdownPath).click();
		syncWait(5);
		getWebEle(bloodSelectPath).click();
		syncWait(5);
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(serviceInputPath).sendKeys("Service");
		Thread.sleep(5000);
		syncWait(5);
//		getWebEle(attachmentsText).click();
//		Thread.sleep(2000);
//		syncWait(5);
//		getWebEle(addAttachmentPath).click();
//		Thread.sleep(2000);
//		syncWait(5);
//		getWebEle(uploadFilePath).sendKeys(driverLicenceFile.getAbsolutePath());
//		Thread.sleep(2000);
//		syncWait(5);
//		getWebEle(commentSectionPath).sendKeys("This is my diving license");
//		syncWait(5);
		getWebEle(personalDetailsSaveButtonPath).click();
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(employeeListPath).click();
		syncWait(5);
		getWebEle(employeeIdPath).sendKeys("1064");
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(searchButtonPath).click();
		Thread.sleep(3000);
		syncWait(5);
		tableRecords(employeeTableXpath, employeeTableRowsXpath, employeeTableCellsXpath);
		
	}
	
	public void userDetails(String homePhone, String mobilePhone, String workPhone) throws Exception{
		getWebEle(employeeIdPath).sendKeys("1064");
		getWebEle(searchButtonPath).click();
		getWebEle(createdNamePath).click();
		Thread.sleep(3000);
		syncWait(5);
		getWebEle(contactDetailsPath).click();
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(homePhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(homeTextPath).click();
		getWebEle(homePhonePath).sendKeys(homePhone);
		//Thread.sleep(5000);
		syncWait(10);
		getWebEle(mobilePhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(mobileTextPath).click();
		getWebEle(mobilePhonePath).sendKeys(mobilePhone);
		//Thread.sleep(2000);
		syncWait(10);
		getWebEle(workPhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(workTextPath).click();
		getWebEle(workPhonePath).sendKeys(workPhone);
		syncWait(10);
		getWebEle(contactDetailsSaveButtonPath).click();
	}
	
	//test 21
	public void contactDetailsSplChr() throws Exception{
		userDetails("%^^&**((((*&^^", "%^^&**((((*&^^", "@#$%^&*((*&^%^*");
	}
	
	//test 22
	public void contactDetailsSingleDigit() throws Exception{
		userDetails("1","1","1");
	}
	
	//test 23
	public void contactDetailsOverDigits() throws Exception{
		userDetails("012345678901234567890123456789", "012345678901234567890123456789", "012345678901234567890123456789");
	}
	
	//test 24
	public void contactDetailsAlphabets() throws Exception{
		userDetails("abcd", "efgh", "ijkl");
	}
	
	//test 25
	public void contactDetailsCorrectDigits() throws Exception{
		userDetails("0123456789", "0123456789", "0123456789");
	}
	
	public void userEmails(String workEmail, String otherEmail) throws Exception{
		getWebEle(employeeIdPath).sendKeys("1064");
		getWebEle(searchButtonPath).click();
		getWebEle(createdNamePath).click();
		Thread.sleep(3000);
		syncWait(5);
		getWebEle(contactDetailsPath).click();
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(workEmailInputPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(workEmailTextPath).click();
		getWebEle(workEmailInputPath).sendKeys(workEmail);
		//Thread.sleep(5000);
		syncWait(10);
		getWebEle(otherEmailInputPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(otherEmailTextPath).click();
		getWebEle(otherEmailInputPath).sendKeys(otherEmail);
		//Thread.sleep(2000);
		syncWait(10);
		getWebEle(contactDetailsSaveButtonPath).click();
	}

	//test 26
	public void addEmailsUsernames() throws Exception{
		userEmails("work", "other");
	}
	
	//test 27
	public void addEmailSplChrs() throws Exception{
		userEmails("^&*", "(&((*&^");
	}
	
	//test 28
	public void addEmailNoDomain() throws Exception{
		userEmails("work@email", "other@email");
	}
	
	//test 29
	public void addEmailSplChrs2() throws Exception{
		userEmails("$%^&@&((", "^&*(@&*()_");
	}
	
	//test 30
	public void addEmailSplChrs3() throws Exception{
		userEmails("%^@*().com", "$%^@^&*.com");
	}
	
	//test 31
	public void addEmailSplChrs4() throws Exception{
		userEmails("$%^&@email.com", "%^&*@email.com");
	}
	
	//test 32
	public void addEmailsCorrect() throws Exception{
		userEmails("work@email.com", "other@email.com");
	}
	
	//test 33
	public void addContactDetails() throws Exception{
		getWebEle(employeeIdPath).sendKeys("1064");
		getWebEle(searchButtonPath).click();
		getWebEle(createdNamePath).click();
		Thread.sleep(3000);
		syncWait(5);
		getWebEle(contactDetailsPath).click();
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(homePhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(homeTextPath).click();
		getWebEle(homePhonePath).sendKeys("0123456789");
		//Thread.sleep(5000);
		syncWait(10);
		getWebEle(mobilePhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(mobileTextPath).click();
		getWebEle(mobilePhonePath).sendKeys("0123456789");
		//Thread.sleep(2000);
		syncWait(10);
		getWebEle(workPhonePath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(workTextPath).click();
		getWebEle(workPhonePath).sendKeys("0123456789");
		Thread.sleep(2000);
		syncWait(5);
		getWebEle(workEmailInputPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(workEmailTextPath).click();
		getWebEle(workEmailInputPath).sendKeys("work@email.com");
		//Thread.sleep(5000);
		syncWait(10);
		getWebEle(otherEmailInputPath).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getWebEle(otherEmailTextPath).click();
		getWebEle(otherEmailInputPath).sendKeys("other@email.com");
		//Thread.sleep(2000);
		syncWait(10);
		getWebEle(contactDetailsSaveButtonPath).click();
	}
}
