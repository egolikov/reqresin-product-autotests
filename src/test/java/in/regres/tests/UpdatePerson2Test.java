//@Test
//    @DisplayName("Проверка успешного обновления данных пользователя через метод PATCH")
//    void successfulUpdatePersonWithPatchMethodTest() {
//
//        UpdatePersonBodyModel updatePersonData = new UpdatePersonBodyModel();
//        updatePersonData.setName("oleg");
//        updatePersonData.setJob("designer");
//
//        UpdatePersonResponseModel response = step("Обновление Имени и Должности сотрудника", () ->
//                given(updatePersonRequestSpec)
//                        .body(updatePersonData)
//                        .when()
//                        .patch("/users/2")
//                        .then()
//                        .spec(updatePersonResponseSpec)
//                        .extract().as(UpdatePersonResponseModel.class));
//
//        step("Проверка ответа на запрос об успешном обновлении сотрудника", () -> {
//            assertEquals("oleg", response.getName());
//            assertEquals("designer", response.getJob());
//            assertNotNull(response.getUpdatedAt());
//        });
//    }
//}
