package online.javafun.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findUsersByRoles_Name(String rolesName);
    void deleteByEmail(String email);
}