Feature: Feature to test login functionality

  Scenario: Verify login functionality
    Given User launches the Application
    When User clicks on Login link
    Then Login page should be displayed

  @sanity
  Scenario Outline: Verify succcessfull login
    Given User launches the Application
    When User enter "<username>" and "<password>"
    Then Login page should be displayed

    Examples: 
      | username | password |
      | abc      | xyz      |
