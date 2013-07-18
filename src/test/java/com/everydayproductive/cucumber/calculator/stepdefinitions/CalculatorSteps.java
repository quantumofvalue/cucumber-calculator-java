package com.everydayproductive.cucumber.calculator.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

import com.everydayproductive.cucumber.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.PendingException;

import org.junit.Assert;

public class CalculatorSteps {

	@Resource(name="calculator")
	Calculator calculator;
	
	private int result;
	private List<Argument> arguments;
	private List<Result> results;
	
	@When("^I add (\\d+) and (\\d+)$")
	public void I_add_and(int arg1, int arg2) throws Throwable {
	    result = calculator.add(arg1,arg2);
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int expectedResult) throws Throwable {	
	    Assert.assertEquals(expectedResult, result);
	}
	
	@Given("^the following argument pairs:$")
	public void the_following_argument_pairs(List<Argument> arguments) throws Throwable {
	    this.arguments = arguments;
	}

	@When("^I add first and second argument$")
	public void I_add_first_and_second_argument() throws Throwable {
		results = new ArrayList<Result>();
		for (Argument argument:arguments){
	    	results.add(new Result(calculator.add(argument.argument1, argument.argument2)));
	    }
	}

	@Then("^I should get the following list of results:$")
	public void I_should_get_the_following_list_of_results(List<Result> expectedResults) throws Throwable {
		Assert.assertArrayEquals(results.toArray(), expectedResults.toArray());
	}
	
	public class Argument {
		public Integer argument1;
		public Integer argument2;
	}
	
	public class Result {
		public Integer sum;
		public Result() {
		}
		public Result(int result) {
			this.sum = new Integer(result);
		}
		@Override
		public boolean equals(Object result) {
			return (sum == (int)((Result)result).sum);
		}
	}
}
