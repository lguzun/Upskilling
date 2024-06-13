package org.example.api.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.dtos.*;
import org.example.api.dtos.requests.AddBooksRequest;
import org.example.api.dtos.requests.AuthorizationRequest;
import org.example.api.dtos.requests.RemoveBookRequest;
import org.example.api.dtos.responses.BookResponse;
import org.example.api.dtos.responses.TokenResponse;
import org.example.api.dtos.responses.UserAccountResponse;
import org.junit.Assert;

public class AddBookStepsP {
    private static final String USER_ID = "222c5a3b-46c2-4002-a5ea-d89801f3e060";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private String bookId;
    private static TokenResponse tokenResponse;
    private static Book book;



    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        AuthorizationRequest credentials = new AuthorizationRequest("tuser","Test@123!");

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();  //  Rest Assured Interface to define the request specification. Initialize request specification

        request.header("Content-Type", "application/json"); // Set a header
        response = request.body(credentials).post("/Account/v1/GenerateToken"); // Serialize the credentials object to JSON and sending POST request

        String jsonString = response.asString(); //Convert the Response to a String
      //  token = JsonPath.from(jsonString).get("token"); // uses JsonPath class to parse the JSONstring and extract the token
        tokenResponse = response.getBody().as(TokenResponse.class); //the body is deserialized into TokenResponse class using methos "as"
    }

    @Given("a list of books is available")
    public void listOfBooksAreAvailable() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");

        // Deserializing the Response body into BookResponse class
        BookResponse books = response.getBody().as(BookResponse.class);
        book = books.books.get(0);
    }

    @When("I add a book to my reading list")
    public void addBookInList() {
        ISBN isbn = new ISBN(book.isbn);
        AddBooksRequest addBooksRequest = new AddBooksRequest(USER_ID, new ISBN(book.isbn));

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + tokenResponse.token)
                .header("Content-Type", "application/json");

        response = request.body(addBooksRequest).post("/BookStore/v1/Books");
    }

    @Then("the book is added")
    public void bookIsAdded() {
         Assert.assertEquals(201, response.getStatusCode());
        // Deserializing the Response body into UserAccountResponse class
        UserAccountResponse userAccountResponse = response.getBody().as(UserAccountResponse.class);

      //  Assert.assertEquals(USER_ID, userAccountResponse.userId);
        //Assert.assertEquals(book.isbn, userAccountResponse.books.get(0).isbn);
    }

    @When("I remove a book from my reading list")
    public void removeBookFromList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        RemoveBookRequest removeBookRequest = new RemoveBookRequest(USER_ID, book.isbn);

        request.header("Authorization", "Bearer " + tokenResponse.token)
                .header("Content-Type", "application/json");

        response = request.body(removeBookRequest).delete("/BookStore/v1/Book");
    }

    @Then("the book is removed")
    public void bookIsRemoved() {
        Assert.assertEquals(204, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + tokenResponse.token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(200, response.getStatusCode());

        // Deserializing the Response body into UseAccountResponse class
        UserAccountResponse userAccount = response.getBody().as(UserAccountResponse.class);
        Assert.assertEquals(0, userAccount.books.size());

    }
}