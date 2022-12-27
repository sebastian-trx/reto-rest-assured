package co.com.sofka.setup;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.log4j.PropertyConfigurator;

public class Setup {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";

    protected void generalSetUp(){
        configurationForRestAssured();
        setUpLog4j();
    }

    public void configurationForRestAssured(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    protected void setUpLog4j(){
        PropertyConfigurator.configure(Setup.class.getClassLoader().getResource("log4j.properties"));
    }
}
