package pl.SznaKuKZie.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SznaKuKZie.project.model.Order;
import pl.SznaKuKZie.project.model.Product;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserLogin(String login);

    List<Order> findByUserUserId(long userId);
}
