package me.jysh.cinematic.repository;

import me.jysh.cinematic.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
//    @Query("SELECT e FROM auditorium e WHERE e.theatre_id = :id")
//    List<Auditorium> findUserAuditoriumByTheaterId(Long id);
}
