package com.qa.automationexercise.pages;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.automationexercise.constants.AppConstants;

public class SignUpPage {
	private Page page;

	// 1 String locators

	private String emailField = "//input[@data-qa='login-email']";
	private String signupEmail = "//input[@data-qa='signup-email']";
	private String nameField = "input[placeholder='Name']";

	private String signUpButton = "//button[normalize-space()='Signup']";
	private String addressInfoTitle = "//*[@action='/signup']/h2";
	private String accountInfoTitle = "//div[@class='login-form']/h2";
	private String titleMrRadioButton = "//div[@class='login-form']/h2";
	private String titleMrsRadioButton = "//input[@id='id_gender2']";
	private String passwordField = "//input[@id='password']";
	private String dayOfBirthDropDown = "//select[@id='days']";
	private String monthOfBirthDropDown = "//select[@id='months']";
	private String yearOfBirthDropDown = "//select[@id='years']";
	private String newsLetterCheckbox = "//input[@id='newsletter']";
	private String receiveOffersCheckbox = "//input[@id='optin']";
	private String firstNameField = "//input[@id='first_name']";
	private String lastNameField = "//input[@id='last_name']";
	private String companyField = "//input[@id='company']";
	private String addressField = "//input[@id='address1']";
	private String address2Field = "//input[@id='address2']";
	private String countryField = "//select[@id='country']";
	private String stateField = "//input[@id='state']";
	private String cityField = "//input[@id='city']";
	private String zipCodeField = "//input[@data-qa='zipcode']";
	private String mobileNumberField = "//input[@id='mobile_number']";
	private String createAccountButton = "//button[@data-qa='create-account']";
	private String existemailerrormsg ="//form[@action='/signup']/p";
	private String accountcreatedmessage ="//section[@id='form']//div[@class='row']//h2";
	 private String continuebtn ="//a[normalize-space()='Continue']";
	 private String deleteaccountlink ="a[href='/delete_account']";
	 private String accountdeletedmessage ="//section[@id='form']//div[@class='row']//h2";

	
	 
	
	public SignUpPage (Page page) {
		this.page = page;
	}

	public void fillSignUpForm(String name, String email) {
		page.fill(nameField, name);
		page.fill(signupEmail, email);
		page.click(signUpButton);
	}

	public void fillAccountInfo(String password, String day, String month, String year, boolean subscribeNewsletter,
			boolean receiveOffers) {
		page.check(titleMrsRadioButton);
		page.fill(passwordField, password);
		page.selectOption(dayOfBirthDropDown, day);
		page.selectOption(monthOfBirthDropDown, month);
		page.selectOption(yearOfBirthDropDown, year);

		if (subscribeNewsletter)
			page.check(newsLetterCheckbox);
		if (receiveOffers)
			page.check(receiveOffersCheckbox);
	}


	public void fillAddressDetails(String firstName, String lastName, String company, String address1, String address2,
			String country, String state, String city, String zipCode, String mobileNumber) {
		page.fill(firstNameField, firstName);
		page.fill(lastNameField, lastName);
		page.fill(companyField, company);
		page.fill(addressField, address1);
		page.fill(address2Field, address2);
		//page.selectOption(countryField, country);
		page.fill(stateField, state);
		page.fill(cityField, city);
		page.fill(zipCodeField, zipCode);
		page.fill(mobileNumberField, mobileNumber);
	}
	

	public void clickCreateAccount() {
		page.click(createAccountButton);
	}
	public void fillPassword(String password ) {
		page.fill(passwordField, password);
		
	}
	public void clickContinue() {
		page.click(continuebtn);
	}
	public void deleteAccount() {
		page.click(deleteaccountlink);
	}
	public void clearField(String fieldLocator) {
	    page.locator(fieldLocator).fill("");  // Clears the field
	}

	
	
		
	

	
	public boolean AssertpasswordFieldAreFilled() {
		boolean isPasswordHighlighted = page.locator("input#password:invalid").isVisible();
		if (isPasswordHighlighted) {
			System.out.println("Test Passed: Password field is required and validation error is triggered.");
			return true;
			
		} else {
			System.out.println("Test Failed: Validation error for the password field was not triggered.");
		}
		return false;
	}

	public boolean AssertFirstnameFieldAreFilled() {
		boolean isFirstNameHighlighted = page.locator("input#first_name:invalid").isVisible();
		if (isFirstNameHighlighted) {
			System.out.println("Test Passed: FirstName field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the firstname field was not triggered.");
		}
		return false;
	}

	public boolean AssertLastnameFieldAreFilled() {
		boolean isLastNameHighlighted = page.locator("input#last_name:invalid").isVisible();
		if (isLastNameHighlighted) {
			System.out.println("Test Passed: LastName field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the lastname field was not triggered.");
		}
		return false;
	}
	public boolean AssertAddressFieldAreFilled() {
		boolean isAddressHighlighted = page.locator("input#address1:invalid").isVisible();
		if (isAddressHighlighted) {
			System.out.println("Test Passed: Address field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the Address field was not triggered.");
		}
		return false;
	}
	public boolean AssertStateFieldAreFilled() {
		boolean isStateHighlighted = page.locator("input#state:invalid").isVisible();
		if (isStateHighlighted) {
			System.out.println("Test Passed: State field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the State field was not triggered.");
		}
		return false;
	}
	
	public boolean AssertCityFieldAreFilled() {
		boolean isCityHighlighted = page.locator("input#city:invalid").isVisible();
		if (isCityHighlighted) {
			System.out.println("Test Passed: City field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the City field was not triggered.");
		}
		return false;
	}
	public boolean AssertZipCodeFieldAreFilled() {
		boolean isZipCodeHighlighted = page.locator("input#zipcode:invalid").isVisible();
		if (isZipCodeHighlighted) {
			System.out.println("Test Passed: ZipCode field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the ZipCode field was not triggered.");
		}
		return false;
	}
	public boolean AssertMobileNumberFieldAreFilled() {
		boolean isMobileNumberHighlighted = page.locator("input#zipcode:invalid").isVisible();
		if (isMobileNumberHighlighted) {
			System.out.println("Test Passed: Mobilenumber field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the Mobilenumber field was not triggered.");
		}
		return false;
	}
	
	public String AssertErrorEmailAddressAlreadyExistMessageIsDisplayed() {
		return page.textContent(existemailerrormsg);
		
	}
	public void AssertUserIsLogout()
    {
        // Assert.True(loginLink.Displayed);
    }
	
	public String AssertAccountCreated() {
		return page.textContent(accountcreatedmessage);
	}
	public String AsserAccountDeleted() {
		return page.textContent(accountdeletedmessage);
	}

	

	
}
