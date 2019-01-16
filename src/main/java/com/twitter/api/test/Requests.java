package com.twitter.api.test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Requests {

    private static String BASE_URI = "https://api.twitter.com/1.1/";
    private static String SECRET_KEY = System.getenv("SECRET_KEY");

    public static ValidatableResponse StatusUpdateTest(HashMap<String, ?> mapToJson) {

        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .header("secret_key", SECRET_KEY)
                .body(mapToJson)
                .when()
                .post("statuses/update.json")
                .then();
    }

    public static ValidatableResponse StatusRetweetUpdateTest(int id) {

        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .header("secret_key", SECRET_KEY)
                .when()
                .post("statuses/retweet/" + id + ".json")
                .then();
    }

}
