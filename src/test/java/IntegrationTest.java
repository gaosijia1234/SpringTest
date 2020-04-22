import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpEntity<T>;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testName() throws Exception{
        //arrange

        //act
        ResponseEntity<Car> entity = testRestTemplate.getForEntity("/cars/pruis", Car.class);

        // assert
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
}
