package com.apitest.mosaferapi;

import com.apitest.base.*;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchFlightsTest  extends BaseTest{


    @Description("GET Flights Method")
    @Test(description = "Validate to search about flights by city code")
    public void validateToSearchFlightByCityCode() {
        Response response = GetFlights.getSearchFlightByCityCode();
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
    public void validateSearchFlightWithConditions() {
        Response response = GetFlights.getSearchFlightByConditions();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 flight in the response
        Assert.assertEquals(response.jsonPath().get("request.cabin"), "Economy");


    }
    @Description("GET Currency Method")
    @Test(description = "Validate currencies available for payments and prices")
    public void getCurrencyList() {
        // Get response
        Response response = GetCurrencies.getCurrencyAllList();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 currency in the response
        Assert.assertEquals(response.jsonPath().get("base.symbol"), "SAR");
        Assert.assertEquals(response.jsonPath().get("base.name_plural"), "Saudi riyals");


    }
    @Description("GET Countries Method")
    @Test(description = "Validate to list all countries ")
    public void validateGetAllCountriesList() {
        GetCountries count = new GetCountries();
        Response response = count.getCountriesListAllList();
        // Verify response is 200
        Assert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        // Verify at least 1 country in the response
        Assert.assertEquals(response.jsonPath().get("[0].Code"), "SA");
        Assert.assertEquals(response.jsonPath().get("[0].Label[0].Value"), "Saudi Arabia");


    }
    @Description("POST Method To Check Airports")
    @Test(description = "Validate list airports")
    public void selectFlightPost() {

        Response response = PostMethod.getAirPorts();

        // Verifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200, "Status code is 200 and success");
        softAssert.assertEquals(response.jsonPath().get("origins[0].name"), "King Khaled International Airport");
        softAssert.assertEquals(response.jsonPath().get("origins[1].name"), "King Abdulaziz International Airport");
        softAssert.assertEquals(response.jsonPath().get("origins[2].name"), "King Fahad International Airport");
        softAssert.assertAll();





    }



}
