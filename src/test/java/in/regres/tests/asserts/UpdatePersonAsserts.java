package in.regres.tests.asserts;

import in.regres.models.updatePerson.UpdatePersonResponseModel;
import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdatePersonAsserts {

    @Description("Проверка успешного обновление сотрудника с методом PUT")
    public static void validateResponseUpdatePut(UpdatePersonResponseModel updatePersonResponseModel) {

        assertThat(updatePersonResponseModel.getName())
                .as("Значение полученного Name из ответа верное")
                .isEqualTo("mike");

        assertThat(updatePersonResponseModel.getJob())
                .as("Значение полученной Job из ответа верное")
                .isEqualTo("developer");

        assertThat(updatePersonResponseModel.getUpdatedAt())
                .as("Значение полученного UpdatedAt из ответа не пустое")
                .isNotNull();
    }

    @Description("Проверка успешного обновление сотрудника с методом PATCH")
    public static void validateResponseUpdatePatch(UpdatePersonResponseModel updatePersonResponseModel) {

        assertThat(updatePersonResponseModel.getName())
                .as("Значение полученного Name из ответа верное")
                .isEqualTo("oleg");

        assertThat(updatePersonResponseModel.getJob())
                .as("Значение полученной Job из ответа верное")
                .isEqualTo("designer");

        assertThat(updatePersonResponseModel.getUpdatedAt())
                .as("Значение полученного UpdatedAt из ответа не пустое")
                .isNotNull();
    }
}
