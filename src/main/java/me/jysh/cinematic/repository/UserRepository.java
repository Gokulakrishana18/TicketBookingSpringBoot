package me.jysh.cinematic.repository;

import me.jysh.cinematic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.USER_NAME = ?1")
//    User findByName(String userName);
@Query(value = "SELECT * FROM USER WHERE USER_NAME = :userName", nativeQuery = true)
User findByUsername(String userName);


//@Query("SELECT u FROM USER u WHERE u.username = :username")
// User findByName(@Param("username") String username);

}
