package me.jysh.cinematic.controller;


import me.jysh.cinematic.model.Seat;
import me.jysh.cinematic.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeatController {
    private SeatService seatService;

    private Logger log = LoggerFactory.getLogger(SeatController.class);

    private List<Seat> getTheAllSeat ;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

//    log.info("Inside the Cintroller page");

    @GetMapping("/{theater_id}/{auditorium_id}/seats")
    public List<Seat> getAllSeats(@PathVariable Long theater_id,@PathVariable Long auditorium_id) {
        log.info("Something working");
        getTheAllSeat = seatService.getAllSeats(theater_id,auditorium_id);
        return getTheAllSeat;
    }

    @GetMapping("/{seat_id}/seat")
    public List<Seat> getTheSeat (@PathVariable Long seat_id) {
        if (getTheAllSeat.isEmpty()) {
            System.out.println("Something went wrong");
            return null;
        } else {
            System.out.println("getTheAllSeat :" + getTheAllSeat);
            List<Seat> seatDetails = getTheAllSeat.stream().filter(item -> item.getSeatNumber().intValue() == seat_id).collect(Collectors.toList());
            System.out.println("seatDetails :" + seatDetails);
            return seatDetails;
        }
    }
    @PutMapping (value="/bookingSeat", consumes = "*/*")
        public String UpdateTheSeat (@RequestBody  List<Seat> seat)
        {
            log.info("Some thing work");
            System.out.println("inside the Update Statement");
         //String isUpdateOrNot = seatService.updateSeat(seat);
          return "isUpdateOrNot";
        }


}
