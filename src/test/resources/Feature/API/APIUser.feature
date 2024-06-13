Feature: User creation

#TODO to add Background
  # TODO 2 sepparate fetaurea Create positive and negative path

  Scenario: Successfully create a new user
    Given the API is up and running
    When the POST request to create a new user with name "lilia" and job "qa" is sent
      #datatable for user details
    Then the response status code should be 201
    And the response should contain the user details
    # the following user detailes job = ... , name ...., id = regex



  Scenario: Successfully retrieve user details
    Given the API is up and running
    When a GET request to retrieve the user with id "1" is sent
    Then the response status code should be 200
    And the response should contain the user's details
    # the following user detailes job = ... , name ...., id = regex


