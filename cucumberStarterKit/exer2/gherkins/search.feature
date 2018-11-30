Feature: Seach input field

 Scenario Outline: Input a correct search text into the search input field
 Given Search input field is visible
 And The user clicks in the search field
 And A correct <text> is entered into the field
 When Enter key is pressed on keyboard
 Then The page is rerouted to a page containing <text> results
 
 Examples:
 |text|
 |apple|
 |mouse|
 |IPhone|
 
 Scenario Outline: Input a correct search text with a trailing punctuation mark into the search input field  - this test will fail
 Given Search input field is visible
 And The user clicks in the search field
 And A correct <text> is entered into the field
 When Enter key is pressed on keyboard
 Then  The page is rerouted to no results found page
 
 Examples:
 |text|
 |apple!|
 |mouse.|
 |IPhone:|
 
  Scenario Outline: Input an incorrect search text into the search input field
 Given Search input field is visible
  And The user clicks in the search field
 And An incorrect <text> is entered into the field
 When Enter key is pressed on keyboard
 Then The page is rerouted to no results found page
 
 Examples:
 |text|
 |qwerty|
 |uiopa|
 |zxcvb|
 
 Scenario: Don't enter anything into the search input field
 Given Search input field is visible
 And The user clicks in the search field
 And Nothing is entered into the field
 When Enter key is pressed on keyboard
 Then The page is rerouted to a page containing products
 
 Scenario: Try to enter a string int the field without clicking in it
 Given Search input field is visible
 And The User doesn't click into the search field
 And The user attempts to enter a string into the field
 Then Nothing is entered in the field
 
 
 
 
 
