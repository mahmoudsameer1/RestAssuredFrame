package utils;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utils.FileandEnv;

public class BaseTest extends ExtentReporters{

	@BeforeSuite
	public void baseTest() {

		ExtentReporters.setExtent();
		DOMConfigurator.configure("log4j.xml");
		RestAssured.baseURI = FileandEnv.envAndFile().get("ServerUrl");
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentReporters.endReport();
	}
}
