package in.regres.tests.asserts;

import in.regres.models.registration.RegistrationErrorModel;
import in.regres.models.registration.RegistrationResponseModel;
import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationAsserts {

    @Description("Проверка успешной регистрации с Email, Password")
    public static void validateResponseWithToken(RegistrationResponseModel registrationResponseModel) {

        assertThat(registrationResponseModel.getId())
                .as("Значение полученного ID из ответа верное")
                .isEqualTo(4);

        assertThat(registrationResponseModel.getToken())
                .as("Значение полученного токена из ответа верное")
                .isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Description("Проверка неуспешной регистрации без Email")
    public static void validateResponseErrorWithoutEmail(RegistrationErrorModel registrationErrorModel) {

        assertThat(registrationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("Missing email or username");
    }

    @Description("Проверка неуспешной регистрации без Password")
    public static void validateResponseErrorWithoutPassword(RegistrationErrorModel registrationErrorModel) {

        assertThat(registrationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("Missing password");
    }

    @Description("Проверка неуспешной регистрации с неизвестными Email, Password")
    public static void validateResponseErrorWithUndefinedData(RegistrationErrorModel registrationErrorModel) {

        assertThat(registrationErrorModel.getError())
                .as("Верный текст с ошибкой в ответе")
                .isEqualTo("Note: Only defined users succeed registration");
    }
}
