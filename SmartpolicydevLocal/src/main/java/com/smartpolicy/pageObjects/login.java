package com.smartpolicy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	
	WebDriver driver;

	public login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Username")
	WebElement loginUserName;

	@FindBy(id="Password")
	WebElement loginPassword;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginSubmit;
	
	@FindBy(xpath="//*[@class ='page_title']")
	WebElement landPageTitle;
	
	
	public WebElement loginUserName(){

		return loginUserName;

	}

	public WebElement loginPassword(){

		return loginPassword;

	}
	
	public WebElement loginSubmit(){

		return loginSubmit;

	}
	
	public WebElement landPageTitle(){

		return landPageTitle;

	}
	
}
