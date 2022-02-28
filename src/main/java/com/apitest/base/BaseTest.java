package com.apitest.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;




public class BaseTest {

    public static String baseUrl = "https://www.almosafer.com" ;
    public static String getFlightByCityCodeEndPoint = "/api/flight/resource/codes/DMM,RUH,JED,ELQ,EAM,GIZ,SV,XY" ;
    public static String getFlightByFilterEndPoint = "/api/v3/flights/flight/search" ;
    public static String currencyEndPoint = "/api/system/currency/list" ;
    public static String countriesEndPoint = "/api/system/country/list" ;
    public static String postEndPointAirport = "/api/cms/page" ;
    RequestSpecBuilder requestBuilder;
    static RequestSpecification spec;


    @BeforeMethod
    public void setUp(){
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(baseUrl);
        spec = requestBuilder.build();
    }





}
