Feature: Create a new account in salesforce page
Scenario: Login into the salesforce application
Given Launch the browser
And Load the URL
And Enter the username as vidyar@testleaf.com
And Enter the Password as 'Sales@123'
When Click on the Login button

Scenario: Create an account into the salesforce application
Given Launch the browser
And Load the URL
And Enter the username as vidyar@testleaf.com
And Enter the Password as 'Sales@123'
When Click on the Login button
And Click on toggle menu button from the left corner
And Click view All and click Sales from App Launcher
And Click on Accounts tab
And Click on New button
Given Enter 'vinitha' as account name
When Select Ownership as Public
And Click save and verify Account name