package me.jysh.cinematic.controller;

import me.jysh.cinematic.model.Theatre;
import me.jysh.cinematic.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ticketBooking")
public class TheatreController {
    private TheatreService theatreService;


    private Logger log = LoggerFactory.getLogger(TheatreController.class);


    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        System.out.println("something work");
        return theatreService.getAllTheatres();


    }
    @GetMapping("/theatre")
    public String getAllTheatre() {
        System.out.println("something work");
        return "OKay";


    }
//    @PostMapping("/theater")
//    public ResponseEntity saveTheTheater(@RequestParam List<Theatre> theater){
////        return theatreService.pushTheatre(theater);
//        return null;
//
//    }

    @PostMapping("/theater")
    public void saveTheTheater(@RequestBody Theatre theater) {
         theatreService.pushTheatre(theater);
    }




}
