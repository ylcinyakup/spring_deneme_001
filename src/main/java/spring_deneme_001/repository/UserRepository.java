package spring_deneme_001.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_deneme_001.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
