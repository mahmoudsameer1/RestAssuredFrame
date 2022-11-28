package studentApiTest;

import org.testng.annotations.Test;

import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PostAPIPojo;
import utils.BaseTest;

public class SerTest extends BaseTest{

	
	@Test
	public void setTest1() {
		
		HeaderConfigs head = new HeaderConfigs();
		PostAPIPojo pojo = new PostAPIPojo(22, "serTest", "mahmoud");
		
		Response response =RestAssured.given().headers(head.defaultHeaders())
				.body(pojo).post(APIPath.apiPath.CREATE_POST);
		
		System.out.println(response.getBody().asString());
		System.out.println(pojo.getAuthor());
	}
}
