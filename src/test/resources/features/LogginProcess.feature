Feature: As a User I want to check login proccess and validation errors.

Scenario: Sucessfull login with the user user1

Given User is on Signup screen
When User enter user1 details
And User login
Then Login user1 successfull

Scenario: Sucessfull login with the user admin

Given User is on Signup screen
When User enter admin details
And User login
Then Login admin successfull




















