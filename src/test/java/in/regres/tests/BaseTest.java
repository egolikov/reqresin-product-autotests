package in.regres.tests;

import in.regres.config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = config.baseUrl();
        RestAssured.basePath = config.basePath();
    }
}
