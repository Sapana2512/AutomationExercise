package com.qa.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.BaseTest;
import com.qa.automationexercise.constants.AppConstants;

public class SignUpPageTest extends BaseTest {
	
	@Test
	public  void signUpTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualoginPagelTitle = loginPage.getLoginPagetitle();
		System.out.println("page actual title:"+actualoginPagelTitle);
		Assert.assertEquals(actualoginPagelTitle, AppConstants.LOGIN_PAGE_TITLE);
		String signUpformtitle = loginPage.getsignUpFormtitle();
		signupPage = homePage.navigateToSignupPagePage();
		System.out.println("signupform title" +signUpformtitle);
		Assert.assertEquals(signUpformtitle, AppConstants.SIGNUP_FORM_TITLE);
		signupPage.fillSignUpForm(AppConstants.NAME,AppConstants.EMAIL );
		signupPage.fillAccountInfo(AppConstants.PASSWORD,AppConstants.DAY_OF_MONTH,AppConstants.MONTH_OF_YEAR,AppConstants.YEAR,true,true);	
		signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
	    signupPage.clickCreateAccount();
	    signupPage.AssertAccountCreated();
	    String accountcreatedmsg = signupPage.AssertAccountCreated();
	    System.out.println("actualaccountcreationmsg:" + accountcreatedmsg);
		Assert.assertEquals(accountcreatedmsg,AppConstants.ACCOUN_CREATED_MSG);
		signupPage.clickContinue();
		signupPage.deleteAccount();
		String accountdeletedmsg = signupPage.AsserAccountDeleted();
		System.out.println("accountdeleted:" + accountdeletedmsg);
		Assert.assertEquals(accountdeletedmsg,AppConstants.ACCOUN_DELETED_MSG);
		signupPage.clickContinue();	
}
	
	
	@Test 
	@Parameters({
	    "isPasswordHighlighted", 
	    "isFirstNameHighlighted", 
	    "isLastNameHighlighted",
	    "isAddressHighlighted",
	    "isStateHighlighted",
	    "isCityHighlighted",
	    "isZipCodeHighlighted",
	    "isMobileNumberHighlighted"
	})
	
	public void VerifyErrorMessageDisplayedOnRequiredFields(@Optional("true") boolean isPasswordHighlighted, 
		    @Optional("true") boolean isFirstNameHighlighted,
		    @Optional("true") boolean isLastNameHighlighted,
		    @Optional("true") boolean isAddressHighlighted,
		    @Optional("true") boolean isStateHighlighted,
		    @Optional("true") boolean isCityHighlighted,
		    @Optional("true") boolean isZipCodeHighlighted,
		    @Optional("true") boolean isMobileNumberHighlighted) {
		loginPage = homePage.navigateToLoginPage();
		String actualoginPagelTitle = loginPage.getLoginPagetitle();
		System.out.println("page actual title:" + actualoginPagelTitle);
		Assert.assertEquals(actualoginPagelTitle, AppConstants.LOGIN_PAGE_TITLE);
		String signUpformtitle = loginPage.getsignUpFormtitle();
		System.out.println("signupform title" + signUpformtitle);
		Assert.assertEquals(signUpformtitle, AppConstants.SIGNUP_FORM_TITLE);
		signupPage = homePage.navigateToSignupPagePage();
		System.out.println("signupform title" +signUpformtitle);
		Assert.assertEquals(signUpformtitle, AppConstants.SIGNUP_FORM_TITLE);
		signupPage.fillSignUpForm(AppConstants.NAME, AppConstants.EMAIL);
		signupPage.clickCreateAccount();
		  signupPage.AssertpasswordFieldAreFilled();
		  Assert.assertTrue(isPasswordHighlighted,AppConstants.PASSWORDFIELD_VALIDATION);
		  signupPage.fillPassword(AppConstants.PASSWORD);
		  
		  signupPage.fillAddressDetails("",AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
		
		  signupPage.clickCreateAccount();
		  signupPage.AssertFirstnameFieldAreFilled();
	      Assert.assertTrue(isFirstNameHighlighted,AppConstants.FIRSTNAME_VALIDATION );
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,"", AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
		
		  signupPage.clickCreateAccount();
		  signupPage.AssertLastnameFieldAreFilled();
		  Assert.assertTrue(isLastNameHighlighted,AppConstants.LASTNAMEFIELD_VALIDATION);
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, "", AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
		  signupPage.clickCreateAccount();
		  signupPage.AssertAddressFieldAreFilled();
		  Assert.assertTrue(isAddressHighlighted,AppConstants.ADDRESSFIELD_VALIDATION);
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, "", AppConstants.CITY, AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
		  signupPage.clickCreateAccount();
		   signupPage.AssertStateFieldAreFilled();
		  Assert.assertTrue(isStateHighlighted,AppConstants.STATEFIELD_VALIDATION );
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE,"" , AppConstants.ZIP_CODE, AppConstants.MOBILE_NUMBER);
		  signupPage.clickCreateAccount();
		  signupPage.AssertCityFieldAreFilled();
		  Assert.assertTrue(isCityHighlighted,AppConstants.CITYFIELD_VALIDATION );
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, "", AppConstants.MOBILE_NUMBER);
		  signupPage.clickCreateAccount();
		  signupPage.AssertZipCodeFieldAreFilled();
		  Assert.assertTrue(isZipCodeHighlighted,AppConstants.ZIPFIELD_VALIDATION );
		  
		  signupPage.fillAddressDetails(AppConstants.FIRST_NAME,AppConstants.LAST_NAME, AppConstants.COMPANY_NAME, AppConstants.FIRSTADDRESS, AppConstants.SECONDADDRESS, AppConstants.COUNTRY, AppConstants.STATE, AppConstants.CITY, AppConstants.ZIP_CODE, "");
		  signupPage.clickCreateAccount();
		  signupPage.AssertMobileNumberFieldAreFilled();
		  Assert.assertTrue(isMobileNumberHighlighted,AppConstants.
		  MOBILEFIELD_VALIDATION );
		 
		
		
	}
		
	
	
	@Test
	public void verifysignUpwithexistingemail() {
		loginPage = homePage.navigateToLoginPage();
		String actualoginPagelTitle = loginPage.getLoginPagetitle();
		System.out.println("page actual title:" + actualoginPagelTitle);
		Assert.assertEquals(actualoginPagelTitle, AppConstants.LOGIN_PAGE_TITLE);
		String signUpformtitle = loginPage.getsignUpFormtitle();
		System.out.println("signupform title" + signUpformtitle);
		Assert.assertEquals(signUpformtitle, AppConstants.SIGNUP_FORM_TITLE);
		signupPage = homePage.navigateToSignupPagePage();
		System.out.println("signupform title" +signUpformtitle);
		Assert.assertEquals(signUpformtitle, AppConstants.SIGNUP_FORM_TITLE);
		signupPage.fillSignUpForm(AppConstants.NAME, AppConstants.EXISTINGEMAIL);
		String existingemailerrormsg = signupPage.AssertErrorEmailAddressAlreadyExistMessageIsDisplayed();
		System.out.println("actualerrormsg:" + existingemailerrormsg);
		Assert.assertEquals(existingemailerrormsg,AppConstants.EXISTING_EMAIL_ERROR_MSG);
		
}
}