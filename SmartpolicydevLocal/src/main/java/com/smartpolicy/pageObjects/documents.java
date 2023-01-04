package com.smartpolicy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class documents {

	WebDriver driver;

	public documents(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// Documents page UI Elements
	
	@FindBy(xpath="//*[@class='brand_filter with_filter_icon']")
	WebElement filterOption;
	
	@FindBy(xpath="//*[@placeholder='Search']")
	WebElement searchOption;
	
	@FindBy(xpath="//*[@title='Search']")
	WebElement searchButton;

	@FindBy(xpath="//*[@title='Reset']")
	WebElement resetButton;
	
	//@FindBy(xpath="//*[@type='button' and text()='Browse']")
	@FindBy(xpath="//*[@type='file']")
	WebElement fileBrowseOption;
	
	@FindBy(xpath="//*[@class='documents_row']")
	WebElement allDocumentsSection;
	
	@FindBy(xpath="//body/app-root[1]/div[3]/app-documents-doc-digger[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/h3[1]/span[1]/k-icon[1]/k-fa-icon[1]")
	WebElement folderstogglebtn;
	
	@FindBy(xpath="//body/app-root[1]/div[3]/app-documents-doc-digger[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/button[1]")
	WebElement createNewFolder;
	
	@FindBy(xpath="//body/app-root[1]/div[3]/app-documents-doc-digger[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/h3[1]/span[1]/k-icon[1]/k-fa-icon[1]")
	WebElement docsToggleButton;
	
	public WebElement filterOption(){

		return filterOption;

	}
	
	public WebElement searchOption(){

		return searchOption;

	}
	
	public WebElement searchButton(){

		return searchButton;

	}
	
	public WebElement resetButton(){

		return resetButton;

	}
	
	public WebElement fileBrowseOption(){

		return fileBrowseOption;

	}

	public WebElement allDocumentsSection(){

		return allDocumentsSection;

	}
	
	public WebElement folderstogglebtn(){

		return folderstogglebtn;

	}
	
	public WebElement createNewFolder(){

		return createNewFolder;

	}
	
	public WebElement docsToggleButton(){

		return docsToggleButton;

	}


}
