package com.apitest.mosaferapi;

import com.apitest.base.BaseTest;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class SearchFlightsTest extends BaseTest {


    @Description("GET Flights Method")
    @Test(description = "Validate to search about flights by city code")
    public void getSearchFlightByCityCode() {
        // Add path parameter
        spec.pathParam("cityCode","DMM,RUH,JED,ELQ,EAM,GIZ,SV,XY");

        Response response = RestAssured.given(spec).get("/api/flight/resource/codes/{cityCode}");
        response.prettyPrint();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 flight in the response
        Assert.assertEquals(response.jsonPath().get("airline[0].label.en"), "Saudia");
        Assert.assertEquals(response.jsonPath().get("airline[1].label.en"), "flynas");
        Assert.assertEquals(response.jsonPath().get("airport[0].label.en"), "King Fahad International Airport");
        Assert.assertEquals(response.jsonPath().get("airport[0].city.en"), "Dammam");
        Assert.assertEquals(response.jsonPath().get("airport[1].city.en"), "Riyadh");


    }
    @Description("GET Flights With Conditions Method")
    @Test(description = "Validate to search about flights in specific date and passengers numbers and types")
    public void getSearchFlightWithConditions() {
        // Add query parameter
        spec.queryParam("query","DMM-RUH/2022-02-23/2022-03-16/Economy/1Adult/1Child");
        // Get response
        Response response = RestAssured.given(spec).get(getFlightByFilterEndPoint);
        response.prettyPrint();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 flight in the response
        Assert.assertEquals(response.jsonPath().get("request.cabin"), "Economy");


    }
    @Description("GET Currency Method")
    @Test(description = "Validate currencies available for payments and prices")
    public void getCurrencyList() {
        // Get response
        Response response = RestAssured.given(spec).get(currencyEndPoint);
        response.prettyPrint();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 currency in the response
        Assert.assertEquals(response.jsonPath().get("base.symbol"), "SAR");
        Assert.assertEquals(response.jsonPath().get("base.name_plural"), "Saudi riyals");


    }
    @Description("GET Countries Method")
    @Test(description = "Validate to list all countries ")
    public void getCountriesList() {
        // Get response
        Response response = RestAssured.given(spec).get(countriesEndPoint);
        response.prettyPrint();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 flight id in the response
        Assert.assertEquals(response.jsonPath().get("[0].Code"), "SA");
        Assert.assertEquals(response.jsonPath().get("[0].Label[0].Value"), "Saudi Arabia");


    }
    @Description("POST Method To Check Airports")
    @Test(description = "Validate list airports")
    public void selectFlightPost() {
        // Create JSON body
        Response response = getAirPorts();

        // Verifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        softAssert.assertEquals(response.jsonPath().get("origins[0].name"), "King Khaled International Airport");
        softAssert.assertEquals(response.jsonPath().get("origins[1].name"), "King Abdulaziz International Airport");
        softAssert.assertEquals(response.jsonPath().get("origins[2].name"), "King Fahad International Airport");
        softAssert.assertAll();





    }



}
