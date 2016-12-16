Feature: As a User I want to check the button show password show it

Scenario: Login with a too short password

Given User is on Signup screen
When User enter user1 email
And User enter short password
And User login
Then Login validation error