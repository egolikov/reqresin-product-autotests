package in.regres.api;

import in.regres.models.lists.ListResourcesResponseModel;
import in.regres.specs.ListSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class ListResourcesApi {

    @Description("Отправка запроса на получение списка ресурсов")
    public ListResourcesResponseModel successfulFetchListResources() {
        return given()
                .spec(ListSpec.listRequestSpec)
                .when()
                .get("/unknown")
                .then()
                .spec(ListSpec.listResponseSpec)
                .extract()
                .as(ListResourcesResponseModel.class);
    }
}