package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    public static String setURL, global_id;
    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
//            case "GET_USER_BY_ID":
//                setURL = Endpoint.GET_USER_BY_ID;
//                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            default:
                System.out.println("input exact url");
        }
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitApiPostCreateUser(){
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers(){
//        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
//        List<Object> picture = res.jsonPath().getList("data.picture");
        List<Object> title = res.jsonPath().getList("data.title");

//        assertThat(id.get(0)).isNotNull();
        assertThat(firstName.get(0)).isNotNull();
        assertThat(lastName.get(0)).isNotNull();
//        assertThat(picture.get(0)).isNotNull();
        assertThat(title.get(0)).isIn("mr", "ms", "miss", "mrs");
    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResposeBodyPostCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String title = jsonPathEvaluator.get("title");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(title).isIn("mr", "ms", "miss", "mrs");

        global_id = (id);
    }

    public void hitApiDeleteUser(){
        res = deleteUser(setURL,global_id);
        System.out.println("DEBUG DELETE URL: " + Endpoint.DELETE_USERS + global_id);
    }

    public void hitUpdateNewUser(){
        res = updateUser(setURL, global_id);
    }

    public void validationResponseBodyUpdateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String title = jsonPathEvaluator.get("title");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(title).isIn("mr", "ms", "miss", "mrs");
    }
}