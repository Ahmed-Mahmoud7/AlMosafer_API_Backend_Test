package com.apitest.base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetFlights extends BaseTest{
    @Step
    public static Response getSearchFlightByCityCode() {
        // Add path parameter

        spec.pathParam("cityCode", "DMM,RUH,JED,ELQ,EAM,GIZ,SV,XY");
        Response response = RestAssured.given(spec).get("/api/flight/resource/codes/{cityCode}");
        response.prettyPrint();
        return response;

    }
    @Step
    public static Response getSearchFlightByConditions() {
        // Add query parameter
        spec.queryParam("query","DMM-RUH/2022-02-23/2022-03-16/Economy/1Adult/1Child");
        // Get response
        Response response = RestAssured.given(spec).get(getFlightByFilterEndPoint);
        response.prettyPrint();
        response.prettyPrint();
        return response;

    }

}
