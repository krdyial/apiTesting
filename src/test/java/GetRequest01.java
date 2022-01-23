import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {

    /*
    in json file if you want to see all data - > $
    if you want to see "store" in whole file-> $.store
    if you want to see "book" under "store" -> $.store.book
    if you want to see all "category" under "book" -> $.store.book[*].category
    if you want to see first "category" under "book" -> $.store.book[0].category

     */

    @Test
    public void getMethod01() {
        // Response is the class and it stores as json format
        // all results stored in response class
        // in APITesting first thing is checking status code

        Response response = given().when().get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertTrue("Status code is not 200 ", statusCode == 200);
        //String res = response.asString();
        // Assertion should be after then method in response
        response.then().assertThat()
                                .statusCode(200)
                .contentType("application/json");


    }

    @Test
    public void getMethod02() {
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/3");
       /* if(response.getStatusCode()==200){
            response.prettyPrint();
        } else {
            System.out.println("Status Code is not 200 ");
        }*/
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON);

    }
}
