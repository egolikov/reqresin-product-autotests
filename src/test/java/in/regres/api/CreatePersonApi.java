package in.regres.api;

import in.regres.models.person.CreatePersonBodyModel;
import in.regres.models.person.CreatePersonResponseModel;
import in.regres.specs.CreatePersonSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class CreatePersonApi {

    @Description("Отправка запроса на создание сотрудника")
    public CreatePersonResponseModel successCreatePerson(CreatePersonBodyModel requestData) {
        return given()
                .spec(CreatePersonSpec.createPersonRequestSpec)
                .body(requestData)
                .when()
                .post("/users")
                .then()
                .spec(CreatePersonSpec.createPersonResponseSpec)
                .extract()
                .as(CreatePersonResponseModel.class);
    }
}
