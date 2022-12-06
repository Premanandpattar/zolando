package RestAssuredWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllRepo {
	@Test
	public void getAllRepoWithBDD() {
		given().auth().oauth2("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").when()
				.get("https://api.github.com/user/repos")
				.then().statusCode(200).contentType(ContentType.JSON).log().all();
		
	}

}
