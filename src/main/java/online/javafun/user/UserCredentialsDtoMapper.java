package online.javafun.user;

import online.javafun.user.dto.UserCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDtoMapper {

    static UserCredentialsDto map(User user) {
        String email = user.getEmail();
        String password = user.getEmail();
        Set<String> roles = user.getRoles().stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(email, password, roles);
    }
}
