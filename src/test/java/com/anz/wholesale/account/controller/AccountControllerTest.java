package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.starter.AccountApplication;
import com.anz.wholesale.account.TestData;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class AccountControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void findAccount_shouldReturn404_forNotFoundAccountForUser() {

        given()
        .port(port)
        .when()
        .get("/accountEnquiry/user0")
        .then()
        .statusCode(404)
        .log().all();
    }

    @Test
    public void findAccount_shouldReturn200_forAccountsForUser() {

        String responseBody = given()
            .port(port)
            .when()
            .get("/accountEnquiry/user1")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract().body().asString();
        
        Assert.assertEquals(TestData.getExpectedDataForUser1(), responseBody);
    }

    @Test
    public void findTransaction_shouldReturn404_forNotFoundTransactionForAccount() {

        given()
                .port(port)
                .when()
                .get("/accountEnquiry/11111/transactions")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void findTransaction_shouldReturn200_forTransactionsForAccount() {

        String responseBody = given()
                .port(port)
                .when()
                .get("/accountEnquiry/100001/transactions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().asString();

        Assert.assertEquals(TestData.getExpectedDataForAccount1(), responseBody);
    }
}
