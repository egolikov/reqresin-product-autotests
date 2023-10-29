package in.regres.tests.asserts;

import in.regres.models.listUsers.ListUsersDataResponseModel;
import in.regres.models.listUsers.ListUsersResponseModel;
import in.regres.models.listUsers.ListUsersSupportResponseModel;
import io.qameta.allure.Description;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListUsersAsserts {

    @Description("Проверка информации о странице в ответе")
    public static void validateResponseInfoPage(ListUsersResponseModel listUsersResponseModel) {

        assertThat(listUsersResponseModel.getPage())
                .as("Значение полученного Page из ответа верное")
                .isEqualTo(2);

        assertThat(listUsersResponseModel.getPerPage())
                .as("Значение полученной PerPage из ответа верное")
                .isEqualTo(6);

        assertThat(listUsersResponseModel.getTotal())
                .as("Значение полученного Total из ответа верное")
                .isEqualTo(12);

        assertThat(listUsersResponseModel.getTotalPages())
                .as("Значение полученного TotalPages из ответа верное")
                .isEqualTo(2);
    }

    @Description("Проверка информации о первом объекте в ответе")
    public static void validateResponseFirstObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(0).getId())
                .as("Значение полученного Id из первого объекта в ответе верное")
                .isEqualTo(7);

        assertThat(listUsersDataResponseModel.get(0).getEmail())
                .as("Значение полученного Email из первого объекта в ответе верное")
                .isEqualTo("michael.lawson@reqres.in");

        assertThat(listUsersDataResponseModel.get(0).getFirstName())
                .as("Значение полученного FirstName из первого объекта в ответе верное")
                .isEqualTo("Michael");

        assertThat(listUsersDataResponseModel.get(0).getLastName())
                .as("Значение полученного LastName из первого объекта в ответе верное")
                .isEqualTo("Lawson");

        assertThat(listUsersDataResponseModel.get(0).getAvatar())
                .as("Значение полученного Avatar из первого объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/7-image.jpg");
    }

    @Description("Проверка информации о втором объекте в ответе")
    public static void validateResponseSecondObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(1).getId())
                .as("Значение полученного Id из второго объекта в ответе верное")
                .isEqualTo(8);

        assertThat(listUsersDataResponseModel.get(1).getEmail())
                .as("Значение полученного Email из второго объекта в ответе верное")
                .isEqualTo("lindsay.ferguson@reqres.in");

        assertThat(listUsersDataResponseModel.get(1).getFirstName())
                .as("Значение полученного FirstName из второго объекта в ответе верное")
                .isEqualTo("Lindsay");

        assertThat(listUsersDataResponseModel.get(1).getLastName())
                .as("Значение полученного LastName из второго объекта в ответе верное")
                .isEqualTo("Ferguson");

        assertThat(listUsersDataResponseModel.get(1).getAvatar())
                .as("Значение полученного Avatar из второго объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/8-image.jpg");
    }

    @Description("Проверка информации о третьем объекте в ответе")
    public static void validateResponseThirdObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(2).getId())
                .as("Значение полученного Id из третьего объекта в ответе верное")
                .isEqualTo(9);

        assertThat(listUsersDataResponseModel.get(2).getEmail())
                .as("Значение полученного Email из третьего объекта в ответе верное")
                .isEqualTo("tobias.funke@reqres.in");

        assertThat(listUsersDataResponseModel.get(2).getFirstName())
                .as("Значение полученного FirstName из третьего объекта в ответе верное")
                .isEqualTo("Tobias");

        assertThat(listUsersDataResponseModel.get(2).getLastName())
                .as("Значение полученного LastName из третьего объекта в ответе верное")
                .isEqualTo("Funke");

        assertThat(listUsersDataResponseModel.get(2).getAvatar())
                .as("Значение полученного Avatar из третьего объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/9-image.jpg");
    }

    @Description("Проверка информации о четвертом объекте в ответе")
    public static void validateResponseFourthObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(3).getId())
                .as("Значение полученного Id из четвертого объекта в ответе верное")
                .isEqualTo(10);

        assertThat(listUsersDataResponseModel.get(3).getEmail())
                .as("Значение полученного Email из четвертого объекта в ответе верное")
                .isEqualTo("byron.fields@reqres.in");

        assertThat(listUsersDataResponseModel.get(3).getFirstName())
                .as("Значение полученного FirstName из четвертого объекта в ответе верное")
                .isEqualTo("Byron");

        assertThat(listUsersDataResponseModel.get(3).getLastName())
                .as("Значение полученного LastName из четвертого объекта в ответе верное")
                .isEqualTo("Fields");

        assertThat(listUsersDataResponseModel.get(3).getAvatar())
                .as("Значение полученного Avatar из четвертого объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/10-image.jpg");
    }

    @Description("Проверка информации о пятом объекте в ответе")
    public static void validateResponseFifthObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(4).getId())
                .as("Значение полученного Id из пятого объекта в ответе верное")
                .isEqualTo(11);

        assertThat(listUsersDataResponseModel.get(4).getEmail())
                .as("Значение полученного Email из пятого объекта в ответе верное")
                .isEqualTo("george.edwards@reqres.in");

        assertThat(listUsersDataResponseModel.get(4).getFirstName())
                .as("Значение полученного FirstName из пятого объекта в ответе верное")
                .isEqualTo("George");

        assertThat(listUsersDataResponseModel.get(4).getLastName())
                .as("Значение полученного LastName из пятого объекта в ответе верное")
                .isEqualTo("Edwards");

        assertThat(listUsersDataResponseModel.get(4).getAvatar())
                .as("Значение полученного Avatar из пятого объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/11-image.jpg");
    }

    @Description("Проверка информации о шестом объекте в ответе")
    public static void validateResponseSixthObject(List<ListUsersDataResponseModel> listUsersDataResponseModel) {

        assertThat(listUsersDataResponseModel.get(5).getId())
                .as("Значение полученного Id из шестого объекта в ответе верное")
                .isEqualTo(12);

        assertThat(listUsersDataResponseModel.get(5).getEmail())
                .as("Значение полученного Email из шестого объекта в ответе верное")
                .isEqualTo("rachel.howell@reqres.in");

        assertThat(listUsersDataResponseModel.get(5).getFirstName())
                .as("Значение полученного FirstName из шестого объекта в ответе верное")
                .isEqualTo("Rachel");

        assertThat(listUsersDataResponseModel.get(5).getLastName())
                .as("Значение полученного LastName из шестого объекта в ответе верное")
                .isEqualTo("Howell");

        assertThat(listUsersDataResponseModel.get(5).getAvatar())
                .as("Значение полученного Avatar из шестого объекта в ответе верное")
                .isEqualTo("https://reqres.in/img/faces/12-image.jpg");
    }

    @Description("Проверка информации о поддержке в ответе")
    public static void validateResponseSupport(ListUsersSupportResponseModel listUsersSupportResponseModel) {

        assertThat(listUsersSupportResponseModel.getUrl())
                .as("Значение полученного Url в ответе верное")
                .isEqualTo("https://reqres.in/#support-heading");

        assertThat(listUsersSupportResponseModel.getText())
                .as("Значение полученного Text в ответе верное")
                .isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");

    }
}
