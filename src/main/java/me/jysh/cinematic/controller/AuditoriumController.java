package me.jysh.cinematic.controller;

import me.jysh.cinematic.model.Auditorium;
import me.jysh.cinematic.service.AuditoriumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticketBooking")
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    private Logger log = LoggerFactory.getLogger(AuditoriumController.class);

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/auditoriums")
    public List<Auditorium> getAllTheatres() {
        return auditoriumService.getAllAuditoriums();
    }

    @GetMapping("/{theater_id}/auditoriums")
    public ResponseEntity<?> getAuditoriumForSpecificTheater(@PathVariable Long theater_id){
       log.info("some things works");
      List<Auditorium> auditoriumList =   auditoriumService.getAuditoriumByTheaterId(theater_id);
        return ResponseEntity.status(HttpStatus.OK).body(auditoriumList);
    }
}
