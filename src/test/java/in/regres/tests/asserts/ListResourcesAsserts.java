package in.regres.tests.asserts;

import in.regres.models.listResorces.ListResourcesDataResponseModel;
import in.regres.models.listResorces.ListResourcesResponseModel;
import in.regres.models.listResorces.ListResourcesSupportResponseModel;
import io.qameta.allure.Description;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListResourcesAsserts {

    @Description("Проверка информации о странице в ответе")
    public static void validateResponseInfoPage(ListResourcesResponseModel listResourcesResponseModel) {

        assertThat(listResourcesResponseModel.getPage())
                .as("Значение полученного Page из ответа верное")
                .isEqualTo(1);

        assertThat(listResourcesResponseModel.getPerPage())
                .as("Значение полученной PerPage из ответа верное")
                .isEqualTo(6);

        assertThat(listResourcesResponseModel.getTotal())
                .as("Значение полученного Total из ответа верное")
                .isEqualTo(12);

        assertThat(listResourcesResponseModel.getTotalPages())
                .as("Значение полученного TotalPages из ответа верное")
                .isEqualTo(2);
    }

    @Description("Проверка информации о первом объекте в ответе")
    public static void validateResponseFirstObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(0).getId())
                .as("Значение полученного Id из первого объекта в ответе верное")
                .isEqualTo(1);

        assertThat(listResourcesDataResponseModel.get(0).getName())
                .as("Значение полученного Name из первого объекта в ответе верное")
                .isEqualTo("cerulean");

        assertThat(listResourcesDataResponseModel.get(0).getYear())
                .as("Значение полученного Year из первого объекта в ответе верное")
                .isEqualTo(2000);

        assertThat(listResourcesDataResponseModel.get(0).getColor())
                .as("Значение полученного Color из первого объекта в ответе верное")
                .isEqualTo("#98B2D1");

        assertThat(listResourcesDataResponseModel.get(0).getPantoneValue())
                .as("Значение полученного PantoneValue из первого объекта в ответе верное")
                .isEqualTo("15-4020");
    }

    @Description("Проверка информации о втором объекте в ответе")
    public static void validateResponseSecondObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(1).getId())
                .as("Значение полученного Id из второго объекта в ответе верное")
                .isEqualTo(2);

        assertThat(listResourcesDataResponseModel.get(1).getName())
                .as("Значение полученного Name из второго объекта в ответе верное")
                .isEqualTo("fuchsia rose");

        assertThat(listResourcesDataResponseModel.get(1).getYear())
                .as("Значение полученного Year из второго объекта в ответе верное")
                .isEqualTo(2001);

        assertThat(listResourcesDataResponseModel.get(1).getColor())
                .as("Значение полученного Color из второго объекта в ответе верное")
                .isEqualTo("#C74375");

        assertThat(listResourcesDataResponseModel.get(1).getPantoneValue())
                .as("Значение полученного PantoneValue из второго объекта в ответе верное")
                .isEqualTo("17-2031");
    }

    @Description("Проверка информации о третьем объекте в ответе")
    public static void validateResponseThirdObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(2).getId())
                .as("Значение полученного Id из третьего объекта в ответе верное")
                .isEqualTo(3);

        assertThat(listResourcesDataResponseModel.get(2).getName())
                .as("Значение полученного Name из третьего объекта в ответе верное")
                .isEqualTo("true red");

        assertThat(listResourcesDataResponseModel.get(2).getYear())
                .as("Значение полученного Year из третьего объекта в ответе верное")
                .isEqualTo(2002);

        assertThat(listResourcesDataResponseModel.get(2).getColor())
                .as("Значение полученного Color из третьего объекта в ответе верное")
                .isEqualTo("#BF1932");

        assertThat(listResourcesDataResponseModel.get(2).getPantoneValue())
                .as("Значение полученного PantoneValue из третьего объекта в ответе верное")
                .isEqualTo("19-1664");
    }

    @Description("Проверка информации о четвертом объекте в ответе")
    public static void validateResponseFourthObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(3).getId())
                .as("Значение полученного Id из четвертого объекта в ответе верное")
                .isEqualTo(4);

        assertThat(listResourcesDataResponseModel.get(3).getName())
                .as("Значение полученного Name из четвертого объекта в ответе верное")
                .isEqualTo("aqua sky");

        assertThat(listResourcesDataResponseModel.get(3).getYear())
                .as("Значение полученного Year из четвертого объекта в ответе верное")
                .isEqualTo(2003);

        assertThat(listResourcesDataResponseModel.get(3).getColor())
                .as("Значение полученного Color из четвертого объекта в ответе верное")
                .isEqualTo("#7BC4C4");

        assertThat(listResourcesDataResponseModel.get(3).getPantoneValue())
                .as("Значение полученного PantoneValue из четвертого объекта в ответе верное")
                .isEqualTo("14-4811");
    }

    @Description("Проверка информации о пятом объекте в ответе")
    public static void validateResponseFifthObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(4).getId())
                .as("Значение полученного Id из пятого объекта в ответе верное")
                .isEqualTo(5);

        assertThat(listResourcesDataResponseModel.get(4).getName())
                .as("Значение полученного Name из пятого объекта в ответе верное")
                .isEqualTo("tigerlily");

        assertThat(listResourcesDataResponseModel.get(4).getYear())
                .as("Значение полученного Year из пятого объекта в ответе верное")
                .isEqualTo(2004);

        assertThat(listResourcesDataResponseModel.get(4).getColor())
                .as("Значение полученного Color из пятого объекта в ответе верное")
                .isEqualTo("#E2583E");

        assertThat(listResourcesDataResponseModel.get(4).getPantoneValue())
                .as("Значение полученного PantoneValue из пятого объекта в ответе верное")
                .isEqualTo("17-1456");
    }

    @Description("Проверка информации о шестом объекте в ответе")
    public static void validateResponseSixthObject(List<ListResourcesDataResponseModel> listResourcesDataResponseModel) {

        assertThat(listResourcesDataResponseModel.get(5).getId())
                .as("Значение полученного Id из шестого объекта в ответе верное")
                .isEqualTo(6);

        assertThat(listResourcesDataResponseModel.get(5).getName())
                .as("Значение полученного Name из шестого объекта в ответе верное")
                .isEqualTo("blue turquoise");

        assertThat(listResourcesDataResponseModel.get(5).getYear())
                .as("Значение полученного Year из шестого объекта в ответе верное")
                .isEqualTo(2005);

        assertThat(listResourcesDataResponseModel.get(5).getColor())
                .as("Значение полученного Color из шестого объекта в ответе верное")
                .isEqualTo("#53B0AE");

        assertThat(listResourcesDataResponseModel.get(5).getPantoneValue())
                .as("Значение полученного PantoneValue из шестого объекта в ответе верное")
                .isEqualTo("15-5217");
    }

    @Description("Проверка информации о поддержке в ответе")
    public static void validateResponseSupport(ListResourcesSupportResponseModel listResourcesSupportResponseModel) {

        assertThat(listResourcesSupportResponseModel.getUrl())
                .as("Значение полученного Url в ответе верное")
                .isEqualTo("https://reqres.in/#support-heading");

        assertThat(listResourcesSupportResponseModel.getText())
                .as("Значение полученного Text в ответе верное")
                .isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");

    }
}
