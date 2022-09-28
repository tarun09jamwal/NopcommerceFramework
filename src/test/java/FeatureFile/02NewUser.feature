Feature: feature to test website functionality

  Scenario: Check new user is able to register
    Given Navigate to website URL
    When user is on home page and click on register
    And Fill the user infornation
    Then Verify the user and close the browser