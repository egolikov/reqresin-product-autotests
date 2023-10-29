package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.UpdatePersonApi;
import in.regres.models.updatePerson.UpdatePersonBodyModel;
import in.regres.models.updatePerson.UpdatePersonResponseModel;
import in.regres.tests.asserts.UpdatePersonAsserts;
import in.regres.tests.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class UpdatePersonTest {


    String name = TestData.UPDATE_NAME;
    String job = TestData.UPDATE_JOB;
    String nameO = TestData.ONE_MORE_UPDATE_NAME;
    String jobO = TestData.ONE_MORE_UPDATE_JOB;

    UpdatePersonApi updatePersonApi = new UpdatePersonApi();

    @Test
    @DisplayName("Проверка успешного обновления данных пользователя через метод PUT")
    void successfulUpdatePersonWithPutMethodTest() {

        step("Отправка запроса на обновление данных пользователя", () -> {
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(name, job);
            UpdatePersonResponseModel response = updatePersonApi.successUpdatePersonPut(requestData);
            System.setProperty("successfulUpdatePutPersonResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос об успешном обновлении сотрудника с методом PUT", () -> {
            String responseJson = System.getProperty("successfulUpdatePutPersonResponse");
            UpdatePersonResponseModel response = new Gson().fromJson(responseJson, UpdatePersonResponseModel.class);
            UpdatePersonAsserts.validateResponseUpdatePut(response);
        });
    }

    @Test
    @DisplayName("Проверка успешного обновления данных пользователя через метод PATCH")
    void successfulUpdatePersonWithPatchMethodTest() {

        step("Отправка запроса на обновление данных пользователя", () -> {
            UpdatePersonBodyModel requestData = new UpdatePersonBodyModel(nameO, jobO);
            UpdatePersonResponseModel response = updatePersonApi.successUpdatePersonPatch(requestData);
            System.setProperty("successfulUpdatePatchPersonResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос об успешном обновлении сотрудника с методом PATCH", () -> {
            String responseJson = System.getProperty("successfulUpdatePatchPersonResponse");
            UpdatePersonResponseModel response = new Gson().fromJson(responseJson, UpdatePersonResponseModel.class);
            UpdatePersonAsserts.validateResponseUpdatePatch(response);
        });
    }
}
