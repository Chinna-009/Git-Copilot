package resourses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Utils {
	public static RequestSpecification BaseReq;
   
	
	
	public  RequestSpecification requestSpecification() throws IOException
	    
	
	{
		if (BaseReq == null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 
	    BaseReq= new RequestSpecBuilder().setBaseUri(getGlobalValue("BaseUrl")).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
	    		.addFilter(RequestLoggingFilter.logRequestTo(log))
	    		.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	    
	    return BaseReq;
	    }
		
	     return BaseReq;
	 }
	
	 
	
	
	public static String getGlobalValue(String Key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\dchengan\\eclipse-workspace\\APITestingFreameWork\\src\\test\\java\\resourses\\global.properties");
		prop.load(fs);                            //C:\Users\dchengan\eclipse-workspace\APITestingFreameWork\\
		return prop.getProperty(Key); 
	}
	
	public String getJson(Response  res, String Key)
	{
		String respo = res.asString();         
		JsonPath js = new JsonPath(respo); 
		return js.get(Key).toString();
	}

}
