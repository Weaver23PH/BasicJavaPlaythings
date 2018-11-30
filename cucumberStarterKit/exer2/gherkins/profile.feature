Feature: Profile edit

Background: 
Given The user is logged in on the profile editing page

Scenario: Checking if strings are added to "Display name publicly as" dropdown
Given The required "nickname" field is filled
And The other name fields are empty
When The user enters any string in the "First Name " input field
And The user clicks on the "Display name publicly as" dropdown
Then The string entered into the "First Name " input field is visible in the dropdown

Scenario: Checking if strings are removed from "Display name publicly as" dropdown
Given The required "nickname" field is filled
And At least one of the other name fields is filled
And The string(s) from the other filled name fields are visible in the "Display name publicly as" dropdown
When The user deletes the string in any of the other name fields
And The user clicks on the "Update profile" button
And The profile edit page is reloaded
And The user clicks on the "Display name publicly as" dropdown
Then The deleted string is not visible in the dropdown

Scenario Outline: Updating the profile data
Given The "required" fields are filled
But The other fields are empty
When The user enters <firstName> into first name field
And The user enters <lastName> into last name field
And The user clicks the "Update profile" button
Then The profile edit page is reloaded, the data is saved

Examples: 
|firstName|lastName|
|Ellen|Ripley|
|Alan|Schaeffer|
|R.J.|MacReady|
 
 Scenario: Generating a new paswword
 Given The "Generate password" button is visible
 When The user clicks on the "Generate password" button
 Then A new input field with the generated password appears
 
 Scenario: Logging out of everywhere else
 Given The "Log out of everywhere else" button is clickable
 When The user clicks the "Log out of everywhere else" button
 Then The "You are logged out of everywhere else" message appears
 
