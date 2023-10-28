package in.regres.api;

import com.google.gson.Gson;
import in.regres.models.authorization.AuthorizationBodyModel;
import in.regres.models.authorization.AuthorizationErrorModel;
import in.regres.models.authorization.AuthorizationResponseModel;
import in.regres.specs.AuthorizationSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    @Description("Отправка запроса на Авторизацию")
    public AuthorizationResponseModel successAuth(AuthorizationBodyModel requestData) {
        return given()
                .spec(AuthorizationSpec.authorizationRequestSpec)
                .body(new Gson().toJson(requestData))
                .when()
                .post("/login")
                .then()
                .spec(AuthorizationSpec.authorizationResponseSpec)
                .extract()
                .as(AuthorizationResponseModel.class);
    }

    @Description("Отправка запроса с ошибкой на Авторизацию")
    public AuthorizationErrorModel errorAuth(AuthorizationBodyModel requestData) {
        return given()
                .spec(AuthorizationSpec.authorizationRequestSpec)
                .body(new Gson().toJson(requestData))
                .when()
                .post("/login")
                .then()
                .spec(AuthorizationSpec.errorAuthorizationResponseSpec)
                .extract()
                .as(AuthorizationErrorModel.class);
    }
}

