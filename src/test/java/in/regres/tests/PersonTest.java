package in.regres.tests;

import in.regres.api.CreatePersonApi;
import in.regres.api.DeletePersonApi;
import in.regres.api.UpdatePersonApi;
import in.regres.config.PersonConfig;
import in.regres.models.person.CreatePersonBodyModel;
import in.regres.models.person.CreatePersonResponseModel;
import in.regres.models.person.UpdatePersonBodyModel;
import in.regres.models.person.UpdatePersonResponseModel;
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
@Story("CRUD Операции с сотрудником")
public class PersonTest extends BaseTest {

    PersonConfig personConfig = ConfigFactory.create(PersonConfig.class);
    String createName = personConfig.createName();
    String createJob = personConfig.createJob();
    String updateName = personConfig.updateName();
    String updateJob = personConfig.updateJob();
    String oneMoreUpdateName = personConfig.oneMoreUpdateName();
    String oneMoreUpdateJob = personConfig.oneMoreUpdateJob();

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
            final CreatePersonResponseModel successfulCreatePersonResponse = createPersonApi.successCreatePerson(requestData);

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
            final CreatePersonResponseModel successfulCreatePersonWithoutNameResponse = createPersonApi.successCreatePerson(requestData);

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
            final CreatePersonResponseModel successfulCreatePersonWithoutJobResponse = createPersonApi.successCreatePerson(requestData);

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
            final UpdatePersonResponseModel successUpdatePersonPutResponse = updatePersonApi.successUpdatePersonPut(requestData);

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
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(oneMoreUpdateName, oneMoreUpdateJob);
            final UpdatePersonResponseModel successUpdatePersonPatchResponse = updatePersonApi.successUpdatePersonPatch(requestData);

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
