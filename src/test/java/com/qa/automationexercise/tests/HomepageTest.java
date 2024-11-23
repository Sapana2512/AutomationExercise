package com.qa.automationexercise.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automationexercise.base.BaseTest;

public class HomepageTest extends BaseTest {
	
@Test
public void homePageURLTest() {
	
	String actualURL = homePage.getHomepageURL();
	Assert.assertEquals(actualURL, prop.getProperty("url"));
	
}

	
}
