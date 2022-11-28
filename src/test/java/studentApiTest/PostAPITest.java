package studentApiTest;


import org.testng.annotations.Test;
import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.BaseTest;
import utils.JavaUtils;

public class PostAPITest extends BaseTest{

	@Test
	public void validpotPITest() {
		
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
		
		Response response =RestAssured.given().when().headers(header.defaultHeaders())
				.body(builder.postRequestBody(JavaUtils.randomNumber(),JavaUtils.randomString(), JavaUtils.randomString()))
				.when().post(APIPath.apiPath.CREATE_POST);
		
		APIVerification.responseKeyValidationFromJsonObject(response, "title");
		APIVerification.responseCodeValidation(response, 201);
		APIVerification.responseTimeValidation(response);
	     
	}
}
