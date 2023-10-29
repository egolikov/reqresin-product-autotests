package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.CreatePersonApi;
import in.regres.models.createPerson.CreatePersonBodyModel;
import in.regres.models.createPerson.CreatePersonResponseModel;
import in.regres.tests.asserts.CreatePersonAsserts;
import in.regres.tests.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CreatePersonTest {

    String name = TestData.CREATE_NAME;
    String job = TestData.CREATE_JOB;

    CreatePersonApi createPersonApi = new CreatePersonApi();

    @Test
    @DisplayName("Проверка успешного создания сотрудника с Name и Job")
    void successfulCreatePersonTest() {

        step("Отправка запроса на создание сотрудника с Name и Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(name, job);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            System.setProperty("successfulCreatePersonResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос об успешном создании сотрудника с Name и Job", () -> {
            String responseJson = System.getProperty("successfulCreatePersonResponse");
            CreatePersonResponseModel response = new Gson().fromJson(responseJson, CreatePersonResponseModel.class);
            CreatePersonAsserts.validateResponseWithNameAndJob(response);
        });
    }

    @Test
    @DisplayName("Проверка успешного создания сотрудника без Name")
    void successfulCreatePersonWithoutName() {

        step("Отправка запроса на создание сотрудника без Name", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(null, job);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            System.setProperty("successfulCreatePersonWithoutNameResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос об успешном создании сотрудника без Name", () -> {
            String responseJson = System.getProperty("successfulCreatePersonWithoutNameResponse");
            CreatePersonResponseModel response = new Gson().fromJson(responseJson, CreatePersonResponseModel.class);
            CreatePersonAsserts.validateResponseWithoutName(response);
        });
    }

    @Test
    @DisplayName("Проверка успешного создания сотрудника без Job")
    void successfulCreatePersonWithoutJob() {

        step("Отправка запроса на создание сотрудника без Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(name, null);
            CreatePersonResponseModel response = createPersonApi.successCreatePerson(requestData);
            System.setProperty("successfulCreatePersonWithoutJobResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос об успешном создании сотрудника без Job", () -> {
            String responseJson = System.getProperty("successfulCreatePersonWithoutJobResponse");
            CreatePersonResponseModel response = new Gson().fromJson(responseJson, CreatePersonResponseModel.class);
            CreatePersonAsserts.validateResponseWithoutJob(response);
        });
    }
}
