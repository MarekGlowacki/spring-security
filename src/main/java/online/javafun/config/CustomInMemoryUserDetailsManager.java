package online.javafun.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {
    public CustomInMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder();

        String password1 = "{bcrypt}" + new BCryptPasswordEncoder().encode("hard");
        System.out.println(password1);
        UserDetails admin = userBuilder.username("superadmin").password(password1).roles("ADMIN").build();

        String password2 = "{MD5}" + new MessageDigestPasswordEncoder("MD5").encode("dog.8");
        System.out.println(password2);
        UserDetails user1 = userBuilder.username("john").password(password2).roles("USER").build();

        String password3 = "{argon2}" + Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8().encode("javaiscool");
        System.out.println(password3);
        UserDetails user2 = userBuilder.username("java").password(password3).roles("USER").build();

        createUser(admin);
        createUser(user1);
        createUser(user2);
    }
}
