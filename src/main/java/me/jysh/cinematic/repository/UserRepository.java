package me.jysh.cinematic.repository;

import me.jysh.cinematic.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {


    List<Users> findByEmail(String email);



}
