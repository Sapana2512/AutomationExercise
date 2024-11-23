package com.qa.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.BaseTest;
import com.qa.automationexercise.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	//precondition to check user navigated to login page
	@Test(priority =1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualoginPagelTitle = loginPage.getLoginPagetitle();
		System.out.println("page actual title:"+actualoginPagelTitle);
		Assert.assertEquals(actualoginPagelTitle, AppConstants.LOGIN_PAGE_TITLE);
		String loginFormtitle = loginPage.getLoginFormtitle();
		System.out.println("form title" +loginFormtitle);
		Assert.assertEquals(loginFormtitle, AppConstants.LOGIN_FORM_TITLE);
		
	}
	@Test(priority = 2)
	public void VerifyUserLoginWithValidData() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		
	}
	
	@Test
	public void VerifyLoginWithIncorrectData() {
		System.out.println("Test User Login With Invalid Credentials");
		loginPage = homePage.navigateToLoginPage();
		loginPage.doLogin(prop.getProperty("wrongusername").trim(), prop.getProperty("wrongpassword").trim());
		String Actualerrormessage = loginPage.incorrectInputDataMessage();
		System.out.println("incorrectinputdatamessage:"+Actualerrormessage);
		Assert.assertEquals(Actualerrormessage, AppConstants.INCORRECT_EMAIL_ERROR_MESSAGE);
	}
	
	@Test
	@Parameters("isPasswordHighlighted")
	public void VerifyUserLoginWithoutEmailOrPassword(@Optional("true") boolean isPasswordHighlighted) {
		System.out.println("Test User Login Without Email or Password");
		loginPage = homePage.navigateToLoginPage();
		loginPage.doLogin(prop.getProperty("Blankusername").trim(), prop.getProperty("Blankpassword").trim());
		loginPage.AssertEmtyFiledMessage();
		//Assert.assertEquals(isPasswordHighlighted, AppConstants.EMPTY_FIELD_ERROR_MESSAGE);
	    Assert.assertTrue(isPasswordHighlighted);

	}
	
	

}
