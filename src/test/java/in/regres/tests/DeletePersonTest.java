package in.regres.tests;

import in.regres.api.DeletePersonApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DeletePersonTest {

    DeletePersonApi deletePersonApi = new DeletePersonApi();

    @Test
    @DisplayName("Проверка успешного удаления сотрудника")
    void successfulDeletePersonTest() {

        step("Отправка запроса на успешное удаление сотрудника", () -> deletePersonApi.deletePerson());
    }
}
