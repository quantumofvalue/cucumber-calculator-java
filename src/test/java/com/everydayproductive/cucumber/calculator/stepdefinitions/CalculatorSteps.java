package com.everydayproductive.cucumber.calculator.stepdefinitions;

import javax.annotation.*;

import com.everydayproductive.cucumber.calculator.Calculator;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class CalculatorSteps {

	@Resource(name="calculator")
	Calculator calculator;
	
	private int result;
	
	@When("^I add (\\d+) and (\\d+)$")
	public void I_add_and(int arg1, int arg2) throws Throwable {
	    result = calculator.add(arg1,arg2);
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int expectedResult) throws Throwable {	
	    Assert.assertEquals(expectedResult, result);
	}
}
