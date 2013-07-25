Feature: Browser
    In order to experience ui testing in Cucumber
    As a developer
    I want to experiment with Selenium Web Driver

Scenario: Visiting Apple Web Site
    When I visit "http://www.apple.com"
    And I click the link "/ios/ios7/"
    Then I should see the iOS7 web page
