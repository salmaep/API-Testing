package api.testing;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteUserTest {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private static final String APP_ID = "6635f6c123256272eaba3b31";
    private static final String USER_ID = "60d0fe4f5311236168a109ca";
    private static final String APP_ID_SARA = "663631b625a5b8565b8a1d2c";   

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
    public void testDeleteUserSuccess() {
        given()
            .header("app-id", APP_ID_SARA)
        .when()
            .delete(BASE_URL + "user/" + USER_ID)
        .then()
            .assertThat()
            .statusCode(200)
            .body("id", equalTo(USER_ID));
    }

    @Test
    public void testResourceNotFound() {
        String nonexistentId = "60d0fe4f5311236168a109ca";
        given()
            .header("app-id", APP_ID)
        .when()
            .get(BASE_URL + "user/" + nonexistentId)
        .then()
            .assertThat()
            .statusCode(404)
            .body("error", equalTo("RESOURCE_NOT_FOUND"));
    }

    @Test
    public void testPathNotFound() {
        given()
            .header("app-id", APP_ID)
        .when()
            .delete(BASE_URL)
        .then()
            .assertThat()
            .statusCode(404)
            .body("error", equalTo("PATH_NOT_FOUND"));
    }

    @Test
    public void testBadRequestInvalidId() {
        given()
            .header("app-id", APP_ID)
        .when()
            .delete(BASE_URL + "user/test123")
        .then()
            .assertThat()
            .statusCode(400)
            .body("error", equalTo("PARAMS_NOT_VALID"));
    }
}
