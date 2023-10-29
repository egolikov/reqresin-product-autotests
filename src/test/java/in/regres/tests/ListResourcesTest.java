package in.regres.tests;

import com.google.gson.Gson;
import in.regres.api.ListResourcesApi;
import in.regres.models.listResorces.ListResourcesResponseModel;
import in.regres.tests.asserts.ListResourcesAsserts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ListResourcesTest {

    ListResourcesApi listResourcesApi = new ListResourcesApi();

    @Test
    @DisplayName("Проверка успешного получения списка ресурсов")
    void successfulFetchListResourcesTest() {

        step("Отправка запроса на получение списка Ресурсов", () -> {
            ListResourcesResponseModel response = listResourcesApi.successfulFetchListResources();
            System.setProperty("successfulFetchListResourcesResponse", new Gson().toJson(response));
        });

        step("Проверка ответа на запрос о получении списка ресурсов", () -> {
            String responseJson = System.getProperty("successfulFetchListResourcesResponse");
            ListResourcesResponseModel response = new Gson().fromJson(responseJson, ListResourcesResponseModel.class);
            ListResourcesAsserts.validateResponseInfoPage(response);
            ListResourcesAsserts.validateResponseFirstObject(response.getData());
            ListResourcesAsserts.validateResponseSecondObject(response.getData());
            ListResourcesAsserts.validateResponseThirdObject(response.getData());
            ListResourcesAsserts.validateResponseFourthObject(response.getData());
            ListResourcesAsserts.validateResponseFifthObject(response.getData());
            ListResourcesAsserts.validateResponseSixthObject(response.getData());
            ListResourcesAsserts.validateResponseSupport(response.getSupport());
        });
    }
}
