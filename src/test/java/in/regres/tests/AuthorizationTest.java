package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.AuthorizationApi;
import in.regres.models.authorization.AuthorizationBodyModel;
import in.regres.models.authorization.AuthorizationErrorModel;
import in.regres.models.authorization.AuthorizationResponseModel;
import in.regres.tests.asserts.AuthorizationsAsserts;
import in.regres.tests.data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая фунциональность приложения Reqres.in")
@Story("Авторизация")
public class AuthorizationTest {

    private final String email = TestData.AUTH_EMAIL;
    private final String password = TestData.AUTH_PASSWORD;
    private final String undefinedEmail = TestData.AUTH_UNDEFINED_EMAIL;
    private final String undefinedPassword = TestData.AUTH_UNDEFINED_PASSWORD;

    protected AuthorizationApi authorizationApi = new AuthorizationApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
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

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
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

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
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

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка неуспешной авторизации с данными неизвестного пользователя")
    void undefinedUserAuthorizationTest() {

        step("Отправка запроса на Авторизацию с неизвестным пользователем", () -> {
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