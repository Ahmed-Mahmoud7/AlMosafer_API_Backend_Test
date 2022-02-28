package com.apitest.base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCurrencies extends BaseTest{

    @Step
    public static Response getCurrencyAllList() {
        Response response = RestAssured.given(spec).get(currencyEndPoint);
        response.prettyPrint();
        return response;
    }
}
