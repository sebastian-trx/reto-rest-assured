package co.com.sofka.stepdefinition;

import co.com.sofka.setup.Setup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.CoreMatchers.notNullValue;
import static io.restassured.RestAssured.given;

public class GetSpecificBookingByIdStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(GetSpecificBookingByIdStepDefinition.class);

    private RequestSpecification request;

    private Response response;
    @Dado("que el usuario posee un id de una reserva existente")
    public void queElUsuarioPoseeUnIdDeUnaReservaExistente() {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all();
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Cuando("el usuario realiza una peticion para obtener la informacion de una reserva id = {int}")
    public void elUsuarioRealizaUnaPeticionParaObtenerLaInformacionDeUnaReservaId(int id) {
        try{
            response = request.when()
                    .log()
                    .all()
                    .get("/booking/{id}",id);
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Entonces("el sistema responde con un status code exitoso y la informacion de la reserva en formato JSON")
    public void elSistemaRespondeConUnStatusCodeExitosoYLaInformacionDeLaReservaEnFormatoJSON() {
        try{
            response
                    .then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("firstname", notNullValue())
                    .body("lastname", notNullValue())
                    .body("totalprice", notNullValue())
                    .body("depositpaid", notNullValue())
                    .body("bookingdates", notNullValue());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }
    }


}
