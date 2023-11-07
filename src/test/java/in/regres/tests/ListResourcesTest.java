package in.regres.tests;

import in.regres.api.ListResourcesApi;
import in.regres.models.listResorces.ListResourcesDataResponseModel;
import in.regres.models.listResorces.ListResourcesResponseModel;
import in.regres.models.listResorces.ListResourcesSupportResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая фунциональность приложения Reqres.in")
@Story("Лист ресурсов")
public class ListResourcesTest {

    protected ListResourcesApi listResourcesApi = new ListResourcesApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("ListResources")
    @DisplayName("Проверка успешного получения списка ресурсов")
    void successfulFetchListResourcesTest() {

        step("Отправка запроса на получение списка Ресурсов", () -> {
            ListResourcesResponseModel response = listResourcesApi.successfulFetchListResources();
            final ListResourcesResponseModel successfulFetchListResourcesResponse = response;
            final List<ListResourcesDataResponseModel> successfulFetchListResourcesDataResponse = successfulFetchListResourcesResponse.getData();
            final ListResourcesSupportResponseModel successfulFetchListResourcesSupportResponse = successfulFetchListResourcesResponse.getSupport();
            step("Проверка ответа на запрос о получении списка ресурсов", () -> {

                assertThat(successfulFetchListResourcesResponse.getPage())
                        .as("Значение полученного Page из ответа верное")
                        .isEqualTo(1);

                assertThat(successfulFetchListResourcesResponse.getPerPage())
                        .as("Значение полученной PerPage из ответа верное")
                        .isEqualTo(6);

                assertThat(successfulFetchListResourcesResponse.getTotal())
                        .as("Значение полученного Total из ответа верное")
                        .isEqualTo(12);

                assertThat(successfulFetchListResourcesResponse.getTotalPages())
                        .as("Значение полученного TotalPages из ответа верное")
                        .isEqualTo(2);

                assertThat(successfulFetchListResourcesDataResponse.get(0).getId())
                        .as("Значение полученного Id из первого объекта в ответе верное")
                        .isEqualTo(1);

                assertThat(successfulFetchListResourcesDataResponse.get(0).getName())
                        .as("Значение полученного Name из первого объекта в ответе верное")
                        .isEqualTo("cerulean");

                assertThat(successfulFetchListResourcesDataResponse.get(0).getYear())
                        .as("Значение полученного Year из первого объекта в ответе верное")
                        .isEqualTo(2000);

                assertThat(successfulFetchListResourcesDataResponse.get(0).getColor())
                        .as("Значение полученного Color из первого объекта в ответе верное")
                        .isEqualTo("#98B2D1");

                assertThat(successfulFetchListResourcesDataResponse.get(0).getPantoneValue())
                        .as("Значение полученного PantoneValue из первого объекта в ответе верное")
                        .isEqualTo("15-4020");

                assertThat(successfulFetchListResourcesDataResponse.get(1).getId())
                        .as("Значение полученного Id из второго объекта в ответе верное")
                        .isEqualTo(2);

                assertThat(successfulFetchListResourcesDataResponse.get(1).getName())
                        .as("Значение полученного Name из второго объекта в ответе верное")
                        .isEqualTo("fuchsia rose");

                assertThat(successfulFetchListResourcesDataResponse.get(1).getYear())
                        .as("Значение полученного Year из второго объекта в ответе верное")
                        .isEqualTo(2001);

                assertThat(successfulFetchListResourcesDataResponse.get(1).getColor())
                        .as("Значение полученного Color из второго объекта в ответе верное")
                        .isEqualTo("#C74375");

                assertThat(successfulFetchListResourcesDataResponse.get(1).getPantoneValue())
                        .as("Значение полученного PantoneValue из второго объекта в ответе верное")
                        .isEqualTo("17-2031");

                assertThat(successfulFetchListResourcesDataResponse.get(2).getId())
                        .as("Значение полученного Id из третьего объекта в ответе верное")
                        .isEqualTo(3);

                assertThat(successfulFetchListResourcesDataResponse.get(2).getName())
                        .as("Значение полученного Name из третьего объекта в ответе верное")
                        .isEqualTo("true red");

                assertThat(successfulFetchListResourcesDataResponse.get(2).getYear())
                        .as("Значение полученного Year из третьего объекта в ответе верное")
                        .isEqualTo(2002);

                assertThat(successfulFetchListResourcesDataResponse.get(2).getColor())
                        .as("Значение полученного Color из третьего объекта в ответе верное")
                        .isEqualTo("#BF1932");

                assertThat(successfulFetchListResourcesDataResponse.get(2).getPantoneValue())
                        .as("Значение полученного PantoneValue из третьего объекта в ответе верное")
                        .isEqualTo("19-1664");

                assertThat(successfulFetchListResourcesDataResponse.get(3).getId())
                        .as("Значение полученного Id из четвертого объекта в ответе верное")
                        .isEqualTo(4);

                assertThat(successfulFetchListResourcesDataResponse.get(3).getName())
                        .as("Значение полученного Name из четвертого объекта в ответе верное")
                        .isEqualTo("aqua sky");

                assertThat(successfulFetchListResourcesDataResponse.get(3).getYear())
                        .as("Значение полученного Year из четвертого объекта в ответе верное")
                        .isEqualTo(2003);

                assertThat(successfulFetchListResourcesDataResponse.get(3).getColor())
                        .as("Значение полученного Color из четвертого объекта в ответе верное")
                        .isEqualTo("#7BC4C4");

                assertThat(successfulFetchListResourcesDataResponse.get(3).getPantoneValue())
                        .as("Значение полученного PantoneValue из четвертого объекта в ответе верное")
                        .isEqualTo("14-4811");

                assertThat(successfulFetchListResourcesDataResponse.get(4).getId())
                        .as("Значение полученного Id из пятого объекта в ответе верное")
                        .isEqualTo(5);

                assertThat(successfulFetchListResourcesDataResponse.get(4).getName())
                        .as("Значение полученного Name из пятого объекта в ответе верное")
                        .isEqualTo("tigerlily");

                assertThat(successfulFetchListResourcesDataResponse.get(4).getYear())
                        .as("Значение полученного Year из пятого объекта в ответе верное")
                        .isEqualTo(2004);

                assertThat(successfulFetchListResourcesDataResponse.get(4).getColor())
                        .as("Значение полученного Color из пятого объекта в ответе верное")
                        .isEqualTo("#E2583E");

                assertThat(successfulFetchListResourcesDataResponse.get(4).getPantoneValue())
                        .as("Значение полученного PantoneValue из пятого объекта в ответе верное")
                        .isEqualTo("17-1456");

                assertThat(successfulFetchListResourcesDataResponse.get(5).getId())
                        .as("Значение полученного Id из шестого объекта в ответе верное")
                        .isEqualTo(6);

                assertThat(successfulFetchListResourcesDataResponse.get(5).getName())
                        .as("Значение полученного Name из шестого объекта в ответе верное")
                        .isEqualTo("blue turquoise");

                assertThat(successfulFetchListResourcesDataResponse.get(5).getYear())
                        .as("Значение полученного Year из шестого объекта в ответе верное")
                        .isEqualTo(2005);

                assertThat(successfulFetchListResourcesDataResponse.get(5).getColor())
                        .as("Значение полученного Color из шестого объекта в ответе верное")
                        .isEqualTo("#53B0AE");

                assertThat(successfulFetchListResourcesDataResponse.get(5).getPantoneValue())
                        .as("Значение полученного PantoneValue из шестого объекта в ответе верное")
                        .isEqualTo("15-5217");

                assertThat(successfulFetchListResourcesSupportResponse.getUrl())
                        .as("Значение полученного Url в ответе верное")
                        .isEqualTo("https://reqres.in/#support-heading");

                assertThat(successfulFetchListResourcesSupportResponse.getText())
                        .as("Значение полученного Text в ответе верное")
                        .isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
            });
        });
    }
}
