package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    private static final String API_KEY_HEADER_NAME = "app-id";
    private static final String API_KEY_VALUE = "63a804408eb0cb069b57e43a";

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header(API_KEY_HEADER_NAME, API_KEY_VALUE);
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String firstName = "Bryan";
        String lastName = "Andika";
        String title = "mr";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("title", title);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalendpoint = endpoint.endsWith("/") ? endpoint + user_id : endpoint + "/" + user_id;
        return request.when().delete(finalendpoint);
    }


    public static Response updateUser(String endpoint, String user_id) {
        setupHeaders();

        String firstName = "Bryan";
        String lastName = "update";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("name", firstName);
        payload.put("gender", lastName);
        payload.put("email", email);

        String finalendpoint = endpoint + user_id;
        return request.body(payload.toString()).when().patch(finalendpoint);
    }

}
