import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBaseDt{
    // it is good to get rid of String in our codes. because of that we ae using spec
    // we created
    @Test
    public void get01(){
        Response response= given().
                                spec(spec01).
                            when().
                                get();
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("molestiae"));
        response.then().assertThat().body("id", Matchers.hasItems(111,121,131),
                                        "title[-1]",Matchers.equalTo("ipsam aperiam voluptates qui"));
    }
}
