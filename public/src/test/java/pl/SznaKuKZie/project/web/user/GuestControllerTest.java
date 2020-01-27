package pl.SznaKuKZie.project.web.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuestControllerTest {
    @Autowired
    private GuestController guestController;

    @Autowired
    private MockMvc mockMvc;

       @Test
    public void contexLoads() throws Exception {
        assertThat(guestController).isNotNull();
    }

    @Test
    public void showHome() throws Exception {
        mockMvc.perform(get("/home")).andExpect(status().isOk());
    }

    @Test
    public void showAdminWhenNoUser() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().is(401));
    }

    @WithMockUser(username = "a", roles = "ADMIN")
    @Test
    public void showAdminWhenAdmin() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isOk());
    }

    @WithMockUser(username = "b", roles = "USER")
    @Test
    public void showUserWhenUser() throws Exception {
        mockMvc.perform(get("/user/userProducts")).andExpect(status().isOk());
    }

    @WithMockUser(username = "b", roles = "USER")
    @Test
    public void notShowAdminWhenUser() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().is(403));
    }

}