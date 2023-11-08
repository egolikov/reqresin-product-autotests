package in.regres.tests;

import in.regres.api.AuthorizationApi;
import in.regres.config.AuthConfig;
import in.regres.models.authorization.AuthorizationBodyModel;
import in.regres.models.authorization.AuthorizationErrorModel;
import in.regres.models.authorization.AuthorizationResponseModel;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая функциональность приложения Reqres.in")
@Story("Авторизация")
public class AuthorizationTest extends BaseTest {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    String authEmail = authConfig.authEmail();
    String authPassword = authConfig.authPassword();
    String authUndefinedEmail = authConfig.authUndefinedEmail();
    String authUndefinedPassword = authConfig.authUndefinedPassword();

    protected AuthorizationApi authorizationApi = new AuthorizationApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка успешной авторизации с Email и Password")
    void successfulAuthorizationTest() {

        step("Выполнение успешной авторизации с Email и Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(authEmail, authPassword);
            AuthorizationResponseModel response = authorizationApi.successAuth(requestData);
            final AuthorizationResponseModel successfulAuthResponse = response;

            step("Проверка ответа с токеном на запрос об успешной Авторизации", () -> {
                assertThat(successfulAuthResponse.getToken())
                        .as("Значение полученного токена из ответа верное")
                        .isEqualTo("QpwL5tke4Pnpja7X4");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка неуспешной авторизации без Email")
    void authorizationWithOutEmailTest() {

        step("Выполнение неуспешной авторизации без Email", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(null, authPassword);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            final AuthorizationErrorModel errorAuthWithoutEmailResponse = response;

            step("Проверка ответа с ошибкой Авторизации", () -> {
                assertThat(errorAuthWithoutEmailResponse.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("Missing email or username");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка неуспешной авторизации без Password")
    void authorizationWithOutPasswordTest() {

        step("Выполнение неуспешной авторизации без Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(authEmail, null);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            final AuthorizationErrorModel errorAuthWithoutPasswordResponse = response;

            step("Проверка ответа с ошибкой Авторизации", () -> {
                assertThat(errorAuthWithoutPasswordResponse.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("Missing password");
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка неуспешной авторизации с данными неизвестного пользователя")
    void undefinedUserAuthorizationTest() {

        step("Выполнение неуспешной авторизации с данными неизвестного пользователя", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(authUndefinedEmail, authUndefinedPassword);
            AuthorizationErrorModel response = authorizationApi.errorAuth(requestData);
            final AuthorizationErrorModel errorAuthWithUndefinedData = response;

            step("Проверка ответа с ошибкой Авторизации", () -> {
                assertThat(errorAuthWithUndefinedData.getError())
                        .as("Верный текст с ошибкой в ответе")
                        .isEqualTo("user not found");
            });
        });
    }
}
