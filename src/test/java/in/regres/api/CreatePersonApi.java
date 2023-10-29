package in.regres.api;

import com.google.gson.Gson;
import in.regres.models.createPerson.CreatePersonBodyModel;
import in.regres.models.createPerson.CreatePersonResponseModel;
import in.regres.specs.CreatePersonSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class CreatePersonApi {

    @Description("Отправка запроса на создание сотрудника")
    public CreatePersonResponseModel successCreatePerson(CreatePersonBodyModel requestData) {
        return given()
                .spec(CreatePersonSpec.createPersonRequestSpec)
                .body(new Gson().toJson(requestData))
                .when()
                .post("/users")
                .then()
                .spec(CreatePersonSpec.createPersonResponseSpec)
                .extract()
                .as(CreatePersonResponseModel.class);
    }
}
