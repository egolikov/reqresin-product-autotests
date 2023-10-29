package in.regres.tests.asserts;

import in.regres.models.createPerson.CreatePersonResponseModel;
import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePersonAsserts {

    @Description("Проверка успешного создания сотрудника с Name и Job")
    public static void validateResponseWithNameAndJob(CreatePersonResponseModel createPersonResponseModel) {

        assertThat(createPersonResponseModel.getName())
                .as("Значение полученного Name из ответа верное")
                .isEqualTo("morpheus");

        assertThat(createPersonResponseModel.getJob())
                .as("Значение полученной Job из ответа верное")
                .isEqualTo("leader");

        assertThat(createPersonResponseModel.getId())
                .as("Значение полученного ID из ответа не пустое")
                .isNotNull();

        assertThat(createPersonResponseModel.getCreatedAt())
                .as("Значение полученного CreatedAt из ответа не пустое")
                .isNotNull();
    }

    @Description("Проверка успешного создания сотрудника без Name")
    public static void validateResponseWithoutName(CreatePersonResponseModel createPersonResponseModel) {

        assertThat(createPersonResponseModel.getName())
                .as("Значение полученного Name из ответа пустое")
                .isNull();

        assertThat(createPersonResponseModel.getJob())
                .as("Значение полученной Job из ответа верное")
                .isEqualTo("leader");

        assertThat(createPersonResponseModel.getId())
                .as("Значение полученного ID из ответа не пустое")
                .isNotNull();

        assertThat(createPersonResponseModel.getCreatedAt())
                .as("Значение полученного CreatedAt из ответа не пустое")
                .isNotNull();
    }

    @Description("Проверка успешного создания сотрудника без Name")
    public static void validateResponseWithoutJob(CreatePersonResponseModel createPersonResponseModel) {

        assertThat(createPersonResponseModel.getName())
                .as("Значение полученного Name из ответа верное")
                .isEqualTo("morpheus");

        assertThat(createPersonResponseModel.getJob())
                .as("Значение полученной Job из ответа пустое")
                .isNull();

        assertThat(createPersonResponseModel.getId())
                .as("Значение полученного ID из ответа не пустое")
                .isNotNull();

        assertThat(createPersonResponseModel.getCreatedAt())
                .as("Значение полученного CreatedAt из ответа не пустое")
                .isNotNull();
    }
}
