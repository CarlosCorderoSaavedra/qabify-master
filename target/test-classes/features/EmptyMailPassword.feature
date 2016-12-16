Feature: As a User I want to login without Email and password
Scenario: Login with a empty mail and password

Given User is on Signup screen
When User login
Then Login validation error