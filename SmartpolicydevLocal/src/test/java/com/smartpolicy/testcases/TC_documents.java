package com.smartpolicy.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import com.smartpolicy.pageObjects.documents;
import com.smartpolicy.pageObjects.login;
import com.smartpolicy.utilities.Base;

import junit.framework.Assert;

public class TC_documents  extends Base {

	public WebDriver driver;

	@Test(dataProvider="smartpoldetails")

	public void Documents(String userName,String password) throws IOException, InterruptedException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		login login = new login(driver);
		
		documents doc = new documents(driver);

		login.loginUserName().sendKeys(userName);

		login.loginPassword().sendKeys(password);

		login.loginSubmit().click();
		
		Assertion softAssert = new SoftAssert();

		//verifying whether logged in successfully

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(login.landPageTitle()));

		Assert.assertTrue(login.landPageTitle().isDisplayed());

		Thread.sleep(3000);

		//Checking whether Document page UI elements are present

		wait.until(ExpectedConditions.elementToBeClickable(doc.filterOption()));

		softAssert.assertTrue(doc.filterOption().isDisplayed()); // Filter option
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.searchOption()));

		softAssert.assertTrue(doc.searchOption().isDisplayed()); // Search option
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.searchButton()));

		softAssert.assertTrue(doc.searchButton().isDisplayed()); // Search button
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.resetButton()));

		softAssert.assertTrue(doc.resetButton().isDisplayed()); // Reset button
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(doc.fileBrowseOption()));

		//softAssert.assertTrue(doc.fileBrowseOption().findElement(doc.fileBrowseOption())); // File browse button
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.allDocumentsSection()));

		softAssert.assertTrue(doc.allDocumentsSection().isDisplayed()); // All Documents section
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.folderstogglebtn()));

		softAssert.assertTrue(doc.folderstogglebtn().isDisplayed()); // Folders toggle button
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.createNewFolder()));

		softAssert.assertTrue(doc.createNewFolder().isDisplayed()); // Create new folder button
		
		wait.until(ExpectedConditions.elementToBeClickable(doc.docsToggleButton()));

		softAssert.assertTrue(doc.docsToggleButton().isDisplayed()); // Create new folder button
		
		//Upload a new document	
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].style.display='block';", doc.fileBrowseOption());
		
		doc.fileBrowseOption().sendKeys("C:\\Projects\\test-automation\\SmartPolicyDev\\src\\main\\java\\resources\\24428416_1.pdf");
		
		Thread.sleep(8000);
		
	}

	@DataProvider(name="smartpoldetails")
	//public void dataSupplier() {

	String [][] getClaimData() throws IOException {

		String excelPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\smartpoldetails.xlsx";

		String [][] data = null;

		File file = new File(excelPath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		//Get physical no. of rows in the sheet

		int rows = sheet.getPhysicalNumberOfRows();

		//Get physical no. of cells

		int cells = sheet.getRow(0).getPhysicalNumberOfCells();

		data = new String [rows - 1][cells];

		for(int i=1; i<rows; i++) {

			for(int j=0; j<cells; j++) {

				String cellData = sheet.getRow(i).getCell(j).getStringCellValue();

				data [i-1][j] = cellData;//data[0][0]		

			}
		}

		return data;
	}


	@AfterTest

	public void tearDown() {

		driver.quit();
	}

}

