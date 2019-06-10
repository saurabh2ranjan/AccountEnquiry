package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.starter.AccountApplication;
import lombok.extern.slf4j.Slf4j;
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
    public void findAccount_shouldReturn404_forNotMatchedAccount() {

        given()
        .port(port)
        .when()
        .get("/account/user1")
        .then()
        .statusCode(404)
        .log().all();
    }
}
