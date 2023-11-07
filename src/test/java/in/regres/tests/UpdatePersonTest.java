package in.regres.tests;

import in.regres.api.UpdatePersonApi;
import in.regres.models.updatePerson.UpdatePersonBodyModel;
import in.regres.models.updatePerson.UpdatePersonResponseModel;
import in.regres.tests.data.TestData;
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
@Story("Обновление сотрудников")
public class UpdatePersonTest {

    private final String name = TestData.UPDATE_NAME;
    private final String job = TestData.UPDATE_JOB;
    private final String nameO = TestData.ONE_MORE_UPDATE_NAME;
    private final String jobO = TestData.ONE_MORE_UPDATE_JOB;

    protected UpdatePersonApi updatePersonApi = new UpdatePersonApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("UpdatePerson")
    @DisplayName("Проверка успешного обновления данных пользователя через метод PUT")
    void successfulUpdatePersonWithPutMethodTest() {

        step("Отправка запроса на обновление данных пользователя", () -> {
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(name, job);
            UpdatePersonResponseModel response = updatePersonApi.successUpdatePersonPut(requestData);
            final UpdatePersonResponseModel successUpdatePersonPutResponse = response;

            step("Проверка ответа на запрос об успешном обновлении сотрудника с методом PUT", () -> {
                assertThat(successUpdatePersonPutResponse.getName())
                        .as("Значение полученного Name из ответа верное")
                        .isEqualTo("mike");

                assertThat(successUpdatePersonPutResponse.getJob())
                        .as("Значение полученной Job из ответа верное")
                        .isEqualTo("developer");

                assertThat(successUpdatePersonPutResponse.getUpdatedAt())
                        .as("Значение полученного UpdatedAt из ответа не пустое")
                        .isNotNull();
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("UpdatePerson")
    @DisplayName("Проверка успешного обновления данных пользователя через метод PATCH")
    void successfulUpdatePersonWithPatchMethodTest() {

        step("Отправка запроса на обновление данных пользователя", () -> {
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(nameO, jobO);
            UpdatePersonResponseModel response = updatePersonApi.successUpdatePersonPatch(requestData);
            final UpdatePersonResponseModel successUpdatePersonPatchResponse = response;

            step("Проверка ответа на запрос об успешном обновлении сотрудника с методом PATCH", () -> {
                assertThat(successUpdatePersonPatchResponse.getName())
                        .as("Значение полученного Name из ответа верное")
                        .isEqualTo("oleg");

                assertThat(successUpdatePersonPatchResponse.getJob())
                        .as("Значение полученной Job из ответа верное")
                        .isEqualTo("designer");

                assertThat(successUpdatePersonPatchResponse.getUpdatedAt())
                        .as("Значение полученного UpdatedAt из ответа не пустое")
                        .isNotNull();
            });
        });
    }
}
