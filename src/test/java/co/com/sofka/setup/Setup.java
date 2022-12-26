package co.com.sofka.setup;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Setup {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BASE_PATH = "/auth";

    //protected static final String RESOURCE = "/login";

    protected void generalSetUp(){
        configurationForRestAssured();
    }

    public void configurationForRestAssured(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
