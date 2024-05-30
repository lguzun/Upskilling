Feature: User Registration

  Scenario Outline: Register a new user with valid details
    Given User is on the registration page
    When User submits the registration form with the following details
      | customer.firstName       | <firstName> |
      | customer.lastName        | <lastName>  |
      | customer.address.street  | <address>   |
      | customer.address.city    | <city>      |
      | customer.address.state   | <state>     |
      | customer.address.zipCode | <zipcode>   |
      | customer.phoneNumber     | <phone>     |
      | customer.ssn             | <SSN>       |
      | customer.username        | <username>  |
      | customer.password        | <password>  |
      | repeatedPassword         | <confirm>   |
    Then User should see a success message

    Examples:
      | firstName | lastName | address | city | state | zipcode | phone  | SSN   | username | password  | confirm   |
      | user2     | user11   | RM      | NY   | NY    | 2023    | 123456 | 98765 | user6    | user1pass | user1pass |



