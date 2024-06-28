package site.lawmate.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.lawmate.oauth.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // 중복 가입 확인
}
