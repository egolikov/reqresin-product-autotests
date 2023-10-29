package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.ListUsersApi;
import in.regres.models.listUsers.ListUsersResponseModel;
import in.regres.tests.asserts.ListUsersAsserts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ListUsersTest {

    ListUsersApi listUsersApi = new ListUsersApi();

    @Test
    @DisplayName("Проверка успешного получения списка сотрудников")
    void successfulFetchListUsersTest() {

        step("Отправка запроса на получение списка Сотрудников", () -> {
            ListUsersResponseModel response = listUsersApi.successfulFetchListUsers();
            System.setProperty("successfulFetchListUsersResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос о получении списка сотрудников", () -> {
            String responseJson = System.getProperty("successfulFetchListUsersResponse");
            ListUsersResponseModel response = new Gson().fromJson(responseJson, ListUsersResponseModel.class);
            ListUsersAsserts.validateResponseInfoPage(response);
            ListUsersAsserts.validateResponseFirstObject(response.getData());
            ListUsersAsserts.validateResponseSecondObject(response.getData());
            ListUsersAsserts.validateResponseThirdObject(response.getData());
            ListUsersAsserts.validateResponseFourthObject(response.getData());
            ListUsersAsserts.validateResponseFifthObject(response.getData());
            ListUsersAsserts.validateResponseSixthObject(response.getData());
            ListUsersAsserts.validateResponseSupport(response.getSupport());
        });
    }
}
