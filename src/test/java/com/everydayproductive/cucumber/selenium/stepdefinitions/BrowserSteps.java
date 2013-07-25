package com.everydayproductive.cucumber.selenium.stepdefinitions;


import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserSteps {
	
	private WebDriver driver;
	
	@Before
	public void beforeScenario() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario() {
		driver.quit();
	}

	@When("^I visit \"([^\"]*)\"$")
	public void I_visit(String url) throws Throwable {
	    driver.get(url);
	}

	@When("^I click the link \"([^\"]*)\"$")
	public void I_click_the_link(String href) throws Throwable {
	    //driver.findElement(By.xpath("//*[@id='billboard']/div/div[3]/h2/a")).click();
		driver.findElement(By.xpath(String.format("//a[@href='%s']", href))).click();
		//driver.findElement(By.linkText("iOS 7. The mobile OS from a whole new perspective.")).click();		
	}

	@Then("^I should see the iOS(\\d+) web page$")
	public void I_should_see_the_iOS_web_page(int arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("iOS 7"));
	}	
}
