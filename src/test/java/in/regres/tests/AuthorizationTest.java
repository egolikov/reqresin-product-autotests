package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.AuthorizationApi;
import in.regres.models.authorization.AuthorizationBodyModel;
import in.regres.models.authorization.AuthorizationErrorModel;
import in.regres.models.authorization.AuthorizationResponseModel;
import in.regres.tests.asserts.AuthorizationsAsserts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthorizationTest {

    AuthorizationApi authorizationApi = new AuthorizationApi();


    String email = "eve.holt@reqres.in";
    String password = "cityslicka";
    String undefinedEmail = "egolikov@gmail.com";
    String undefinedPassword = "gogogo";

    @Test
    @DisplayName("Проверка успешной авторизации с Email и Password")
    void successfulAuthorizationTest() {

        step("Отправка запроса на авторизацию с корретным Email и Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(email, password);
            AuthorizationResponseModel response = authorizationApi.successAuth(requestData);
            System.setProperty("successfulAuthResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с токеном на запрос об успешной Авторизации", () -> {
            String responseJson = System.getProperty("successfulAuthResponse");
            AuthorizationResponseModel response = new Gson().fromJson(responseJson, AuthorizationResponseModel.class);
            AuthorizationsAsserts.validateResponseWithToken(response);
        });
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации без Email")
    void authorizationWithOutEmailTest() {

        step("Отправка запроса на авторизацию без Email", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(null, password);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            System.setProperty("errorAuthWithoutEmailResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Авторизации", () -> {
            String responseJson = System.getProperty("errorAuthWithoutEmailResponse");
            AuthorizationErrorModel response = new Gson().fromJson(responseJson, AuthorizationErrorModel.class);
            AuthorizationsAsserts.validateResponseErrorWithoutEmail(response);
        });
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации без Password")
    void authorizationWithOutPasswordTest() {

        step("Отправка запроса на авторизацию без Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(email, null);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            System.setProperty("errorAuthWithoutPasswordResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Авторизации", () -> {
            String responseJson = System.getProperty("errorAuthWithoutPasswordResponse");
            AuthorizationErrorModel response = new Gson().fromJson(responseJson, AuthorizationErrorModel.class);
            AuthorizationsAsserts.validateResponseErrorWithoutPassword(response);
        });
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации с данными неизвестного пользователя")
    void undefinedUserAuthorizationTest() {

        step("Отправка запроса на авторизацию без Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(undefinedEmail, undefinedPassword);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            System.setProperty("errorAuthWithUndefinedData", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Авторизации", () -> {
            String responseJson = System.getProperty("errorAuthWithUndefinedData");
            AuthorizationErrorModel response = new Gson().fromJson(responseJson, AuthorizationErrorModel.class);
            AuthorizationsAsserts.validateResponseErrorWithUndefinedData(response);
        });
    }
}