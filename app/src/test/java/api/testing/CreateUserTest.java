package api.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class CreateUserTest {
    public static String baseUrl = "https://dummyapi.io/data/v1/";
    public static String app_id = "662e2649bb70a7601b259395";
    
    // TC-02-10 : Mengisi field email dengan data yang sudah terdaftar di sistem
    @Test
    public void createUserWithEmailAlreadyRegistered(){
        // Menyiapkan data pengguna yang sudah terdaftar dalam sistem
        JSONObject existingUserData = new JSONObject();
        existingUserData.put("title", "mrs");
        existingUserData.put("firstName", "Alice");
        existingUserData.put("lastName", "Smith");
        existingUserData.put("picture", "https://randomuser.me/api/portraits/women/75.jpg");
        existingUserData.put("gender", "female");
        existingUserData.put("email", "john.doe@gmail.com");
        existingUserData.put("dateOfBirth", "1988-05-15T00:00:00.000Z");
        existingUserData.put("phone", "987654321");

        JSONObject location = new JSONObject();
        location.put("street", "456 Elm Street");
        location.put("city", "Sometown");
        location.put("state", "CA");
        location.put("country", "USA");
        location.put("timezone", "-8:00");
        
        existingUserData.put("location", location);

        // Menyiapkan body request dengan data pengguna yang sudah terdaftar di sistem
        JSONObject requestBody = existingUserData;

        // Mengirim permintaan POST untuk membuat pengguna baru
        Response response = given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            post(baseUrl + "user/create").
        then().
            log().body(). // Melihat response body
            extract().response();

        // Memeriksa apakah response sesuai dengan yang diharapkan
        assertEquals(400, response.getStatusCode());
        assertEquals("BODY_NOT_VALID", response.jsonPath().get("error"));
    }

    // TC-02-12 : Field lain terisi, kecuali firstName diisi kosong
    @Test
    public void createUserWithEmptyFirstName(){
        // Menyiapkan data pengguna dengan firstName kosong
        JSONObject userData = new JSONObject();
        userData.put("title", "mrs");
        userData.put("firstName", "");
        userData.put("lastName", "Smith");
        userData.put("picture", "https://randomuser.me/api/portraits/women/75.jpg");
        userData.put("gender", "female");
        userData.put("email", "alice.smith@gmail.com");
        userData.put("dateOfBirth", "1988-05-15T00:00:00.000Z");
        userData.put("phone", "987654321");

        JSONObject location = new JSONObject();
        location.put("street", "456 Elm Street");
        location.put("city", "Sometown");
        location.put("state", "CA");
        location.put("country", "USA");
        location.put("timezone", "-8:00");
        
        userData.put("location", location);

        // Menyiapkan body request dengan data pengguna
        JSONObject requestBody = userData;

        // Mengirim permintaan POST untuk membuat pengguna baru
        Response response = given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            post(baseUrl + "user/create").
        then().
            log().body(). // Melihat response body
            extract().response();

        // Memeriksa apakah response sesuai dengan yang diharapkan
        assertEquals(400, response.getStatusCode());
        assertEquals("BODY_NOT_VALID", response.jsonPath().get("error"));
    }

    // TC-02-13 : Field lain terisi, kecuali lastName diisi kosong
    @Test
    public void createUserWithEmptyLastName(){
    // Menyiapkan data pengguna dengan lastName kosong
    JSONObject userData = new JSONObject();
    userData.put("title", "mrs");
    userData.put("firstName", "Alice");
    userData.put("lastName", "");
    userData.put("picture", "https://randomuser.me/api/portraits/women/75.jpg");
    userData.put("gender", "female");
    userData.put("email", "alice.smith@gmail.com");
    userData.put("dateOfBirth", "1988-05-15T00:00:00.000Z");
    userData.put("phone", "987654321");

    JSONObject location = new JSONObject();
    location.put("street", "456 Elm Street");
    location.put("city", "Sometown");
    location.put("state", "CA");
    location.put("country", "USA");
    location.put("timezone", "-8:00");
    
    userData.put("location", location);

    // Menyiapkan body request dengan data pengguna
    JSONObject requestBody = userData;

    // Mengirim permintaan POST untuk membuat pengguna baru
    Response response = given().
        header("app-id", app_id).
        contentType("application/json").
        body(requestBody.toString()).
    when().
        post(baseUrl + "user/create").
    then().
        log().body(). // Melihat response body
        extract().response();

    // Memeriksa apakah response sesuai dengan yang diharapkan
    assertEquals(400, response.getStatusCode());
    assertEquals("BODY_NOT_VALID", response.jsonPath().get("error"));
}

    // TC-02-16 : Field lain terisi, kecuali email diisi kosong
    @Test
    public void createUserWithEmptyEmail(){
    // Menyiapkan data pengguna dengan email kosong
    JSONObject userData = new JSONObject();
    userData.put("title", "mrs");
    userData.put("firstName", "Alice");
    userData.put("lastName", "Smith");
    userData.put("picture", "https://randomuser.me/api/portraits/women/75.jpg");
    userData.put("gender", "female");
    userData.put("email", "");
    userData.put("dateOfBirth", "1988-05-15T00:00:00.000Z");
    userData.put("phone", "987654321");

    JSONObject location = new JSONObject();
    location.put("street", "456 Elm Street");
    location.put("city", "Sometown");
    location.put("state", "CA");
    location.put("country", "USA");
    location.put("timezone", "-8:00");
    
    userData.put("location", location);

    // Menyiapkan body request dengan data pengguna
    JSONObject requestBody = userData;

    // Mengirim permintaan POST untuk membuat pengguna baru
    Response response = given().
        header("app-id", app_id).
        contentType("application/json").
        body(requestBody.toString()).
    when().
        post(baseUrl + "user/create").
    then().
        log().body(). // Melihat response body
        extract().response();

    // Memeriksa apakah response sesuai dengan yang diharapkan
    assertEquals(400, response.getStatusCode());
    assertEquals("BODY_NOT_VALID", response.jsonPath().get("error"));
}

    // TC-02-30 : Field lain benar, format email invalid (tanpa menggunakan @)
    @Test
    public void createUserWithInvalidEmailFormat(){
        // Menyiapkan data pengguna dengan format email invalid (tanpa @)
        JSONObject userData = new JSONObject();
        userData.put("title", "mrs");
        userData.put("firstName", "Alice");
        userData.put("lastName", "Smith");
        userData.put("picture", "https://randomuser.me/api/portraits/women/75.jpg");
        userData.put("gender", "female");
        userData.put("email", "alice.smithgmail.com");
        userData.put("dateOfBirth", "1988-05-15T00:00:00.000Z");
        userData.put("phone", "987654321");

        JSONObject location = new JSONObject();
        location.put("street", "456 Elm Street");
        location.put("city", "Sometown");
        location.put("state", "CA");
        location.put("country", "USA");
        location.put("timezone", "-8:00");
        
        userData.put("location", location);

        // Menyiapkan body request dengan data pengguna
        JSONObject requestBody = userData;

        // Mengirim permintaan POST untuk membuat pengguna baru
        Response response = given().
            header("app-id", app_id).
            contentType("application/json").
            body(requestBody.toString()).
        when().
            post(baseUrl + "user/create").
        then().
            log().body(). // Melihat response body
            extract().response();

        // Memeriksa apakah response sesuai dengan yang diharapkan
        assertEquals(400, response.getStatusCode());
        assertEquals("BODY_NOT_VALID", response.jsonPath().get("error"));
    }
}
