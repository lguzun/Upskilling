//package org.example.api.actions;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.example.api.enums.APIEndpoints;
//import org.example.api.dtos.User;
//
//public class UserActions {
//
//    private static final String BASE_URL = "https://reqres.in";
//
//    public Response createUser(User user) {
//        return RestAssured
//                .given()
//                .baseUri(BASE_URL)
//                .contentType("application/json")
//                .body(user)
//                .post(APIEndpoints.CREATE_USER.getEndpoint());
//    }
//
//    public Response getUserById(String id) {
//        return RestAssured
//                .given()
//                .baseUri(BASE_URL)
//                .pathParam("id", id)
//                .get(APIEndpoints.GET_USER.getEndpoint());
//    }
//
//
//    public Response getHealthCheck() {
//        return RestAssured
//                .given()
//                .baseUri(BASE_URL)
//                .get(APIEndpoints.HEALTH_CHECK.getEndpoint());
//    }
//}
