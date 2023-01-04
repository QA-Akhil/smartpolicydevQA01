package com.smartpolicy.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.smartpolicy.pageObjects.login;
import com.smartpolicy.utilities.Base;

import junit.framework.Assert;

public class TC_login extends Base {

	public WebDriver driver;

	@Test(dataProvider="smartpoldetails")

	public void login(String userName,String password) throws IOException, InterruptedException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		login login = new com.smartpolicy.pageObjects.login(driver);

		login.loginUserName().sendKeys(userName);

		login.loginPassword().sendKeys(password);

		login.loginSubmit().click();
		
		//verifying whether logged in successfully
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(login.landPageTitle()));
		
		Assert.assertTrue(login.landPageTitle().isDisplayed());
		
		
		

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
;
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

}
