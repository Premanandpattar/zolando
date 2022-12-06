package RestAssuredWithOutBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteRepo {

	@Test
	public void deleteRepo() {
		given().auth().oauth2("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").when()
				.delete("https://api.github.com/repos/Premanandpattar/Hello-World22").then().log()
				.all();
	}
}
