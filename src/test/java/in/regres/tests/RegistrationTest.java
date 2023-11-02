package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.RegistrationApi;
import in.regres.models.registration.RegistrationBodyModel;
import in.regres.models.registration.RegistrationErrorModel;
import in.regres.models.registration.RegistrationResponseModel;
import in.regres.tests.asserts.RegistrationAsserts;
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
@Story("Регистрация")
public class RegistrationTest {

    private final String email = TestData.REG_EMAIL;
    private final String password = TestData.REG_PASSWORD;
    private final String undefinedEmail = TestData.REG_UNDEFINED_EMAIL;
    private final String undefinedPassword = TestData.REG_UNDEFINED_PASSWORD;

    protected RegistrationApi registrationApi = new RegistrationApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка успешной регистрации с Email и Password")
    void successfulRegistrationTest() {

        step("Отправка запроса на регистрацию с корретным Email и Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(email, password);
            RegistrationResponseModel response = registrationApi.successRegistration(requestData);
            System.setProperty("successfulRegistrationResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с токеном на запрос об успешной Регистрации", () -> {
            String responseJson = System.getProperty("successfulRegistrationResponse");
            RegistrationResponseModel response = new Gson().fromJson(responseJson, RegistrationResponseModel.class);
            RegistrationAsserts.validateResponseWithToken(response);
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Email")
    void registrationWithOutEmailTest() {

        step("Отправка запроса на регистрацию без Email", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(null, password);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            System.setProperty("errorRegWithoutEmailResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            String responseJson = System.getProperty("errorRegWithoutEmailResponse");
            RegistrationErrorModel response = new Gson().fromJson(responseJson, RegistrationErrorModel.class);
            RegistrationAsserts.validateResponseErrorWithoutEmail(response);
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Password")
    void registrationWithOutPasswordTest() {

        step("Отправка запроса на регистрацию без Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(email, null);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            System.setProperty("errorRegWithoutPasswordResponse", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            String responseJson = System.getProperty("errorRegWithoutPasswordResponse");
            RegistrationErrorModel response = new Gson().fromJson(responseJson, RegistrationErrorModel.class);
            RegistrationAsserts.validateResponseErrorWithoutPassword(response);
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации с данными неизвестного пользователя")
    void undefinedUserRegistrationTest() {

        step("Отправка запроса на Регистрацию с неизвестным пользователем", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(undefinedEmail, undefinedPassword);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            System.setProperty("errorRegWithUndefinedData", new Gson().toJson(response));
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            String responseJson = System.getProperty("errorRegWithUndefinedData");
            RegistrationErrorModel response = new Gson().fromJson(responseJson, RegistrationErrorModel.class);
            RegistrationAsserts.validateResponseErrorWithUndefinedData(response);
        });
    }
}
