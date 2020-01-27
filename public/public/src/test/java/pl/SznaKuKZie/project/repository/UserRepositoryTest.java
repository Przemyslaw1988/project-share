package pl.SznaKuKZie.project.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import pl.SznaKuKZie.project.model.User;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class UserRepositoryTest {

        @Autowired
        private UserRepository userRepository;

        @Before

        @Test
        public void saveTest() {
            User user = new User();
            user.setPassword("z");
            user.setApproved(true);
            user.setRole(User.Role.ADMIN);
            user.setEmail("a@a");
            user.setFirstname("z");
            user.setLastname("d");
            user.setLogin("da");
            user.setUserId(5);
            userRepository.save(user);
            Assert.assertNotNull(userRepository.findByLogin("da"));
            assertThat(userRepository.findByLogin("da")).isEqualTo(user);
        }

        @WithMockUser(username = "a", roles = "ADMIN")
        @Test
        public void deleteUser() {
            User user = new User();
            user.setPassword("z");
            user.setApproved(true);
            user.setRole(User.Role.ADMIN);
            user.setEmail("a@a");
            user.setFirstname("z");
            user.setLastname("d");
            user.setLogin("da");
            user.setUserId(5);
            userRepository.save(user);
            Assert.assertNotNull(user);
            userRepository.delete(user);
            Assert.assertNull(userRepository.findByLogin("da"));
            assertThat(userRepository.findByLogin("da")).isNull();
        }
}