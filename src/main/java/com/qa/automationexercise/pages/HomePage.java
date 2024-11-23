package com.qa.automationexercise.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1, String Locators
	private String loginlink = "a:text(\" Signup / Login\")";
	private String signupLink = "a:text(\" Signup / Login\")";

	// private String

	// 2 Page constructor
	public HomePage(Page page) {
		this.page = page;
	}

	// 3page action/methods

	public String getHomepageURL() {
		String url = page.url();
		System.out.println("page url:" + url);
		return url;
	}

	public String getHomePagetitle() {
		return page.title();
	}

	public LoginPage navigateToLoginPage() {
		page.click(loginlink);
		return new LoginPage(page);
	}

	public SignUpPage navigateToSignupPagePage() {
		page.click(loginlink);
		return new SignUpPage(page);
	}

}
