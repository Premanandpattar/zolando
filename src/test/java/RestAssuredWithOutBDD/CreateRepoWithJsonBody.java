package RestAssuredWithOutBDD;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateRepoWithJsonBody {

	@Test
	public void createRepo() throws InterruptedException {
		JSONObject jsonObject = new JSONObject();
		int ran = new Random().nextInt(100);
		jsonObject.put("name", "Hello-World" + ran);
		jsonObject.put("description", "This is your first repo!");
		jsonObject.put("homepage", "https://github.com");
		jsonObject.put("private", false);
		jsonObject.put("is_template", true);

		given().auth().oauth2("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").body(jsonObject).when()
				.contentType(ContentType.JSON).post("https://api.github.com/user/repos").then()
				.body("name", equalTo("Hello-World" + ran)).statusCode(201).contentType(ContentType.JSON)
				;
	}

}
