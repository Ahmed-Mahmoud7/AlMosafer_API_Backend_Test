package com.apitest.base;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;



public class BaseTest {

    public static String baseUrl = "https://www.almosafer.com" ;
    public static String getFlightByCityCodeEndPoint = "/api/flight/resource/codes/DMM,RUH,JED,ELQ,EAM,GIZ,SV,XY" ;
    public static String getFlightByFilterEndPoint = "/api/v3/flights/flight/search" ;
    public static String currencyEndPoint = "/api/system/currency/list" ;
    public static String countriesEndPoint = "/api/system/country/list" ;
    public static String postEndPointAirport = "/api/cms/page" ;
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .build();
    }

    @Step
    public Response getAirPorts() {
        JSONObject body = new JSONObject();
        body.put("template","top-airports-v2.json");
        body.put("country","general");
        body.put("media","mobile");
        body.put("locale","en_us");
        // Get response
        Response response = given(spec).contentType(ContentType.JSON)
                .body(body.toString()).post(postEndPointAirport);
        response.print();
        return response;
    }

}
