package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqSpec;
	
	public RequestSpecification RequestSpecification() throws IOException {
		
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
	    // Request Spec builder could be used to create basic specification for an API request
	    reqSpec =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).
	    		addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log)).
	    		addFilter(ResponseLoggingFilter.logResponseTo(log)).
	    		setContentType(ContentType.JSON).build();
	    return reqSpec;
	}
	public static String getGlobalValue(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream inp = new FileInputStream("C:\\Users\\12365\\eclipse-workspace\\APITestFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(inp);
		return prop.getProperty(key);
	}

}
