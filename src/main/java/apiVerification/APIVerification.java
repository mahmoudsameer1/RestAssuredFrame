package apiVerification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.BaseTest;
import utils.ExtentReporters;
import utils.Log;


public class APIVerification extends BaseTest{

	public static void responseCodeValidation(Response response, int statusCode) {
		
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(Status.PASS,"Successfully Validated status code,Status code is"+response.getStatusCode() );
			//Log.info("Successfully Validated status code,Status code is"+response.getStatusCode());
			//test.log(LogStatus.PASS, "Successfully Validated status code,Status code is"+response.getStatusCode());
		}catch(AssertionError e){
			Log.info("Expected status code is "+statusCode+ "insted of getting "+response.getStatusCode());
			// test.log(LogStatus.FAIL, "Expected status code is "+statusCode+ "insted of getting "+response.getStatusCode());
			
		}catch(Exception e) {
			Log.info("Login Failed");
			//test.log(LogStatus.FAIL, e.fillInStackTrace();
		}
	}
	
	public static void responseKeyValidationfromArray(Response response, String key) {
		
		try {
			JSONArray array = new JSONArray(response.getBody().asString());

			for (int i = 0; i < array.length(); i++) {

				// System.out.println(array.get(i));
				JSONObject obj = array.getJSONObject(i);
				// test.log(logStatus.INFO, "Validate value are"+ obj.get(key));
				System.out.println(obj.get(key));
			}
		}catch(Exception e){
			//test.log(LogStatus.FAIL, e.fillInStackTrace();
		}
	}
	
	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			
			if(json.has(key)&& json.get(key)!= null) {
				//test.log(LogStatus.PASS, "Successfully validated value of" + key + "It is"+ json.get(key);
			}else {
				//test.log(LogStatus.FAIL,"Key is no available");
			}
		} catch (Exception e) {
			//test.log(LogStatus.FAIL, e.fillInStackTrace();
		}
	}
	
	public static void responseTimeValidation(Response response) {
		
		try {
			long time =response.time();
			Log.info("Api response time is :"+time);
			//test.log(LogStatus.INFO, "Api response time is :"+time);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
