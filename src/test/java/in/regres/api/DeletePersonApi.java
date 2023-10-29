package in.regres.api;

import io.qameta.allure.Description;

import static in.regres.specs.DeletePersonSpec.deletePersonRequestSpec;
import static in.regres.specs.DeletePersonSpec.deletePersonResponseSpec;
import static io.restassured.RestAssured.given;

public class DeletePersonApi {

    @Description("Удаление сотрудника")
    public void deletePerson() {
        given()
                .spec(deletePersonRequestSpec)
                .delete("/users/2")
                .then()
                .spec(deletePersonResponseSpec);
    }
}