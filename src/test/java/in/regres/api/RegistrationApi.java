package in.regres.api;

import in.regres.models.registration.RegistrationBodyModel;
import in.regres.models.registration.RegistrationErrorModel;
import in.regres.models.registration.RegistrationResponseModel;
import in.regres.specs.RegistrationSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class RegistrationApi {

    @Description("Отправка запроса на Регистрацию")
    public RegistrationResponseModel successRegistration(RegistrationBodyModel requestData) {
        return given()
                .spec(RegistrationSpec.registrationRequestSpec)
                .body(requestData)
                .when()
                .post("/register")
                .then()
                .spec(RegistrationSpec.registrationResponseSpec)
                .extract()
                .as(RegistrationResponseModel.class);
    }

    @Description("Отправка запроса с ошибкой на Регистрацию")
    public RegistrationErrorModel errorRegistration(RegistrationBodyModel requestData) {
        return given()
                .spec(RegistrationSpec.registrationRequestSpec)
                .body(requestData)
                .when()
                .post("/register")
                .then()
                .spec(RegistrationSpec.errorRegistrationResponseSpec)
                .extract()
                .as(RegistrationErrorModel.class);
    }
}
