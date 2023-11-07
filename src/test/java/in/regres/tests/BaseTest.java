package in.regres.tests;

import in.regres.config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class);

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = apiConfig.baseUrl();
        RestAssured.basePath = apiConfig.basePath();
    }
}
