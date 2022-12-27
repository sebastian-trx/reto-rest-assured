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

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PartialUpdateBookingStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(PartialUpdateBookingStepDefinition.class);

    private RequestSpecification request;

    private Response response;


    @Dado("que el usuario posee un token por estar registrado")// y la info a actualizar
    public void queElUsuarioPoseeUnTokenPorEstarRegistrado() {
        try{
            generalSetUp();
            request = given()
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .log()
                    .all()
                    .body("{\n" +
                            "   \"firstname\": \"sebas\", \n" +
                            "   \"lastname\": \"torres\"\n"+
                            "}");
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Cuando("el usuario actualiza los datos de la reserva")
    public void elUsuarioActualizaLosDatosDeLaReserva() {
        try{
            response = request.when()
                    .log()
                    .all()
                    .patch("/booking/9");
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }

    }

    @Entonces("en la respuesta del sistema se observa los datos que fueron actualizados")
    public void enLaRespuestaDelSistemaSeObservaLosDatosQueFueronActualizados() {
        try{
            response
                    .then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("firstname",equalTo("sebas"))
                    .body("lastname",equalTo("torres"));
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(),e);
        }
    }
}
