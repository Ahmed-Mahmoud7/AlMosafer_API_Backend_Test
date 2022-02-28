package com.apitest.base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCountries  extends BaseTest{
    @Step
    public  Response getCountriesListAllList() {
        Response response = RestAssured.given(spec).get(countriesEndPoint);
        response.prettyPrint();
        return response;
    }
}
