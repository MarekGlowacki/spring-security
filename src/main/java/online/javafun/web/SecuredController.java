package online.javafun.web;

import online.javafun.message.WelcomeMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecuredController {

    private final WelcomeMessageService welcomeMessageService;

    public SecuredController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/secured")
    String home(@RequestParam(defaultValue = "en") String lang, Model model) {
        model.addAttribute("lang", lang);
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "secured";
    }
}
