package api.testing;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUserTest{
    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private static final String APP_ID = "6635f6c123256272eaba3b31";
    private static final String USER_ID = "60d0fe4f5311236168a109ca";

    @Test
    public void testForbiddenAppIdMissing() {
        given()
            .header("app-id", "")
        .when()
            .delete(BASE_URL + "user/" + USER_ID)
        .then()
            .assertThat()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
    }

    @Test
    public void testForbiddenAppIdNotExist() {
        given()
            .header("app-id", "662e2e44bb70a7c4a12593f5")
        .when()
            .delete(BASE_URL + "user/" + USER_ID)
        .then()
            .assertThat()
            .statusCode(403)
            .body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Test
    public void testBadRequestInvalidId() {
        given().
            header("app-id", APP_ID).
        when().
            get(BASE_URL + "user/test123").
        then().
            assertThat().
            statusCode(400).
            body("error", equalTo("PARAMS_NOT_VALID"));
    }

    @Test
    public void testGetUsersSuccess() {
        given().
            header("app-id", APP_ID).
        when().
            get(BASE_URL + "user").
        then().
            assertThat().
            statusCode(200).
            body("data", hasSize(20));
    }

    @Test
    public void testBadRequestInvalidIdFormat() {
        given()
            .header("app-id", APP_ID)
        .when()
            .get(BASE_URL + "user/test123")
        .then()
            .assertThat()
            .statusCode(400)
            .body("error", equalTo("PARAMS_NOT_VALID"));
    }

}