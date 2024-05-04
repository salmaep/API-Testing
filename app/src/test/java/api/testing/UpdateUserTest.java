package api.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest {
    public static String baseUrl = "https://dummyapi.io/data/v1/";
    public static String app_id = "662e2649bb70a7601b259395";
    public static String user_id = "662e28f41846fb66ccd50ad7";
    public static String invalid_user_id = "662e28f41846fb";
    Response response = null;
    JSONObject requestBody = new JSONObject();

   @Test
    public void updateUserTitleMr(){
        // Menyiapkan body request
        requestBody.put("title", "mr");

        // Mengirim permintaan PUT
        response = given().
            header("app-id", app_id). // Menambahkan header app-id
            contentType("application/json").
            body(requestBody.toString()). // Menggunakan body request sebagai JSON string
        when().
            put(baseUrl + "user/" + user_id).
        then().
            assertThat().
            statusCode(200). // Memeriksa status code
            log().body(). // Melihat response body
            extract().response();

        // Memeriksa bahwa response body sesuai dengan yang diharapkan
        assertEquals("mr", response.jsonPath().get("title"));
    }

    @Test
    public void updateUserFirstName(){
        // Menyiapkan body request
        requestBody.put("firstName", "Salma");

        // Mengirim permintaan PUT
        response = given().
            header("app-id", app_id). // Menambahkan header app-id
            contentType("application/json").
            body(requestBody.toString()). // Menggunakan body request sebagai JSON string
        when().
            put(baseUrl + "user/" + user_id).
        then().
            assertThat().
            statusCode(200). // Memeriksa status code
            log().body(). // Melihat response body
            extract().response();

        // Memeriksa bahwa response body sesuai dengan yang diharapkan
        assertEquals("Salma", response.jsonPath().get("firstName"));
    }

    @Test
    public void updateUserLocationCountry() {
        // Prepare the request body with updated country
        JSONObject location = new JSONObject();
        location.put("street", "961400, SÃ¸ndermarksvej");
        location.put("city", "BesanÃ§on");
        location.put("state", "Seine-et-Marne");
        location.put("country", "Indonesia"); // Updated country
        location.put("timezone", "+9:00");

        requestBody.put("location", location);

        // Send the PUT request
        response = given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            put(baseUrl + "user/" + user_id).
        then().
            assertThat().
            statusCode(200). // Expecting status code 200 for successful update
            log().body(). // View response body
            extract().response();

        // Check if the response body matches the expected updated country
        assertEquals("Indonesia", response.jsonPath().get("location.country"));
    }
    
    @Test
    public void testInvalidIdParameter() {
        // Prepare the request body with the field to be updated and its value
        requestBody.put("phone", "9782738267");

        // Send the PUT request with invalid ID parameter
        given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            put(baseUrl + "user/" + invalid_user_id).
        then().
            assertThat().
            statusCode(400). // Expecting status code 400 for bad request
            body("error", equalTo("PARAMS_NOT_VALID")); // Verify error message
    }

    @Test
    public void testInvalidPathParameter() {
        // Prepare the request body with the field to be updated and its value
        requestBody.put("phone", "9782738267");

        // Send the PUT request with invalid ID parameter
        given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            put(baseUrl + "users/" + user_id). // Invalid Path parameter
        then().
            assertThat().
            statusCode(404). // Expecting status code 404 for not found
            body("error", equalTo("PATH_NOT_FOUND")); // Verify error message
    }
}
