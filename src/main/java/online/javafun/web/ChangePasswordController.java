package online.javafun.web;

import online.javafun.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
    private UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword) {
        userService.changeCurrentUserPassword(newPassword);
        return "redirect:/logout";
    }
}
