package Utilities;

import java.awt.Desktop;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class Reports extends Utils{
	
	private ExtentReports extReport;
	
	public String getScreenShot(String screenShotName, String screenShotPath) {
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenShotPath + screenShotName);
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (Exception e) {
			System.out.println("Error while saving screenshot " + e.getMessage());
		}
		
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
	public void reports(String reportPath, String reportName, String docTitle) {
		extReport = new ExtentReports();
		File file = new File(reportPath);
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkReport.config();
		
		config.setReportName(reportName);
		config.setDocumentTitle(docTitle);
		
		extReport.attachReporter(sparkReport);
	}
	
	public void pass(String testName, String testInfo, String author, String passInfo) {
		extReport.createTest(testName, testInfo)
		.assignAuthor(author)
		.pass(passInfo);
	}
	
	public void fail(String testName, String testInfo, String author, 
			String failInfo, String screenShotName, String screenShotPath) {
		Throwable t = new Throwable(failInfo);
		
		extReport.createTest(testName, testInfo)
		.assignAuthor(author)
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath, screenShotName).build());
	}
	
	public void result(boolean status, String testName, String testInfo, String author, 
			String passInfo, String failInfo, String screenShotName, String screenShotPath) {
		
		if (status) {
			pass(testName, testInfo, author, passInfo);
		} 
		else {
			
			fail(testName, testInfo, author, failInfo, screenShotName, screenShotPath);
			
		}
	}
	
	public void quitReport(String reportPath) throws Exception{
		extReport.flush();
		Desktop.getDesktop().browse(new File(reportPath).toURI());
	}
	
	
}
