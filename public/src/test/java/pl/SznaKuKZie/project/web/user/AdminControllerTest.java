package pl.SznaKuKZie.project.web.user;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.context.WebApplicationContext;
import pl.SznaKuKZie.project.model.User;
import pl.SznaKuKZie.project.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private AdminController adminController;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() throws Exception {
        assertThat(adminController).isNotNull();
    }

    @WithMockUser(username = "a", roles = "ADMIN")
    @Test
    public void showUserList() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isOk())
                .andExpect(model().attribute("admin", hasSize(4)));
    }
}