Feature: Google Search Function

Scenario: Search Selenium
Given I launch google page
When I search Selenium tutorial
Then Should display Selenium result page
And Close the browser