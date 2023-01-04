package com.smartpolicy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reviewDocument {
	
	WebDriver driver;

	public reviewDocument(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//*[@class=\"custom_card\" and @title=\"24428416_1.pdf\"][1]")
	WebElement docForReview;
	
	@FindBy(xpath="//*[@class=\"klaim_btn  btn-dark-grey\" and @type=\"button\"]")
	WebElement reviewButton;
	
	@FindBy(xpath="//*[@class='nextCard']")
	WebElement nextCardButton;
	
	@FindBy(xpath="//*[@class='prevCard']")
	WebElement prevCardButton;
	
	@FindBy(xpath="//*[@data-btn=\"review\" and @id=\"0\" ]")
	WebElement reviewdocButton;
	
	@FindBy(xpath="(//*[ @class=\"nextCard\"])[2]")
	WebElement revrisk_nextButton;
	
	@FindBy(xpath="//*[ @id=\"comments\"]")
	WebElement acceptComment;
	
	@FindBy(xpath="//*[ @title=\"Accept\" and @type=\"Submit\"]")
	WebElement acceptReview;
		
	@FindBy(xpath="//*[ @id=\"comments\"]")
	WebElement rejectComment;
	
	@FindBy(xpath="//*[@title=\"Reject\" and @type=\"button\"]")
	WebElement rejectReview;
	
	@FindBy(xpath="(//*[@type=\"button\" and text()=\"Review Complete\"])[2]")
	WebElement reviewcompleteBtn;
	
	
	
	
	public WebElement docForReview(){

		return docForReview;

	}
	
	public WebElement reviewButton(){

		return reviewButton;

	}
	
	public WebElement nextCardButton(){

		return nextCardButton;

	}
	
	public WebElement prevCardButton(){

		return prevCardButton;

	}
	
	public WebElement reviewdocButton(){

		return reviewdocButton;

	}
	
	public WebElement revrisk_nextButton(){

		return revrisk_nextButton;

	}
	
	public WebElement acceptComment(){

		return acceptComment;

	}
	
	public WebElement acceptReview(){

		return acceptReview;

	}
	
	public WebElement rejectComment(){

		return rejectComment;

	}
	
	public WebElement rejectReview(){

		return rejectReview;

	}
	
	public WebElement reviewcompleteBtn(){

		return reviewcompleteBtn;

	}
}
