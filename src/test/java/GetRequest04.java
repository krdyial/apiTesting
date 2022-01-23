import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 {

    /*
    1- how to get all Headers data
    2- how to get a specific Header
    3- how to assert Headers one by one

     */
    @Test
    public void get018() {
        Response response= given().when().get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        System.out.println(response.getHeaders()); // all headers in response

        // Assert if headers contain "Etag"
        assertTrue(response.getHeaders().toString().contains("Etag"));
        //// Assert if headers contain "Expect-CT"
        assertTrue(!response.getHeaders().toString().contains("Expect-CT"));
    }


}
