Feature: As a User I want to check the button show password show it

Scenario: Check show password button

Given User is on Signup screen
When User enter user1 details
And User show password
Then The password is displayed
