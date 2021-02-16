package myadt.test.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import igt.test.automation.util.SeleniumUtil;

public class TestUtils {
	
	private static final long TWO_THOUSAND_MILLISECOND = 2000;
	private static final Logger LOG = LogManager.getLogger(TestUtils.class);

	/**
     * Method to perform double click. 
     * @param driver        {@link WebDriver}
     * @param targetElement - the target webElement
     */
    public static void doubleClickOnElement(final WebDriver driver,
                                           final WebElement targetElement) {
        Actions action = new Actions(driver);
        action.doubleClick(targetElement).perform();
    }
    
    
    
    /**compare two map key values mapping
     * @param first
     * @param second
     * @return
     */
    public static Map<String, Boolean> areEqualKeyValues(Map<String, Object> first, Map<String, Object> second) {
        return first.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().equals(second.get(e.getKey()))));
    }
    
    
    /**To compare to Maps
     * @param map1
     * @param map2
     * @return
     */
    public static boolean compareMap(Map<String, Object> map1, Map<String, Object> map2) {
        if (map1 == null || map2 == null)
            return false;
        for (String ch2 : map2.keySet()) {
            if (!((String) map2.get(ch2)).equalsIgnoreCase((String) map1.get(ch2)))
                return false;
        }
        return true;
    }
    
    /** To Copy file
     * @param origin
     * @param destination
     * @throws IOException
     */
    public static void copyFile(File origin, File destination) throws IOException{
        FileUtils.copyFile(origin, destination);
    }
    
    /**To replace a text in file
     * @param filePath
     * @param oldText
     * @param newText
     */
    public static void replaceFileText(String filePath, String oldText, String newText){
	    try {
	    	Path path = Paths.get(filePath);
	    	Charset charset = StandardCharsets.UTF_8;
	    	String content = new String(Files.readAllBytes(path), charset);
	    	content = content.replaceAll(oldText, newText);
	    	Files.write(path, content.getBytes(charset));
	    }
	    catch(IOException ioe){
	    	
	    } 
	}
    
    /**To insert BCBP Data
     * @param sqlFilePath
     * @param eventId
     * @param paxName
     * @param airlineCode
     * @param flightNumber
     * @param flightDate
     * @param pnrNumber
     * @param hashData
     * @param databaseServer
     * @param databaseName
     */
    public static void insertBCBP(String sqlFilePath, String eventId, String paxName, String airlineCode, String flightNumber, String flightDate, String pnrNumber, String hashData, String databaseServer, String databaseName, String destPath) {
    	try{
    		File fileOrigin = new File(sqlFilePath);
    		File fileDest = new File(destPath);
    		copyFile(fileOrigin, fileDest);
    		String strCommand = "sqlcmd -s "+databaseServer+" -d "+databaseName+" -E -i "+ destPath+" -x";
        	replaceFileText(destPath, "@@EventID@@", eventId);
        	replaceFileText(destPath, "@@PaxName@@", paxName);
        	replaceFileText(destPath, "@@AirlineCode@@", airlineCode);
        	replaceFileText(destPath, "@@FlightNumber@@", flightNumber);
        	replaceFileText(destPath, "@@FlightDate@@", flightDate);
        	replaceFileText(destPath, "@@PNRNumber@@", pnrNumber);
        	replaceFileText(destPath, "@@HashData@@", hashData);
        	Runtime.getRuntime().exec("cmd /c start cmd.exe /C " + strCommand);
        	//Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /C " + strCommand);
    	} catch(Exception e){
	    	
	    } 
    	

    }
    
    
    
    /**To generate alphanumaric string
     * @param count
     * @return
     */
    public static String randomAlphaNumeric(int count) {
    	String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    StringBuilder builder = new StringBuilder();
	    while (count-- != 0) {
	    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	    }
	    return builder.toString();
    }
    
    
    /**To change the current date format
     * @param expectedFormat
     * @return
     */
    public static String changeDateFormat(String expectedFormat){
    	SimpleDateFormat formatter = new SimpleDateFormat(expectedFormat);
    	Date date = new Date();
    	String ourformat = formatter.format(date.getTime());
		return ourformat;
    }
    
    
    /**
     * This method is used to navigate to required location(either button or
     * link or any action item) in the application using keyboard tab
     * functionality and performs enter operation.
     *
     * @param numberOfTABClicks is the number of times of tab clicks through keyboard.
     * @param driver {@link WebDriver}
     */
    public static void performTABOperationAndClickOnEnter(final int numberOfTABClicks, final WebDriver driver) {
        Actions action = new Actions(driver);
        for (int i = 0; i < numberOfTABClicks; i++) {
            action.sendKeys(Keys.TAB).perform();
            SeleniumUtil.waitForSpecificTime(TWO_THOUSAND_MILLISECOND);
        }
        action.sendKeys(Keys.ENTER).perform();
        SeleniumUtil.waitForSpecificTime(TWO_THOUSAND_MILLISECOND);
    }
    
    
    /**To get the row count of webtable
     * @param tableXpath
     * @param driver
     * @return
     */
    public static int getRowCountForWebTable(String tableXpath, WebDriver driver) {
    	tableXpath = tableXpath + "//tr";
        int rowCount = 0;
        try {
            List<WebElement> rows = driver.findElements(By.xpath(tableXpath));
            rowCount = rows.size();
        } catch (ElementNotInteractableException e) {
            LOG.error(e);
        }
        return rowCount;
    }
    
    
    /**To get the row with text
     * @param tableXpath
     * @param driver
     * @param cellText
     * @return
     */
    public static int getRowwithCellText(String tableXpath, WebDriver driver, String cellText){
    	tableXpath = tableXpath + "//tr";
		boolean flag = false;
		int rowWithCellText = 0;
    	try {
            List<WebElement> rows = driver.findElements(By.xpath(tableXpath));
            int i = 1;
            for(WebElement row : rows) {
            	 List<WebElement> cols = row.findElements(By.tagName("td"));
            	 for(WebElement col : cols) {
            		 String actualText = col.getText();  
            		 if (actualText.equals(cellText)) {
            			 flag = true;
            			 rowWithCellText = i;
            			 break;
            		 }
            	 }
            	 if(flag) {
            		 break;
            	 }
            	 i++;
            }
            
        } catch(Exception e) {
            LOG.error(e);
        }
    	return rowWithCellText;
    }
    
    
    /**
     * This method Clicks on the WebTable for the specified table's row.
     *
     * @param table     is the XPath Value to identify the webTable
     * @param rowNumber is the row you want to click the table
     * @author 
     */
    public static void clickOnWebTable(String tableXPath, final int rowNumber, WebDriver driver) {
    	tableXPath = tableXPath + "//tr";
        try {
        	 List<WebElement> rows = driver.findElements(By.xpath(tableXPath));
             List<WebElement> cells = rows.get(rowNumber - 1).findElements(By.tagName("td"));
             cells.get(1).click();
        } catch (IndexOutOfBoundsException ioe) {
            LOG.info( "The rowNumber you have specified seems to be incorrect. Please specify the correct rowNumber."
                    + ioe);
        }
    }
    
    
    
    /**
     * Validate image in Table row
     *
     * @param table     is the XPath Value to identify the webTable
     * @param rowNumber is the row you want to click the table
     * @
     */
    public static boolean checkImageinTableRow(String tableXPath, final int rowNumber, String imgSrc, WebDriver driver) {
    	boolean status = false;
    	tableXPath = tableXPath + "//tr";
    	String imgXPath = "//img[contains(@src, '" + imgSrc+ "')]";
        try {
        	 List<WebElement> rows = driver.findElements(By.xpath(tableXPath));
             List<WebElement> images = rows.get(rowNumber - 1).findElements(By.xpath(imgXPath));
             if(images.size() != 0) {
            	 status = true;
             }
        } catch (IndexOutOfBoundsException ioe) {
            LOG.info( "The rowNumber you have specified seems to be incorrect. Please specify the correct rowNumber."
                    + ioe);
        }
		return status;
    }
    
    /**To wait for an alert and accept
     * @param driver
     * @param timeToWait
     */
    public static void waitForAlert(WebDriver driver, int timeToWait){
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        	if(wait.until(ExpectedConditions.alertIsPresent())!=null) {
        		SeleniumUtil.acceptAlert(driver);
        	}
    	}catch(Exception e){
    		
    	}
    	
    }
    
}
