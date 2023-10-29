package in.regres.tests.asserts;

import in.regres.models.authorization.AuthorizationErrorModel;
import in.regres.models.authorization.AuthorizationResponseModel;
import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationsAsserts {

    @Description("Проверка успешной авторизации с Email, Password")
    public static void validateResponseWithToken(AuthorizationResponseModel authorizationResponseModel) {

        assertThat(authorizationResponseModel.getToken())
                .as("Значение полученного токена из ответа верное")
                .isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Description("Проверка неуспешной авторизации без Email")
    public static void validateResponseErrorWithoutEmail(AuthorizationErrorModel authorizationErrorModel) {

        assertThat(authorizationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("Missing email or username");
    }

    @Description("Проверка неуспешной авторизации без Password")
    public static void validateResponseErrorWithoutPassword(AuthorizationErrorModel authorizationErrorModel) {

        assertThat(authorizationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("Missing password");
    }

    @Description("Проверка неуспешной авторизации с неизвестными Email, Password")
    public static void validateResponseErrorWithUndefinedData(AuthorizationErrorModel authorizationErrorModel) {

        assertThat(authorizationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("user not found");
    }
}
