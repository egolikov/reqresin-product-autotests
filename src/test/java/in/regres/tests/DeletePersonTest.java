package in.regres.tests;

import in.regres.api.DeletePersonApi;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая фунциональность приложения Reqres.in")
@Story("Удаление сотрудника")
public class DeletePersonTest {

    DeletePersonApi deletePersonApi = new DeletePersonApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("DeletePerson")
    @DisplayName("Проверка успешного удаления сотрудника")
    void successfulDeletePersonTest() {

        step("Отправка запроса на успешное удаление сотрудника", () -> deletePersonApi.deletePerson());
    }
}
