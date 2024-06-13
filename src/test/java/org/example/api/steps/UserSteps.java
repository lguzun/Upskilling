//package org.example.api.steps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import org.example.api.actions.UserActions;
//import org.example.api.dtos.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.notNullValue;
//
//public class UserSteps {
//
//    private User user;
//    private Response response;
//    private UserActions userActions;
//    private static final Logger LOGGER = LoggerFactory.getLogger(UserSteps.class);
//
//    public UserSteps() {
//        userActions = new UserActions();
//    }
//
//    @Given("the API is up and running")
//    public void theApiIsUpAndRunning() {
//        LOGGER.info("Checking if the API is up and running");
//        response = userActions.getHealthCheck();
//        LOGGER.debug("Health check response: {}", response.asString());
//       // assertThat(response.getStatusCode(), equalTo(200));
//        //TODO to add warning and exception if it is down
//    }
//
//    @When("the POST request to create a new user with name {string} and job {string} is sent")
//    public void thePostRequestToCreateNewUserWithNameAndJobIsSent(String name, String job) {
//        LOGGER.info("Setting up user details");
//        user = new User(name, job);
//        LOGGER.debug("User details set: {}", user);
//        LOGGER.info("Sending POST request to create user");
//        response = userActions.createUser(user);
//        LOGGER.debug("Response received: {}", response.asString());
//    }
//
//
//    @When("a GET request to retrieve the user with id {string} is sent")
//    public void aGETRequestToRetrieveTheUserWithIdIsSent(String id) {
//        LOGGER.info("Sending GET request to retrieve user with id {}", id);
//        response = userActions.getUserById(id);
//        LOGGER.debug("Response received: {}", response.asString());
//
//    }
//
//    @Then("the response status code should be {int}")
//    public void theResponseStatusCodeShouldBe(int statusCode) {
//        LOGGER.info("Verifying response status code");
//        LOGGER.debug("Expected status code: {}, Actual status code: {}", statusCode, response.getStatusCode());
//        assertThat(response.getStatusCode(), equalTo(statusCode));
//    }
//
//    @Then("the response should contain the user details")
//    public void theResponseShouldContainTheUserDetails() {
//        LOGGER.info("Verifying response contains user details");
//        assertThat(response.jsonPath().getString("name"), equalTo(user.getName()));
//        assertThat(response.jsonPath().getString("job"), equalTo(user.getJob()));
//        assertThat(response.jsonPath().getString("id"), notNullValue());
//        assertThat(response.jsonPath().getString("createdAt"), notNullValue());
//        LOGGER.debug("Response contains user details as expected");
//        //TODO to add response to scenario context
//    }
//
//    @Then("the response should contain the user's details")
//    public void theResponseShouldContainTheUsersDetails() {
//        LOGGER.info("Verifying response contains specific user details");
//        assertThat(response.jsonPath().getInt("data.id"), equalTo(2));
//        assertThat(response.jsonPath().getString("data.email"), notNullValue());
//        assertThat(response.jsonPath().getString("data.first_name"), notNullValue());
//        assertThat(response.jsonPath().getString("data.last_name"), notNullValue());
//        assertThat(response.jsonPath().getString("data.avatar"), notNullValue());
//        LOGGER.debug("Response contains specific user details as expected");
//        //TODO to add response to scenario context
//        // todo to compare fields from pojo request and response
//    }
//
//
//}
