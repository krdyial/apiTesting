import io.restassured.http.ContentType;
import io.restassured.response.Response;
import  org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest05 {
    /*
    when i send a request to get rest api url
    https://restful-booker.herokuapp.com/booking/1
    and accept type is "application/Json"
    then
    http status code should be 200
    and response format should be "application/JSON"
    and first name should be "Susan"
    lastname should be "Brown"
    and checkin date should be "2015-02-16"
    and checkout date should be "2017-06-20"

    NOTE: Some API webpages: "http://dummy.restapiexample.com/api/v1/employees"
                             "https://jsonplaceholder.typicode.com/todos/123"
     */

    @Test
    public void get01(){
        Response response =given().when().get("https://restful-booker.herokuapp.com/booking/1");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                    body("firstname", equalTo("Eric"),
                            "lastname",equalTo("Smith"),
                            "totalprice", equalTo(989));
    }

}
