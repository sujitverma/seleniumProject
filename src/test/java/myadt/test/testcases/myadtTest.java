package myadt.test.testcases;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import igt.test.automation.base.TestBase;
import igt.test.automation.jira.JiraRestApi;
import igt.test.automation.report.ReportTestManager;
import igt.test.automation.selenium.constants.IGlobalConstants;
import igt.test.automation.util.DataUtil;
import igt.test.automation.util.SeleniumUtil;
import myadt.test.pageLibrary.HomeSecurity;


public class myadtTest extends TestBase {
	public static WebDriver driver;
	public static int testStatus = -1;
	public Map<String, String> testData;
	ExtentTest test;
	ExtentReports extent;
	ExtentReports report = getReport();
	public Object[][] data;
	private static final Logger LOG = LogManager.getLogger(myadtTest.class);
	 
	@BeforeClass
	public void reportConfig() {
		report.addSystemInfo("Browser", getBrowserType());
	}
	
	@BeforeTest
	public void setUp(){
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		data = DataUtil.getMapDataFromSpreadSheet(
				System.getProperty("user.dir") + IGlobalConstants.GLOBAL_DATA_FOLDER + "TestData.xlsx", "MyADT");
	}
	
	@AfterClass
	public void closeResources() {
		driver.quit();
	}
	
	@AfterMethod
	public void updateJiraStatus() {
		JiraRestApi.updateJiraTestStatus(System.getProperty("jira.geturl"), System.getProperty("jira.puturl"), testData.get("IssueId"), System.getProperty("jira.projectid"), 
				System.getProperty("jira.cycleid"), System.getProperty("jira.username"), System.getProperty("jira.password"), testStatus, System.getProperty("jira.updateStatus"));	
	
	}
	
	@BeforeMethod
	public void getTestDataMap(Method method) {
		Test test = method.getAnnotation(Test.class);
		for(int row=0; row<data.length; row++) {
			testData = (Map<String, String>) data[row][0];
			if(testData.containsValue(test.testName()) == true) {
				return;
			}
		}
	}
	
	
	@DataProvider(name = "MyAdt")
	public Object[] dataProviderCreateTopology() {
		Object[][] data = DataUtil.getMapDataFromSpreadSheet(
				System.getProperty("user.dir") + IGlobalConstants.GLOBAL_DATA_FOLDER + "TestData.xlsx", "MyADT");	
		return data;
	}
	
	
	@Test(priority = 1, testName = "10631", enabled = true)
	public void myAdtTest001() {
		test = ReportTestManager.startTest(testData.get("TestCaseName"), testData.get("TestCaseDescription"));
		if (testData.get("ExecutionFlag").equalsIgnoreCase("N")) {
			LOG.warn("Skipping Test- "+ testData.get("TestCaseName"));
			reportLog(LOG, test, LogStatus.SKIP, "Skipping Test as Execution Flag is N");
			return; 
		}
		try {
			driver.get(System.getProperty("envApplicationUrl"));	
			new HomeSecurity(driver, test).shopProduct();
			testStatus = 1;
			} catch (Exception e) {
				testStatus = 2;
			    Assert.fail("Test Failed: ");
		}finally {
			SeleniumUtil.closeCurrentTabSwitchToParent(driver);
			ReportTestManager.endTest();
		}
	}
	
	
	@Test(priority = 2, testName = "10650", enabled = true)
	public void myAdtTest002() {
		test = ReportTestManager.startTest(testData.get("TestCaseName"), testData.get("TestCaseDescription"));
		if (testData.get("ExecutionFlag").equalsIgnoreCase("N")) {
			LOG.warn("Skipping Test- "+ testData.get("TestCaseName"));
			reportLog(LOG, test, LogStatus.SKIP, "Skipping Test as Execution Flag is N");
			return; 
		}
		try {
			driver.get(System.getProperty("envApplicationUrl"));	
			new HomeSecurity(driver, test).getFreeQuotes(testData.get("Name"), testData.get("Email"), testData.get("PhoneNumber"), testData.get("ZipCode"));
			testStatus = 1;
		} catch (Exception e) {
			testStatus = 2;
			Assert.fail("Test Failed:");
		}finally {
			SeleniumUtil.closeCurrentTabSwitchToParent(driver);
			ReportTestManager.endTest();
		}
	}
	
	
	@Test(priority = 3, testName = "10651", enabled = true)
	public void myAdtTest003() {
		test = ReportTestManager.startTest(testData.get("TestCaseName"), testData.get("TestCaseDescription"));
		if (testData.get("ExecutionFlag").equalsIgnoreCase("N")) {
			LOG.warn("Skipping Test- "+ testData.get("TestCaseName"));
			reportLog(LOG, test, LogStatus.SKIP, "Skipping Test as Execution Flag is N");
			return; 
		}
		try {
			driver.get(System.getProperty("envApplicationUrl"));	
			new HomeSecurity(driver, test).shopMonitoringPlan();
			testStatus = 1;
			} catch (Exception e) {
				testStatus = 2;
				Assert.fail("Test Failed: ");
		}finally {
			SeleniumUtil.closeCurrentTabSwitchToParent(driver);
			ReportTestManager.endTest();
		}
	}
	
	@Test(priority = 4, testName = "10652", enabled = true)
	public void myAdtTest004() {
		test = ReportTestManager.startTest(testData.get("TestCaseName"), testData.get("TestCaseDescription"));
		if (testData.get("ExecutionFlag").equalsIgnoreCase("N")) {
			LOG.warn("Skipping Test- "+ testData.get("TestCaseName"));
			reportLog(LOG, test, LogStatus.SKIP, "Skipping Test as Execution Flag is N");
			return; 
		}
		try {
			driver.get(System.getProperty("envApplicationUrl"));	
			new HomeSecurity(driver, test).shopProduct();
			new HomeSecurity(driver, test).checkoutProduct(testData.get("Name"), testData.get("Name"), testData.get("Email"), testData.get("PhoneNumber"),
					testData.get("Address"), testData.get("City"), testData.get("State"), testData.get("ZipCode"));
			testStatus = 1;
			} catch (Exception e) {
				testStatus = 2;
				Assert.fail("Test Failed: ");
		}finally {
			SeleniumUtil.closeCurrentTabSwitchToParent(driver);
			ReportTestManager.endTest();
		}
	}
	
	
	@Test(priority = 5, testName = "10653", enabled = true)
	public void myAdtTest005() {
		test = ReportTestManager.startTest(testData.get("TestCaseName"), testData.get("TestCaseDescription"));
		if (testData.get("ExecutionFlag").equalsIgnoreCase("N")) {
			LOG.warn("Skipping Test- "+ testData.get("TestCaseName"));
			reportLog(LOG, test, LogStatus.SKIP, "Skipping Test as Execution Flag is N");
			return; 
		}
		try {
			driver.get(System.getProperty("envApplicationUrl"));	
			new HomeSecurity(driver, test).getRiskAssesment(testData.get("Name"), testData.get("Email"), testData.get("PhoneNumber"), testData.get("ZipCode"));
			testStatus = 1;
			} catch (Exception e) {
				testStatus = 2;
				Assert.fail("Test Failed: ");
		}finally {
			SeleniumUtil.closeCurrentTabSwitchToParent(driver);
			ReportTestManager.endTest();
		}
	}
}
