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
import com.smartpolicy.pageObjects.uploadedDoc;
import com.smartpolicy.utilities.Base;

import junit.framework.Assert;

public class TC_uploadedDocument extends Base {
	
	public WebDriver driver;

	@Test(dataProvider="smartpoldetails")

	public void Documents(String userName,String password) throws IOException, InterruptedException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		login login = new login(driver);
		
		uploadedDoc document = new uploadedDoc(driver);

		login.loginUserName().sendKeys(userName);

		login.loginPassword().sendKeys(password);

		login.loginSubmit().click();
		
		Assertion Assert = new SoftAssert();

		//verifying whether logged in successfully

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(login.landPageTitle()));

		Assert.assertTrue(login.landPageTitle().isDisplayed());

		Thread.sleep(3000);

		//verifying whether the uploaded doc is listed
		
		wait.until(ExpectedConditions.elementToBeClickable(document.uploadedDocumenttitle()));

		Assert.assertTrue(document.uploadedDocumenttitle().isDisplayed());

		Thread.sleep(3000);
		
		//Selecting the document for review
		
		
		//Navigating through the review cases
		
		
		//Accepting a review
		
		
		//Rejecting a review
		
		
		//Review Completing
		
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

