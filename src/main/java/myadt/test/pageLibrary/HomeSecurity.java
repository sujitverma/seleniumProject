package myadt.test.pageLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import igt.test.automation.base.TestBase;
import igt.test.automation.util.SeleniumUtil;
import igt.test.automation.util.SynchronisationUtil;

public class HomeSecurity extends TestBase {
	WebDriver driver;
	ExtentTest test;
	private static final Logger LOG = LogManager.getLogger(HomeSecurity.class);
	
	public HomeSecurity(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Home Security')]")
	WebElement lnkHomeSecurity;
	
	@FindBy(xpath="//span[contains(text(),'Business Security')]")
	WebElement lnkBusinessSecurity;
	
	@FindBy(xpath=".//a[@title='SHOP NOW']")
	WebElement btnShopNow;

	@FindBy(xpath="//span[@class='link hoverable'][contains(text(),'Packages')]")
	WebElement Packages;
	
	@FindBy(xpath="//body/section[@id='cameras']//div[@class='row']//*[contains(text(),'Indoor Camera')]")
	WebElement CameraName;
	
	@FindBy(xpath="//body/section[@id='cameras']//div[@class='row']//*[contains(text(),'Indoor Camera')]//parent::div//p[@class='price']")
	WebElement CameraPrice;
	
	@FindBy(xpath="//body/section[@id='cameras']//div[@class='row']//*[contains(text(),'Indoor Camera')]/parent::div//following::*[contains(text(),'Shop Now')][1]")
	WebElement BuyNow;
	
	@FindBy(xpath="//body/section[@id='product-details']//p[@class='price']//preceding::h5") 
	WebElement CameraNameForVerification;
	
	@FindBy(xpath="//body/section[@id='product-details']//p[@class='price']") 
	WebElement CameraPriceForVerification;
	
	@FindBy(xpath="//button[contains(text(),'Add to Cart')][1]") 
	WebElement BtnAddToCart;
	
	@FindBy(xpath="//a[contains(text(),'Get a Free Quote')]") 
	WebElement btnGetFreeQuote;
	
	@FindBy(xpath="//body/div[@id='adt-body-id']/div[@id='section-full-body-id']/div[@id='section-header-body-id']/div[@id='adt-header-id']//div[@class='sub-nav-link-container']//span[contains(text(),'Risk Assessment')]") 
	WebElement lnkFreeRiskAssessment;
	
	
	@FindBy(xpath="//input[@id='Header_Customer_Full_Name_']") 
	WebElement edtName;
	
	@FindBy(xpath="//input[@id='Header_E_Mail_Address_']") 
	WebElement edtEmail;
	
	@FindBy(xpath="//input[@id='Header_Phone_Number_Primary_']") 
	WebElement edtPhoneNumber;
	
	@FindBy(xpath="//input[@id='Header_Postal_Code_']") 
	WebElement edtZipCode;
	
	@FindBy(xpath="//button[@id='submit_header_form_']") 
	WebElement btnSubmitQuote;
	
	@FindBy(xpath="//body/div[@id='adt-body-id']/div[@id='section-full-body-id']/div[@id='section-header-body-id']/div[@id='adt-header-id']//*[contains(text(),'Thank You')]") 
	WebElement txtThankYou;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div/div/div/div/span/ul/li[4]/a") 
	WebElement MonitoringPlans;
	
	@FindBy(xpath="//*[@id='monitoring-promo']//a[text()='Shop Now']") 
	WebElement MonitoringPlansShopNow;
	
	@FindBy(xpath="//body/section[@id='security-systems']//div[@class='row']//*[contains(text(),'Build Your Own System')]/parent::div//following::*[contains(text(),'Buy Now') or contains(text(),'Build it Now')][1]") 
	WebElement BuildMonitoringPlan;
	
	@FindBy(xpath="//header/nav[@id='sub-nav']//button[contains(text(), 'Proceed to Checkout')]") 
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath="//tbody//button[@id='begin_checkout' and contains(text(),'Checkout')]") 
	WebElement btnCheckout;
	
	@FindBy(xpath="//input[@id='inputFirstName']") 
	WebElement edtFirstName;
	
	@FindBy(xpath="//input[@id='inputLastName']") 
	WebElement edtLastName;
	
	@FindBy(xpath="//input[@id='inputEmail']") 
	WebElement edtinputEmail;
	
	@FindBy(xpath="//input[@id='inputPhone']") 
	WebElement edtinputPhone;
	
	@FindBy(xpath="//input[@id='inputShpAddressLine1']") 
	WebElement edtAddress;
	
	@FindBy(xpath="//input[@id='inputShpAddressCity']") 
	WebElement edtCity;
	
	@FindBy(xpath="//select[@id='inputShpAddressState']") 
	WebElement lstState;
	
	@FindBy(xpath="//input[@id='inputShpAddressZip']") 
	WebElement edtZip;
	
	@FindBy(xpath="//body/section[@id='cart']//button[@id='submitBtn'][1]") 
	WebElement btnContinue;
	
	@FindBy(xpath="//header/nav[@id='sub-nav']//img[@alt='Cart icon']") 
	WebElement imgCart;
	
	@FindBy(xpath="//div[@id='validationErrorDisplayId']") 
	WebElement errInvalidAddress;
	
	@FindBy(xpath="//input[@id='Banner_Customer_Full_Name_6662']") 
	WebElement edtRiskName;
	
	@FindBy(xpath="//input[@id='Banner_Business_Name_6662']") 
	WebElement edtRiskBusiness;
	
	@FindBy(xpath="//input[@id='Banner_E_Mail_Address_6662']") 
	WebElement edtRiskEmail;
	
	@FindBy(xpath="//input[@id='Banner_Phone_Number_Primary_6662']") 
	WebElement edtRiskPhone;
	
	@FindBy(xpath="//input[@id='Banner_Postal_Code_6662']") 
	WebElement edtRiskZip;
	
	@FindBy(xpath="//button[@id='submit_banner_form_6662']") 
	WebElement btnRiskCallme;
	
	@FindBy(xpath="//h3[contains(text(),'Thank You')]") 
	WebElement txtRiskThankYou;
	
	
	
	/**
	 * Login into myadt Application
	 * @author Sujit
	 */
	public void shopProduct() {
		try {
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, lnkHomeSecurity);
			reportLog(LOG, test, LogStatus.INFO, "Application launch Sucess- URL: "+ System.getProperty("envApplicationUrl"));
			SeleniumUtil.clickElementAssert(lnkHomeSecurity, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Home Security Link");
			SeleniumUtil.switchToRecentlyOpenedWindow(driver);
			String url = SeleniumUtil.getCurrentURL(driver);
			reportLog(LOG, test, LogStatus.INFO, "Switched to window with URL - "+ url);
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1100)");
		    SeleniumUtil.scrollIntoView(btnShopNow, driver);
		    js.executeScript("arguments[0].click();", btnShopNow);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Shop Now Button");
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, CameraName);
			String cameraName = SeleniumUtil.getText(CameraName);
			String cameraPrice = SeleniumUtil.getText(CameraPrice);
			SeleniumUtil.scrollIntoView(BuyNow, driver);
		    js.executeScript("arguments[0].click();", BuyNow);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Buy Now Button");
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, CameraNameForVerification);
			String cameraName2 = SeleniumUtil.getText(CameraNameForVerification);
			String cameraPrice2 = SeleniumUtil.getText(CameraPriceForVerification);
			Boolean camName = SeleniumUtil.checkStringContains(cameraName2, cameraName);
			Boolean camPrice = SeleniumUtil.checkStringContains(cameraPrice2, cameraPrice);
			
			if(camName) {
				reportLog(LOG, test, LogStatus.PASS, "Product Name Verified :" + cameraName);
			}else {
				reportLog(LOG, test, LogStatus.FAIL, "Failed to verify Product Name :" + cameraPrice);
			}
			if(camPrice) {
				reportLog(LOG, test, LogStatus.PASS, "Product Price Verified :" +  cameraName);
			}else {
				reportLog(LOG, test, LogStatus.FAIL, "Failed to verify Product Price:" + cameraPrice);
			}
			SeleniumUtil.scrollIntoView(BtnAddToCart, driver);
		    js.executeScript("arguments[0].click();", BtnAddToCart);
			reportLog(LOG, test, LogStatus.PASS, "Product Added to Cart");
			
		}catch(Exception e) {
			reportLog(LOG, test, LogStatus.FAIL, "Exception in: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
	
	
	public void getFreeQuotes(String name, String email, String phoneNumber, String zipCode) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, lnkHomeSecurity);
			reportLog(LOG, test, LogStatus.INFO, "Application launch Sucess- URL: "+ System.getProperty("envApplicationUrl"));
			SeleniumUtil.clickElementAssert(lnkHomeSecurity, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Home Security Link");
			SeleniumUtil.switchToRecentlyOpenedWindow(driver);
			String url = SeleniumUtil.getCurrentURL(driver);
			reportLog(LOG, test, LogStatus.INFO, "Switched to window with URL - "+ url);
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			
			SeleniumUtil.clickElementAssert(btnGetFreeQuote, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on 'Get a Free Quote' button");
			SeleniumUtil.typeValuesInATextBox(edtName, name, driver);
			SeleniumUtil.typeValuesInATextBox(edtEmail, email, driver);
			SeleniumUtil.typeValuesInATextBox(edtPhoneNumber, phoneNumber, driver);
			SeleniumUtil.typeValuesInATextBox(edtZipCode, zipCode, driver);
			reportLog(LOG, test, LogStatus.INFO, "Entered values in text boxes: "
					+ "Name: "+name 
					+ " Email: "+email
					+ " Phone Number: "+phoneNumber
					+ " Zip Code: "+zipCode);
			SeleniumUtil.scrollIntoView(btnSubmitQuote, driver);
			SeleniumUtil.clickElementAssert(btnSubmitQuote, driver);
			if(SeleniumUtil.isElementEnabled(txtThankYou, driver)) {
				reportLog(LOG, test, LogStatus.PASS, "Free Quote request submitted");
			}else {
				reportLog(LOG, test, LogStatus.FAIL, "Failed to submit Free Quote request");
			}
		}catch(Exception e) {
			reportLog(LOG, test, LogStatus.FAIL, "Failed to submit Free Quote request");
			reportLog(LOG, test, LogStatus.FAIL, "Exception in: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
		
	
	public void shopMonitoringPlan()
	{
		try {
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, lnkHomeSecurity);
			reportLog(LOG, test, LogStatus.INFO, "Application launch Sucess- URL: "+ System.getProperty("envApplicationUrl"));
			SeleniumUtil.clickElementAssert(lnkHomeSecurity, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Home Security Link");
			SeleniumUtil.switchToRecentlyOpenedWindow(driver);
			String url = SeleniumUtil.getCurrentURL(driver);
			reportLog(LOG, test, LogStatus.INFO, "Switched to window with URL - "+ url);
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1100)");
		    SeleniumUtil.scrollIntoView(btnShopNow, driver);
		    js.executeScript("arguments[0].click();", btnShopNow);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Shop Now Button");
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, CameraName);
			SeleniumUtil.scrollIntoView(BuyNow, driver);
			reportLog(LOG, test, LogStatus.FAIL, "Faild to click on Buy Now Button");	
	}
		catch(Exception e) {
			takeFullScreenShot(test);
			reportLog(LOG, test, LogStatus.FAIL, "Exception in: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}
	
	
	/**
	 * 
	 * @author Sujit
	 */
	public void checkoutProduct(String FName, String LName, String email, String phoneNumber, 
			String address, String city, String state, String zipCode ) {
		try {
			SeleniumUtil.hoverMainMenuAndClickOnTheSubMenu(driver, imgCart, btnProceedToCheckout);
			SeleniumUtil.clickElementAssert(btnCheckout, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Checkout Button");
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, edtFirstName);
			SeleniumUtil.typeValuesInATextBox(edtFirstName, FName, driver);
			SeleniumUtil.typeValuesInATextBox(edtLastName, LName, driver);
			SeleniumUtil.typeValuesInATextBox(edtinputEmail, email, driver);
			SeleniumUtil.typeValuesInATextBox(edtinputPhone, phoneNumber, driver);
			SeleniumUtil.typeValuesInATextBox(edtAddress, address, driver);
			SeleniumUtil.typeValuesInATextBox(edtCity, city, driver);
			SeleniumUtil.selectDropDownByValueAppearing(lstState, state);
			SeleniumUtil.typeValuesInATextBox(edtZip, zipCode, driver);
			reportLog(LOG, test, LogStatus.INFO, "Entered values in text boxes: "
					+ "First Name: "+FName 
					+ "Last Name: "+LName 
					+ " Email: "+email
					+ " Phone Number: "+phoneNumber
					+ " Zip Code: "+zipCode);
			SeleniumUtil.clickElementAssert(btnContinue, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Continue Button");
			if(SeleniumUtil.isElementEnabled(errInvalidAddress, driver)) {
				String errorText = SeleniumUtil.getText(errInvalidAddress);
				 reportLog(LOG, test, LogStatus.PASS, "Error Validated successfully: "+ errorText);	
			}else {
				 reportLog(LOG, test, LogStatus.FAIL, "Failed to validated the invalid Shipping address error message");	
			}	
		}catch(Exception e) {
			reportLog(LOG, test, LogStatus.FAIL, "Exception in: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
	
	
	public void getRiskAssesment(String name, String email, String phoneNumber, String zipCode) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			SynchronisationUtil.waitUntilTheElementIsOnThePage(driver, 10, lnkBusinessSecurity);
			reportLog(LOG, test, LogStatus.INFO, "Application launch Sucess- URL: "+ System.getProperty("envApplicationUrl"));
			SeleniumUtil.clickElementAssert(lnkBusinessSecurity, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Business Security Link");
			SeleniumUtil.switchToRecentlyOpenedWindow(driver);
			String url = SeleniumUtil.getCurrentURL(driver);
			reportLog(LOG, test, LogStatus.INFO, "Switched to window with URL - "+ url);
			SynchronisationUtil.waitUntilThePageLoadsCompletely(driver, 120);
			
			SeleniumUtil.clickElementAssert(lnkFreeRiskAssessment, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on 'Risk Assessment");
			SeleniumUtil.typeValuesInATextBox(edtRiskName, name, driver);
			SeleniumUtil.typeValuesInATextBox(edtRiskBusiness, name, driver);
			SeleniumUtil.typeValuesInATextBox(edtRiskEmail, email, driver);
			SeleniumUtil.typeValuesInATextBox(edtRiskPhone, phoneNumber, driver);
			SeleniumUtil.typeValuesInATextBox(edtRiskZip, zipCode, driver);
			reportLog(LOG, test, LogStatus.INFO, "Entered values in text boxes: "
					+ "Name: "+name 
					+ " Email: "+email
					+ " Phone Number: "+phoneNumber
					+ " Zip Code: "+zipCode);
			SeleniumUtil.clickElementAssert(btnRiskCallme, driver);
			reportLog(LOG, test, LogStatus.INFO, "Clicked on Call Me Back button");
			if(SeleniumUtil.isElementEnabled(txtRiskThankYou, driver)) {
				reportLog(LOG, test, LogStatus.PASS, "Risk Assessment Request Submitted");
			}else {
				reportLog(LOG, test, LogStatus.FAIL, "Failed to submit Risk Assessment Request");
			}
		}catch(Exception e) {
			reportLog(LOG, test, LogStatus.FAIL, "Failed to submit Risk Assessment Request");
			reportLog(LOG, test, LogStatus.FAIL, "Exception in: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
		
	
	
}
