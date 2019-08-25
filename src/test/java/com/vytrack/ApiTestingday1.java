package com.vytrack;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;

public class ApiTestingday1 {
    static final String HR = "http://54.92.217.205:1000/ords/hr/";

    @Test
    public void simpleGet() throws URISyntaxException {
        URI uri = new URI(HR + "employees/100");

        given().accept(ContentType.JSON)
                .when().get(uri)
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("first_name", equalTo("Steven"))
                .and().assertThat().body("employee_id", equalTo(100));

    }

}
