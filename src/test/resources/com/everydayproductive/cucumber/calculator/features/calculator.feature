Feature: Calculator
    In order to perform basic mathematical operations in my programs
    As a developer
    I want to have a calculator class

Scenario: Adding two integer numbers
    When I add 4 and 5
    Then the result should be 9
    
Scenario: Adding another two integer numbers
    When I add 7 and 8
    Then the result should be 15

Scenario Outline: Adding integer numbers
	When I add <argument1> and <argument2>
	Then the result should be <sum>
	
	Examples:
	| argument1	| argument2	| sum	|
	| 4			| 5			| 9		|
	| 7			| 8			| 15	|

Scenario: Adding numbers using a table
	Given the following argument pairs:
	| argument1	| argument2	|
	| 4			| 5			|
	| 7			| 8			|
	When I add first and second argument
	Then I should get the following list of results:
	| sum	|
	| 9		|
	| 15	|
