package org.example;

import io.restassured.http.ContentType;
import org.example.Models.ResponseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestPostman {
    private final static String URL = "https://postman-echo.com/";
    @Test
    public void testGetMethod() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        ResponseData responseData = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("get")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNotNull(responseData);
        Assertions.assertEquals(responseData.getArgs().getFoo1(), "bar1");
        Assertions.assertEquals(responseData.getArgs().getFoo2(), "bar2");
        headerAssertions(responseData, "application/json");
        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/get?foo1=bar1&foo2=bar2");
    }

    @Test
    public void testPostRawText() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        ResponseData responseData = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("post")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNull(responseData.getArgs().getFoo1());
        Assertions.assertEquals(responseData.getData(), "This is expected to be sent back as part of response body.");
        Assertions.assertNull(responseData.getFiles().getFoo1());
        Assertions.assertNull(responseData.getForm().getFoo1());

        headerAssertions(responseData, "application/json");

        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/post");
    }

    @Test
    public void testPostFormData() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        ResponseData responseData = given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("post")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNull(responseData.getArgs().getFoo1());
        Assertions.assertEquals(responseData.getData(), "");
        Assertions.assertNull(responseData.getFiles().getFoo1());
        Assertions.assertEquals(responseData.getForm().getFoo1(), "bar1");
        Assertions.assertEquals(responseData.getForm().getFoo2(), "bar2");
        Assertions.assertEquals(responseData.getJson().getFoo1(), "bar1");
        Assertions.assertEquals(responseData.getJson().getFoo2(), "bar2");

        headerAssertions(responseData, "application/x-www-form-urlencoded; charset=UTF-8");

        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/post");
    }

    @Test
    public void testPutMethod() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        ResponseData responseData = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("put")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNull(responseData.getArgs().getFoo1());
        Assertions.assertEquals(responseData.getData(), "This is expected to be sent back as part of response body.");
        Assertions.assertNull(responseData.getFiles().getFoo1());
        Assertions.assertNull(responseData.getForm().getFoo1());
        Assertions.assertNull(responseData.getJson());

        headerAssertions(responseData, "application/json");

        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/put");
    }

    @Test
    public void testPatchMethod() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        ResponseData responseData = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("patch")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNull(responseData.getArgs().getFoo1());
        Assertions.assertEquals(responseData.getData(), "This is expected to be sent back as part of response body.");
        Assertions.assertNull(responseData.getFiles().getFoo1());
        Assertions.assertNull(responseData.getForm().getFoo1());
        Assertions.assertNull(responseData.getJson());

        headerAssertions(responseData, "application/json");

        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/patch");
    }

    @Test
    public void testDeleteMethod() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        ResponseData responseData = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("delete")
                .then().log().all()
                .extract().as(ResponseData.class);

        Assertions.assertNull(responseData.getArgs().getFoo1());
        Assertions.assertEquals(responseData.getData(), "This is expected to be sent back as part of response body.");
        Assertions.assertNull(responseData.getFiles().getFoo1());
        Assertions.assertNull(responseData.getForm().getFoo1());
        Assertions.assertNull(responseData.getJson());

        headerAssertions(responseData, "application/json");

        Assertions.assertEquals(responseData.getUrl(), "https://postman-echo.com/delete");
    }

    public static void headerAssertions(ResponseData responseData, String contentType) {
        Assertions.assertEquals(responseData.getHeaders().getXForwardedProto(), "https");
        Assertions.assertEquals(responseData.getHeaders().getXForwardedPort(), "443");
        Assertions.assertEquals(responseData.getHeaders().getHost(), "postman-echo.com");
        Assertions.assertNotNull(responseData.getHeaders().getXAmznTraceId());
        Assertions.assertEquals(responseData.getHeaders().getUserAgent(), "Apache-HttpClient/4.5.13 (Java/21.0.1)");
        Assertions.assertEquals(responseData.getHeaders().getAccept(), "*/*");
        Assertions.assertEquals(responseData.getHeaders().getAcceptEncoding(), "gzip,deflate");
        Assertions.assertEquals(responseData.getHeaders().getContentType(), contentType);
    }
}
