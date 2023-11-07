package de.ait.ksdemo.repositories;


import de.ait.ksdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsById(Long id);
}
