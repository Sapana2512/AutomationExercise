package com.qa.automationexercise.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1 String locators

	private String emailId = "//input[@data-qa='login-email']";
	private String password = "//input[@data-qa='login-password']";
	private String loginBtn = "//button[normalize-space()='Login']";
	private String logutLink = "//a[normalize-space()='Logout']";
	protected String errormessage = "//form[@action='/login']/p";
	private String loginFormTitle = "//*[@class='login-form']//h2";
	private String signupFormTitle = "//*[@class='signup-form']//h2";

	// 2 Page constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// 3 //3page action/methods:
	public String getLoginPagetitle() {
		return page.title();
	}

	public String getLoginFormtitle() {
		return page.textContent(loginFormTitle);
	}

	public String getsignUpFormtitle() {
		return page.textContent(signupFormTitle);
	}

	public boolean doLogin(String AppuserName, String Apppassword) {
		System.out.println("Credentials:" + AppuserName + ":" + Apppassword);
		page.fill(emailId, AppuserName);
		page.fill(password, Apppassword);
		page.click(loginBtn);
		if (page.isVisible(logutLink)) {
			System.out.println("user is logged in successfully..");
			return true;
		}
		return false;
	}

	public String incorrectInputDataMessage() {
		return page.textContent(errormessage);
	}

	public String EmptyFieldMessage() {
		return page.locator(password).getAttribute("data-error");
	}

	public boolean AssertEmtyFiledMessage() {
		boolean isPasswordHighlighted = page.locator("input[placeholder='Password']:invalid").isVisible();
		if (isPasswordHighlighted) {
			System.out.println("Test Passed: Password field is required and validation error is triggered.");
			return true;
		} else {
			System.out.println("Test Failed: Validation error for the password field was not triggered.");
		}
		return false;
	}

}
