package com.vytrack;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;

public class ApiTestindDay3 {
    static final String key = "&key=06c0bbfe5c844f5e86c321da36bd50c6";
    static final String searchByCity = "https://api.weatherbit.io/v2.0/current?city=";

    @Test
    public void test() throws URISyntaxException {

        URI uri = new URI(searchByCity + "dushanbe" + key);
        Response response = given().accept(ContentType.JSON)
                .when().get(uri);

        System.out.println(response.then().assertThat().statusCode(200).extract().path("data.timezone").toString());
        System.out.println(response.then().assertThat().statusCode(200).extract().path("data.temp").toString());



    }

}
