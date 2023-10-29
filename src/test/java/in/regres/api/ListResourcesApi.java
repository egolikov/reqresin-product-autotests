package in.regres.api;

import in.regres.models.listResorces.ListResourcesResponseModel;
import in.regres.specs.ListResourcesSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class ListResourcesApi {

    @Description("Отправка запроса на получение списка ресурсов")
    public ListResourcesResponseModel successfulFetchListResources() {
        return given()
                .spec(ListResourcesSpec.listResourcesRequestSpec)
                .when()
                .get("/unknown")
                .then()
                .spec(ListResourcesSpec.listResourcesResponseSpec)
                .extract()
                .as(ListResourcesResponseModel.class);
    }
}