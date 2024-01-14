Feature: DuckDuckGo Search
  Scenario: user can search sample phrase
    Given an open browser with duckduckgo.com
    When user search for selenium
    Then the first result should contain selenium
    And quit browser