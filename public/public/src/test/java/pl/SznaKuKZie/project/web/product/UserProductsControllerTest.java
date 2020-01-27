package pl.SznaKuKZie.project.web.product;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.SznaKuKZie.project.repository.ProductRepository;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserProductsControllerTest {

    @Autowired
    private UserProductsController userProductsController;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() throws Exception {
        assertThat(userProductsController).isNotNull();
    }

    @WithMockUser(username = "b", roles = "USER")
    @Test
    public void showUserProducts() throws Exception {
        int products = productRepository.findByUserLogin("b").size();
        mockMvc.perform(get("/user/userProducts")).andExpect(status().isOk())
                .andExpect(model().attribute("userProducts", hasSize(products)));
    }
}



