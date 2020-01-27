package pl.SznaKuKZie.project.api;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.core.ParameterizedTypeReference;
import pl.SznaKuKZie.project.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestGuestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllProducts() throws Exception {
        assertThat(this.restTemplate.exchange("http://localhost:" + port + "/api/home", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Product>>() {
                }).getBody()).isNotEmpty();
    }
}