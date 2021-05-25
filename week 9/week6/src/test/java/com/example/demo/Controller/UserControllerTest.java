package com.example.demo.Controller;

import com.example.demo.DemoApplication;
import com.example.demo.Entity.User;
import com.example.demo.Form.UserRegisterForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    private String getUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void getAllUser() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(getUrl() + "/", HttpMethod.GET, httpEntity, String.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void searchUser() {
        User user = restTemplate.getForObject(getUrl() + "/search=dean", User.class);
        assertNotNull(user);
    }

    @Test
    public void getUserById() {
        User user = restTemplate.getForObject(getUrl() + "/1", User.class);
        System.out.println(user.getEmail());
        assertNotNull(user);
    }

    @Test
    public void register() {
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setEmail("testtests@gmail.com");
        userRegisterForm.setName("test");
        userRegisterForm.setPassword("testpassword");
        ResponseEntity<UserRegisterForm> postResponse = restTemplate.postForEntity(getUrl() + "/register", userRegisterForm, UserRegisterForm.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
}
