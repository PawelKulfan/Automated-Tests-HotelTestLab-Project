Feature: Adding first adress
Scenario: User adds first adress
    Given An open browser with logged user
    When User adds new delivery adress to My Account page
    Then First adress added to My Account page
    And Quit browser