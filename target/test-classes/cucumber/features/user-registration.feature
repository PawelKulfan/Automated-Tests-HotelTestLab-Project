Feature: Registration of a new user
#  Scenario: User registers a new account
#    Given An open browser with user registration page
#    When User registers with valid credentials
#    Then New user account created
#    And Quit browser

  Scenario Outline: User registers a new account
    Given An open browser with user registration page
    When User registers with valid credentials: <firstName> <lastName> <password>
    Then New user account created
    And Quit browser

    Examples:
    | firstName | lastName | password |
    | Jan       | Kowalski | 12345    |
    | Andrzej   | Grabowski| 54321    |
    | Kazimierz | Dejna    | 123654   |
