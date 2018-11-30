Feature: contactus form

  Scenario: default values
    When I'm on contact us page as unlogged user
    Then I should see Subject Heading dropdown with -- Choose -- value
    And I should see Email address input with empty value
    And I should see Order reference input with empty value
    And I should see Attach File input with No file selected value
    And I should see message panel with empty value

  Scenario Outline: fill form with valid data
    Given I'm on contact us page as unlogged user
    When I enter <subject> into Subject Heading input
    And I enter <email> into Email address input
    And I enter <orderRef> into Order reference input
    And I enter <message> into Message panel
    And I click Send button
    Then I should see "Your message has been successfully sent to our team." label with green background

    Examples:
      | subject          | email          | orderRef | message           |
      | Customer Service | sss@gmail.com  | var      | my first message  |
      | Webmaster        | mstr@gmail.com | tmep     | my second message |