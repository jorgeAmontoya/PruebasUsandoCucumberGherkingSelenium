Feature: I can find a city inside a state.
  @Test
  Scenario Outline: As a Test Engineer, I want to validate that a text is present inside the List
    Given I navigate to the List page
    When I search <state> in the List
    Then I can find <city> in the list

    Examples:
    |state|city|
    |Washington     |Seattle, Washington    |
    |Chicago      |Chicago, Illinois  |