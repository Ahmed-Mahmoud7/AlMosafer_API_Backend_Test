package com.apitest.base;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostMethod extends BaseTest{

    @Step
    public static Response getAirPorts() {
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
