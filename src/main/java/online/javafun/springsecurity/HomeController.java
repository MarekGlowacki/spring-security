package online.javafun.springsecurity;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    String home(@CurrentSecurityContext SecurityContext context, Model model) {
        model.addAttribute("username", context.getAuthentication().getName());
        return "index";    
    }
}
