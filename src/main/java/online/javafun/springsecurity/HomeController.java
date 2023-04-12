package online.javafun.springsecurity;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    String home(@CurrentSecurityContext(expression = "authentication.name") String username, Model model) {
        model.addAttribute("username", username);
        return "index";    
    }
}
