import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TestBaseDt {

    protected RequestSpecification spec01;

    @Before
    public void setUp01(){
        spec01 = new RequestSpecBuilder().
                            setBaseUri("https://jsonplaceholder.typicode.com/todos").
                            build();
    }
}
