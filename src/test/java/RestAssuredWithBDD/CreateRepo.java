package RestAssuredWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateRepo {
	
	
	@Test
	public void createRepo() {
		JSONObject jsonObject = new JSONObject();
		int ran = new Random().nextInt(100);
		jsonObject.put("name", "Hello-World" + ran);
		jsonObject.put("description", "This is your first repo!");
		jsonObject.put("homepage", "https://github.com");
		jsonObject.put("private", false);
		jsonObject.put("is_template", true);
		RequestSpecification preReq = RestAssured.given();
		preReq.body(jsonObject);
		preReq.contentType(ContentType.JSON);
		preReq.auth().oauth2("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");
		Response responsce = preReq.post("https://api.github.com/user/repos");
		
		Assert.assertEquals(responsce.body().jsonPath().get("name"), "Hello-World" + ran);
//		Assert.assertEquals(responsce.getContentType(), ContentType.JSON);
		System.out.println(ContentType.JSON);
		Assert.assertEquals(responsce.statusCode(), 201);
	}

}
