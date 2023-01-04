package com.smartpolicy.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.smartpolicy.pageObjects.documents;
import com.smartpolicy.pageObjects.login;
import com.smartpolicy.pageObjects.reviewDocument;
import com.smartpolicy.utilities.Base;

public class TC_reviewSingleDoc extends Base {

	public WebDriver driver;

	@Test(dataProvider="smartpoldetails")

	public void Documents(String userName,String password) throws IOException, InterruptedException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		login login = new login(driver);

		reviewDocument review = new reviewDocument(driver);

		login.loginUserName().sendKeys(userName);

		login.loginPassword().sendKeys(password);

		login.loginSubmit().click();

		Assertion Assert = new SoftAssert();

		//verifying whether logged in successfully

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(login.landPageTitle()));

		Assert.assertTrue(login.landPageTitle().isDisplayed());

		Thread.sleep(3000);


		//Selecting the uploaded document for review

		review.docForReview().click();

		Thread.sleep(3000);

		review.reviewButton().click();

		Thread.sleep(3000);

		//Navigating through first five cards on document page

		//Next card
		for (int i=0;i<4;i++) {

			review.nextCardButton().click();
			Thread.sleep(2000);
		}

		//Previous Card
		for (int i=0;i<4;i++) {

			review.prevCardButton().click();
			Thread.sleep(2000);
		}

		//Selecting review button and navigating next buttons to accept a review		
		
		review.reviewdocButton().click();
		Thread.sleep(4000);
		
		for (int i=0;i<4;i++) {
			
		review.revrisk_nextButton().click();
		Thread.sleep(2000);
		
		}
		
		//Accepting a review
		
		review.acceptComment().sendKeys("Accepting the review");
		Thread.sleep(4000);		
		review.acceptReview().click();
		Thread.sleep(4000);
		
		//Rejecting a review and selecting review complete
		
		review.revrisk_nextButton().click();
		Thread.sleep(2000);
		review.rejectComment().sendKeys("Rejecting the review");
		Thread.sleep(4000);		
		review.rejectReview().click();
		Thread.sleep(4000);
		
		//Review Complete 
		
		review.reviewcompleteBtn().click();
		Thread.sleep(4000);
		
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
