package in.regres.tests;

import in.regres.api.CreatePersonApi;
import in.regres.models.createPerson.CreatePersonBodyModel;
import in.regres.models.createPerson.CreatePersonResponseModel;
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
@Story("Создание сотрудника")
public class CreatePersonTest {

    private final String name = TestData.CREATE_NAME;
    private final String job = TestData.CREATE_JOB;

    protected CreatePersonApi createPersonApi = new CreatePersonApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("CreatePerson")
    @DisplayName("Проверка успешного создания сотрудника с Name и Job")
    void successfulCreatePersonTest() {

        step("Выполнение успешного создания сотрудника с Name и Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(name, job);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            final CreatePersonResponseModel successfulCreatePersonResponse = response;

            step("Проверка ответа на запрос об успешном создании сотрудника с Name и Job", () -> {
                assertThat(successfulCreatePersonResponse.getName())
                        .as("Значение полученного Name из ответа верное")
                        .isEqualTo("morpheus");

                assertThat(successfulCreatePersonResponse.getJob())
                        .as("Значение полученной Job из ответа верное")
                        .isEqualTo("leader");

                assertThat(successfulCreatePersonResponse.getId())
                        .as("Значение полученного ID из ответа не пустое")
                        .isNotNull();

                assertThat(successfulCreatePersonResponse.getCreatedAt())
                        .as("Значение полученного CreatedAt из ответа не пустое")
                        .isNotNull();
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("CreatePerson")
    @DisplayName("Проверка успешного создания сотрудника без Name")
    void successfulCreatePersonWithoutName() {

        step("Выполнение успешного создания сотрудника без Name", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(null, job);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            final CreatePersonResponseModel successfulCreatePersonWithoutNameResponse = response;

            step("Проверка ответа на запрос об успешном создании сотрудника без Name", () -> {
                assertThat(successfulCreatePersonWithoutNameResponse.getName())
                        .as("Значение полученного Name из ответа пустое")
                        .isNull();

                assertThat(successfulCreatePersonWithoutNameResponse.getJob())
                        .as("Значение полученной Job из ответа верное")
                        .isEqualTo("leader");

                assertThat(successfulCreatePersonWithoutNameResponse.getId())
                        .as("Значение полученного ID из ответа не пустое")
                        .isNotNull();

                assertThat(successfulCreatePersonWithoutNameResponse.getCreatedAt())
                        .as("Значение полученного CreatedAt из ответа не пустое")
                        .isNotNull();
            });
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("CreatePerson")
    @DisplayName("Проверка успешного создания сотрудника без Job")
    void successfulCreatePersonWithoutJob() {

        step("Выполнение успешного создания сотрудника без Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(name, null);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            final CreatePersonResponseModel successfulCreatePersonWithoutJobResponse = response;

            step("Проверка ответа на запрос об успешном создании сотрудника без Job", () -> {
                assertThat(successfulCreatePersonWithoutJobResponse.getName())
                        .as("Значение полученного Name из ответа верное")
                        .isEqualTo("morpheus");

                assertThat(successfulCreatePersonWithoutJobResponse.getJob())
                        .as("Значение полученной Job из ответа пустое")
                        .isNull();

                assertThat(successfulCreatePersonWithoutJobResponse.getId())
                        .as("Значение полученного ID из ответа не пустое")
                        .isNotNull();

                assertThat(successfulCreatePersonWithoutJobResponse.getCreatedAt())
                        .as("Значение полученного CreatedAt из ответа не пустое")
                        .isNotNull();
            });
        });
    }
}
