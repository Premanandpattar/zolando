package RestAssuredWithOutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllRepo {

	@Test
	public void getAllRepo() {
		RequestSpecification reg = RestAssured.given();
		reg.auth().oauth2("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");
		Response response = reg.get("https://api.github.com/user/repos");
		assertEquals(response.statusCode(), 200);
		assertEquals(response.contentType(), "application/json; charset=utf-8");
		assertEquals(response.contentType().contains("application/json"), true);

		long time = response.time();

		Assert.assertTrue(time < 200);
		System.out.println(time);
	}
}
