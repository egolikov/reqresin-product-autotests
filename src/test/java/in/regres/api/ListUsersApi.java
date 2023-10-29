package in.regres.api;

import in.regres.models.listUsers.ListUsersResponseModel;
import in.regres.specs.ListUsersSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class ListUsersApi {

    @Description("Отправка запроса на получение списка сотрудников")
    public ListUsersResponseModel successfulFetchListUsers() {
        return given()
                .spec(ListUsersSpec.listUsersRequestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(ListUsersSpec.listUsersResponseSpec)
                .extract()
                .as(ListUsersResponseModel.class);
    }
}