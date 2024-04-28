package api.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class UserAccountTest {
    public static String baseUrl = "https://dummyapi.io/data/v1/";
    public static String app_id = "662e2649bb70a7601b259395";
    public static String user_id = "60d0fe4f5311236168a109ca";
    Response response = null;
    JSONObject requestBody = new JSONObject();

   @Test
    public void updateUser(){
        // Menyiapkan body request
        requestBody.put("firstName", "Sarahahah");

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
        assertEquals("Sarahahah", response.jsonPath().get("firstName"));
    }
}
