package org.pom;

import org.base.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends HelperClass {
	
	public PojoClass() {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="usernamereg-firstName")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getBirthMonth() {
		return birthMonth;
	}

	public WebElement getBirthDay() {
		return birthDay;
	}

	public WebElement getBirthYear() {
		return birthYear;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getTermsBtn() {
		return termsBtn;
	}


	@FindBy(id="usernamereg-lastName")
	private WebElement lastName;
	
	@FindBy(id="usernamereg-yid")
	private WebElement emailId;
	
	@FindBy(id="usernamereg-password")
	private WebElement pass;
	
	@FindBy(id="usernamereg-phone")
	private WebElement phoneNo;
	
	@FindBy(id="usernamereg-month")
	private WebElement birthMonth;
	
	@FindBy(id="usernamereg-day")
	private WebElement birthDay;
	
	@FindBy(id="usernamereg-year")
	private WebElement birthYear;
	
	@FindBy(id="usernamereg-freeformGender")
	private WebElement gender;
	
	@FindBy(id="reg-submit-button")
	private WebElement continueBtn;
	
	@FindBy(xpath="//a[@class='termsLink']")
	private WebElement termsBtn;
	
	@FindBy(name="shortCountryCode")
	private WebElement countryCode;

	public WebElement getCountryCode() {
		return countryCode;
	}
	

}
