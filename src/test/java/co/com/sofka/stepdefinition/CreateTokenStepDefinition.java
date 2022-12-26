package co.com.sofka.stepdefinition;

import co.com.sofka.setup.Setup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateTokenStepDefinition extends Setup {

    private RequestSpecification request;

    private Response response;

    @Dado("que el usuario posee un username: {string} y password: {string}")
    public void queElUsuarioUsernameYPassword(String username, String password) {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all()
                    .body("{\n" +
                    "   \"username\": \"admin\", \n" +
                    "   \"password\": \"password123\"\n"+
                    "}");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            //logger...
            System.out.println(e.getMessage());
        }
    }

    @Cuando("el usuario realiza una peticion para crear un token de autorizacion")
    public void elUsuarioRealizaUnaPeticionParaCrearUnTokenDeAutorizacion() {
        try{
            response = request.when()
                    .log()
                    .all()
                    .post();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            //logger
        }

    }

    @Entonces("el sistema responde con un status code exitoso y un token de autorizacion")
    public void elSistemaRespondeConUnStatusCodeExitosoYUnTokenDeAutorizacion() {
        try{
            response
                    .then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token",notNullValue());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            //logger
        }
    }
}


