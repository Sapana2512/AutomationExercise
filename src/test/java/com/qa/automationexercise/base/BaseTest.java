package com.qa.automationexercise.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.qa.automationexercise.factory.PlaywrightFactory;
import com.qa.automationexercise.pages.HomePage;
import com.qa.automationexercise.pages.LoginPage;
import com.qa.automationexercise.pages.SignUpPage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected SignUpPage signupPage;

	@BeforeTest
	public void setUp() {
		pf =new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		try {
            // Wait for the "Consent" button to appear and click it
            page.waitForSelector("button:has-text('Consent')", new Page.WaitForSelectorOptions().setTimeout(5000));
            page.click("button:has-text('Consent')");
            System.out.println("Consent accepted.");
        } catch (PlaywrightException e) {
            System.out.println("Cookie consent popup not found or already handled.");
        }
		}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	
	
	
}
