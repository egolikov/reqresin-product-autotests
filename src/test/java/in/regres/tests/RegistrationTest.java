package in.regres.tests;

import in.regres.api.RegistrationApi;
import in.regres.models.registration.RegistrationBodyModel;
import in.regres.models.registration.RegistrationErrorModel;
import in.regres.models.registration.RegistrationResponseModel;
import in.regres.data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая фунциональность приложения Reqres.in")
@Story("Регистрация")
public class RegistrationTest extends BaseTest {

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

        step("Выполнение успешной регистрации с Email и Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(email, password);
            RegistrationResponseModel response = registrationApi.successRegistration(requestData);
            final RegistrationResponseModel successfulRegistrationResponse = response;

            step("Проверка ответа с токеном на запрос об успешной Регистрации", () -> {
                assertThat(successfulRegistrationResponse.getId())
                        .as("Значение полученного ID из ответа верное")
                        .isEqualTo(4);

                assertThat(successfulRegistrationResponse.getToken())
                        .as("Значение полученного токена из ответа верное")
                        .isEqualTo("QpwL5tke4Pnpja7X4");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Email")
    void registrationWithOutEmailTest() {

        step("Выполнение неуспешной регистрации без Email", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(null, password);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            final RegistrationErrorModel errorRegWithoutEmailResponse = response;

            step("Проверка ответа с ошибкой Регистрации", () -> {
                assertThat(errorRegWithoutEmailResponse.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("Missing email or username");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Password")
    void registrationWithOutPasswordTest() {

        step("Выполнение неуспешной регистрации без Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(email, null);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            final RegistrationErrorModel errorRegWithoutPasswordResponse = response;

            step("Проверка ответа с ошибкой Регистрации", () -> {
                assertThat(errorRegWithoutPasswordResponse.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("Missing password");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации с данными неизвестного пользователя")
    void undefinedUserRegistrationTest() {

        step("Выполнение неуспешной регистрации с данными неизвестного пользователя", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(undefinedEmail, undefinedPassword);
            RegistrationErrorModel response = registrationApi.errorRegistration(requestData);
            final RegistrationErrorModel errorRegWithUndefinedData = response;

            step("Проверка ответа с ошибкой Регистрации", () -> {
                assertThat(errorRegWithUndefinedData.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("Note: Only defined users succeed registration");
            });
        });
    }
}
