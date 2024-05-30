Feature: Login Action

  @UI1
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigates to LogIn Page
    And user enters "<username>" and "<password>"
    Then user should be logged in successfully
    Examples:
      | username | password  |
      | user1   | user1pass |

# Scenario: Successful LogOut
#When User LogOut from the Application
# hen Message displayed LogOut Successfully

