Feature: Login Action
@UI
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigates to LogIn Page
    And User enters "<username>" and "<password>"
    Then Then User should be logged in successfully
  Examples:
    |username  | password    |
    |user4   | user1pass |

# Scenario: Successful LogOut
#When User LogOut from the Application
# hen Message displayed LogOut Successfully

