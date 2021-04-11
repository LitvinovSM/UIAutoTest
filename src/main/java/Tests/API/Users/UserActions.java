package Tests.API.Users;

import Tests.API.RequesterBase;
import cucumber.api.java.ru.И;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class UserActions extends RequesterBase {

    @И("^пробный тест$")
    public void пробныйТест() {
        String rs = given().baseUri("https://reqres.in/api").basePath("/users").contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200).extract().asPrettyString();
        System.out.println(rs);

//        given().baseUri("https://reqres.in/api").basePath("/users").contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200).body("data[0].email",equalTo("george.bluth@reqres.in"));

        List<String> emails = given().baseUri("https://reqres.in/api").basePath("/users").contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200).extract().jsonPath().getList("data.email");
        System.out.println(emails.toString());

        List<UserPojo> userList= given().baseUri("https://reqres.in/api").basePath("/users").contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200).extract().jsonPath().getList("data",UserPojo.class);
        System.out.println(userList.toString());
        assertThat(userList).extracting(UserPojo::getEmail).contains("1");
    }
}
