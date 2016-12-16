Feature: As a User I want to try to login with an empty email
Scenario: Login with a empty mail

Given User is on Signup screen
When User enter password
And User login
Then Login validation error
