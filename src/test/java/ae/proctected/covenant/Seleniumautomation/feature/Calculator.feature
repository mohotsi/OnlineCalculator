Feature: Calculator
  Scenario:  adding numbers
    Given User enter the following keys
    |key|
    |       34|
    |        + |
    |        9 |
    |        =|
    Then the screen results should display "43"
  Scenario: subtract numbers
    Given User enter the following keys
      |key|
      |       14|
      |        - |
      |        4 |
      |        =|
    Then the screen results should display "10"

  Scenario:  multiply numbers
    Given User enter the following keys
      |key|
      |       7|
      |        x |
      |        2 |
      |        =|
    Then the screen results should display "14"

  Scenario:  divide numbers
    Given User enter the following keys
      |key|
      |       14|
      |        / |
      |        2 |
      |        =|
    Then the screen results should display "7"

  Scenario:  square root a number
    Given User enter the following keys
      |key|
      |       49|
      |        square root |

    Then the screen results should display "7"