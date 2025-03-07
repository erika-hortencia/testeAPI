package ehpc.javaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ehpc.javaapi.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
