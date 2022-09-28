Feature: feature to test website functionality

  Scenario: Check user is able to buy product
    Given User Navigates to the website URL
    When user is on homepage and click on login page link
    And Enter the useremail and password click login
    And Search the product and checkout
    Then Verify the order and close the browser