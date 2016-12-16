Feature: As a User I want to check logged screen actions

Scenario: Check the user1 token its correct

Given User1 logged
When User show token   
Then Admin token its the same

Scenario: Check the admin token its correct

Given Admin logged
When User show token   
Then User1 token its the same
