import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest03 {
    /*
    when I send a get request to https://restful-booker.herokuapp.com/booking/5
    then http status code should be 200
    content type should be "json" format
    and status line should be "HTTP/1.1 200 OK"
    and response body does not contain "Not found"
    and response body contains "bookingdates"

     */
    @Test
    public void getMethod01(){
        Response response= given().
                           when().
                            get("https://restful-booker.herokuapp.com/booking/5");
                         response.
                                 then().
                                    assertThat().
                                    statusCode(200).
                                    contentType(ContentType.JSON).
                                    statusLine("HTTP/1.1 200 OK");
        response.prettyPrint();
        assertFalse(response.asString().contains("Not found") );
        assertTrue(response.asString().contains("bookingdates"));

    }

}
