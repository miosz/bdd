Feature: Math operations

  Background:
   Given I have number 10

  Scenario: Can subtract three numbers
    Given following numbers: 7, 3, 2
    When I subtract
    Then I get -2

  Scenario: Can subtract three numbers
    Given following numbers:
      | 7 |
      | 3 |
      | 2 |
    When I subtract
    Then I get -2

  Scenario: Can subtract three numbers
    Given following numbers:
      | 7 | 3 | 2 |
    When I subtract
    Then I get -2

  Scenario Outline: Can subtract three numbers
    Given number is <number1>
    And number is <number2>
    When I subtract
    Then I get <result> in result

    Examples:
    | number1 | number2 | result |
    | 5       | 3       | 2      |
    | 5       | 4       | 1      |
    | 5       | 5       | 0      |