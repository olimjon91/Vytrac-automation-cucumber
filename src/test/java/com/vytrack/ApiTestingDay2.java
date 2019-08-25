package com.vytrack;

import com.vytrack.utilities.ConfigurationReader;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class ApiTestingDay2 {



    @Test
    public void testItemsCountFromResponseBody() {
        given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.get("hrapp_baseurl") + "regions")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType(ContentType.JSON)
                .and().assertThat().body("items.region_id", hasSize(4))
                .and().assertThat().body("items.region_name", hasItems("Americas", "Asia"))
                .and().assertThat().body("items.region_name", hasItem("Middle East and Africa"));
    }

    @Test
    public void trstWithParams(){
        given().accept(ContentType.JSON)
                .and().param("limit", 50)
                .when().get(ConfigurationReader.get("hrapp_baseurl")+"employees")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("items.employee_id", hasSize(50));
    }

}
