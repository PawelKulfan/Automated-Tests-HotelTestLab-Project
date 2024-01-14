Feature: Registration of a new user
  Scenario: User registers a new account
    Given An open browser with user registration page
    When User registers with valid credentials
    Then New user account created
    And Quit browser