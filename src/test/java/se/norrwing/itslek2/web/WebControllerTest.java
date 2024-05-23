package se.norrwing.itslek2.web;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/*@TestPropertySource(properties = {
        "spring.security.user.name=user"
        ,
        "spring.security.user.password=81d1725a-f730-4842-9857-1b0937495921"
})*/
public class WebControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetEndpoint(){
        TestRestTemplate authorizedTestRestTemplate = testRestTemplate.withBasicAuth("user", "79e85997-df9e-415f-8ce7-a3f03a221807");
        ResponseEntity<String> response = authorizedTestRestTemplate.getForEntity("/",String.class);
        assertThat(response.getBody()).isInstanceOf(String.class);
        System.out.println(response);
    }
}
