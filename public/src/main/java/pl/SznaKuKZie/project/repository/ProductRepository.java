package pl.SznaKuKZie.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.SznaKuKZie.project.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductId(long productId);

    List<Product> findByUserLogin(String login);

    List<Product> findAllByAvailable(boolean b);

    List<Product> findByUserUserId(long userId);

}
