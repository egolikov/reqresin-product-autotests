package in.regres.tests;

import in.regres.api.CreatePersonApi;
import in.regres.api.DeletePersonApi;
import in.regres.api.UpdatePersonApi;
import in.regres.models.createPerson.CreatePersonBodyModel;
import in.regres.models.createPerson.CreatePersonResponseModel;
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
@Story("CRUD Операции с сотрудником")
public class PersonTest {

    private final String createName = TestData.CREATE_NAME;
    private final String createJob = TestData.CREATE_JOB;
    private final String updateName = TestData.UPDATE_NAME;
    private final String updateJob = TestData.UPDATE_JOB;
    private final String nameO = TestData.ONE_MORE_UPDATE_NAME;
    private final String jobO = TestData.ONE_MORE_UPDATE_JOB;

    protected CreatePersonApi createPersonApi = new CreatePersonApi();
    protected DeletePersonApi deletePersonApi = new DeletePersonApi();
    protected UpdatePersonApi updatePersonApi = new UpdatePersonApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("CreatePerson")
    @DisplayName("Проверка успешного создания сотрудника с Name и Job")
    void successfulCreatePersonTest() {

        step("Выполнение успешного создания сотрудника с Name и Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(createName, createJob);
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
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(null, createJob);
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
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(createName, null);
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

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("DeletePerson")
    @DisplayName("Проверка успешного удаления сотрудника")
    void successfulDeletePersonTest() {

        step("Отправка запроса на успешное удаление сотрудника", () -> deletePersonApi.deletePerson());
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("UpdatePerson")
    @DisplayName("Проверка успешного обновления данных пользователя через метод PUT")
    void successfulUpdatePersonWithPutMethodTest() {

        step("Отправка запроса на обновление данных пользователя", () -> {
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(updateName, updateJob);
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