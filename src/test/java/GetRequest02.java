import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest02 {
    /*
    when I send a GET request to https://restful-booker.herokuapp.com/booking
    and I accept type  "application/json" --> means API is accepting data just in Json Format
    then status code should be 200
    and content type should be "application/json"
     */

    @Test
    public void getMethod01(){
       Response response=  given().
                                accept(ContentType.JSON).
                           when().
                                get("https://restful-booker.herokuapp.com/booking");
                           response.
                                   then()
                                    .assertThat().
                                    statusCode(200).
                                    contentType(ContentType.JSON);
                           response.prettyPrint();

    }

    /*
    when I send a GET request to https://restful-booker.herokuapp.com/booking/5
    and I accept type  "application/json" --> means API is accepting data just in Json Format
    then status code should be 200
    and content type should be "application/json"
     */

    @Test
    public void getMethod02(){
        Response response=  given().when().get("https://restful-booker.herokuapp.com/booking/5");
                response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }/*
    when I send a GET request to https://restful-booker.herokuapp.com/booking/1001
    then status code should be 404
    and Response body contains "Not Found"
    and Response Body  ´does not contain "Alaettin"
     */
    @Test
    public void getMethod03(){
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/1001");
                 response.then().assertThat().statusCode(404);
                 response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("Alaettin"));

        //response body is json here. first convert it as String and you can use contain method belongs to string methods

    }
}
