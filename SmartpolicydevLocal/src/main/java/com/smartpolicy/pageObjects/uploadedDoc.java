package com.smartpolicy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadedDoc {

	WebDriver driver;

	public uploadedDoc(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	//Uploaded doc 
	
	@FindBy(xpath="//*[@class=\"custom_card\" and @title=\"24428416_1.pdf\"]")
	WebElement uploadedDocumenttitle;	
	
	public WebElement uploadedDocumenttitle(){

		return uploadedDocumenttitle;

	}
	
	
}
