package in.regres.tests;

import in.regres.api.ListUsersApi;
import in.regres.models.lists.ListUsersDataResponseModel;
import in.regres.models.lists.ListUsersResponseModel;
import in.regres.models.lists.ListUsersSupportResponseModel;
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
@Story("Лист сотрудников")
public class ListUsersTest extends BaseTest {

    protected ListUsersApi listUsersApi = new ListUsersApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("ListPersons")
    @DisplayName("Проверка успешного получения списка сотрудников")
    void successfulFetchListUsersTest() {

        step("Отправка запроса на получение списка Сотрудников", () -> {
            ListUsersResponseModel response = listUsersApi.successfulFetchListUsers();
            final ListUsersResponseModel successfulFetchListUsersResponse = response;
            final List<ListUsersDataResponseModel> successfulFetchListUsersDataResponse = successfulFetchListUsersResponse.getData();
            final ListUsersSupportResponseModel successfulFetchListUsersSupportResponse = successfulFetchListUsersResponse.getSupport();


            step("Проверка ответа на запрос о получении списка сотрудников", () -> {
                assertThat(successfulFetchListUsersResponse.getPage())
                        .as("Значение полученного Page из ответа верное")
                        .isEqualTo(2);

                assertThat(successfulFetchListUsersResponse.getPerPage())
                        .as("Значение полученной PerPage из ответа верное")
                        .isEqualTo(6);

                assertThat(successfulFetchListUsersResponse.getTotal())
                        .as("Значение полученного Total из ответа верное")
                        .isEqualTo(12);

                assertThat(successfulFetchListUsersResponse.getTotalPages())
                        .as("Значение полученного TotalPages из ответа верное")
                        .isEqualTo(2);

                assertThat(successfulFetchListUsersDataResponse.get(0).getId())
                        .as("Значение полученного Id из первого объекта в ответе верное")
                        .isEqualTo(7);

                assertThat(successfulFetchListUsersDataResponse.get(0).getEmail())
                        .as("Значение полученного Email из первого объекта в ответе верное")
                        .isEqualTo("michael.lawson@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(0).getFirstName())
                        .as("Значение полученного FirstName из первого объекта в ответе верное")
                        .isEqualTo("Michael");

                assertThat(successfulFetchListUsersDataResponse.get(0).getLastName())
                        .as("Значение полученного LastName из первого объекта в ответе верное")
                        .isEqualTo("Lawson");

                assertThat(successfulFetchListUsersDataResponse.get(0).getAvatar())
                        .as("Значение полученного Avatar из первого объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/7-image.jpg");

                assertThat(successfulFetchListUsersDataResponse.get(1).getId())
                        .as("Значение полученного Id из второго объекта в ответе верное")
                        .isEqualTo(8);

                assertThat(successfulFetchListUsersDataResponse.get(1).getEmail())
                        .as("Значение полученного Email из второго объекта в ответе верное")
                        .isEqualTo("lindsay.ferguson@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(1).getFirstName())
                        .as("Значение полученного FirstName из второго объекта в ответе верное")
                        .isEqualTo("Lindsay");

                assertThat(successfulFetchListUsersDataResponse.get(1).getLastName())
                        .as("Значение полученного LastName из второго объекта в ответе верное")
                        .isEqualTo("Ferguson");

                assertThat(successfulFetchListUsersDataResponse.get(1).getAvatar())
                        .as("Значение полученного Avatar из второго объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/8-image.jpg");

                assertThat(successfulFetchListUsersDataResponse.get(2).getId())
                        .as("Значение полученного Id из третьего объекта в ответе верное")
                        .isEqualTo(9);

                assertThat(successfulFetchListUsersDataResponse.get(2).getEmail())
                        .as("Значение полученного Email из третьего объекта в ответе верное")
                        .isEqualTo("tobias.funke@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(2).getFirstName())
                        .as("Значение полученного FirstName из третьего объекта в ответе верное")
                        .isEqualTo("Tobias");

                assertThat(successfulFetchListUsersDataResponse.get(2).getLastName())
                        .as("Значение полученного LastName из третьего объекта в ответе верное")
                        .isEqualTo("Funke");

                assertThat(successfulFetchListUsersDataResponse.get(2).getAvatar())
                        .as("Значение полученного Avatar из третьего объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/9-image.jpg");

                assertThat(successfulFetchListUsersDataResponse.get(3).getId())
                        .as("Значение полученного Id из четвертого объекта в ответе верное")
                        .isEqualTo(10);

                assertThat(successfulFetchListUsersDataResponse.get(3).getEmail())
                        .as("Значение полученного Email из четвертого объекта в ответе верное")
                        .isEqualTo("byron.fields@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(3).getFirstName())
                        .as("Значение полученного FirstName из четвертого объекта в ответе верное")
                        .isEqualTo("Byron");

                assertThat(successfulFetchListUsersDataResponse.get(3).getLastName())
                        .as("Значение полученного LastName из четвертого объекта в ответе верное")
                        .isEqualTo("Fields");

                assertThat(successfulFetchListUsersDataResponse.get(3).getAvatar())
                        .as("Значение полученного Avatar из четвертого объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/10-image.jpg");

                assertThat(successfulFetchListUsersDataResponse.get(4).getId())
                        .as("Значение полученного Id из пятого объекта в ответе верное")
                        .isEqualTo(11);

                assertThat(successfulFetchListUsersDataResponse.get(4).getEmail())
                        .as("Значение полученного Email из пятого объекта в ответе верное")
                        .isEqualTo("george.edwards@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(4).getFirstName())
                        .as("Значение полученного FirstName из пятого объекта в ответе верное")
                        .isEqualTo("George");

                assertThat(successfulFetchListUsersDataResponse.get(4).getLastName())
                        .as("Значение полученного LastName из пятого объекта в ответе верное")
                        .isEqualTo("Edwards");

                assertThat(successfulFetchListUsersDataResponse.get(4).getAvatar())
                        .as("Значение полученного Avatar из пятого объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/11-image.jpg");

                assertThat(successfulFetchListUsersDataResponse.get(5).getId())
                        .as("Значение полученного Id из шестого объекта в ответе верное")
                        .isEqualTo(12);

                assertThat(successfulFetchListUsersDataResponse.get(5).getEmail())
                        .as("Значение полученного Email из шестого объекта в ответе верное")
                        .isEqualTo("rachel.howell@reqres.in");

                assertThat(successfulFetchListUsersDataResponse.get(5).getFirstName())
                        .as("Значение полученного FirstName из шестого объекта в ответе верное")
                        .isEqualTo("Rachel");

                assertThat(successfulFetchListUsersDataResponse.get(5).getLastName())
                        .as("Значение полученного LastName из шестого объекта в ответе верное")
                        .isEqualTo("Howell");

                assertThat(successfulFetchListUsersDataResponse.get(5).getAvatar())
                        .as("Значение полученного Avatar из шестого объекта в ответе верное")
                        .isEqualTo("https://reqres.in/img/faces/12-image.jpg");

                assertThat(successfulFetchListUsersSupportResponse.getUrl())
                        .as("Значение полученного Url в ответе верное")
                        .isEqualTo("https://reqres.in/#support-heading");

                assertThat(successfulFetchListUsersSupportResponse.getText())
                        .as("Значение полученного Text в ответе верное")
                        .isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
            });
        });
    }
}
