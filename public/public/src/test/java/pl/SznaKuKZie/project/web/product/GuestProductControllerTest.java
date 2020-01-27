package pl.SznaKuKZie.project.web.product;

import static org.junit.Assert.*;


import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.SznaKuKZie.project.web.user.AdminController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuestProductControllerTest {
    @Autowired
    private GuestProductController guestProductController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() throws Exception {
        assertThat(guestProductController).isNotNull();
    }

    @Test
    public void showProducts() throws Exception {
        mockMvc.perform(get("/home")).andExpect(status().isOk())
                .andExpect(model().attribute("products", hasSize(6)));
    }
}