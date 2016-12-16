Feature: As a User I want to login with an invalid email
Scenario: Login with a invalid email

Given User is on Signup screen
When User enter invalid email
And User login
Then Login validation error