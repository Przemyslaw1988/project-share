package pl.SznaKuKZie.project.web.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.SznaKuKZie.project.model.Order;
import pl.SznaKuKZie.project.repository.OrderRepository;
import pl.SznaKuKZie.project.repository.UserRepository;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("role")
    public String currentUserName(Principal principal) {
        if (principal != null) {

            return userRepository.findByLogin(principal.getName()).getRole().toString();
        }
        return "anonymous";
    }

    @ModelAttribute("userOrder")
    public List<Order> getUserOrders(Authentication authentication) {
        final String name = authentication.getName();
        return orderRepository.findByUserLogin(name);
    }


    @GetMapping("/userOrder")
    public String showUserOrders() {
        return "user/orderList";
    }

}


