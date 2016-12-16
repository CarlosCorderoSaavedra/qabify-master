Feature: As a User I want to login without password field filled 
Scenario: Login with empty password

Given User is on Signup screen
When User enter user1 email
And User login
Then Login validation error