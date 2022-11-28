package studentApiTest;

import org.testng.annotations.Test;
import apiConfigs.APIPath;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.BaseTest;

public class GetAPITests extends BaseTest{

	@Test
	public void getAPITest() {

		// test.log(LogStatus.INFO, "TestStarted");
		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POST);
		APIVerification.responseCodeValidation(response, 200);
	}
}
