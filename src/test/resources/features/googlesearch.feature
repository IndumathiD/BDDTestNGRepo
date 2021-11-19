Feature: Google Search Function

Scenario: Search Java
Given I launch google page
When I search Java tutorial
Then Should display Java result page
And Close the browser

Scenario: Search Cypress
Given I launch google page
When I search Cypress tutorial
Then Should display Cypress result page
And Close the browser