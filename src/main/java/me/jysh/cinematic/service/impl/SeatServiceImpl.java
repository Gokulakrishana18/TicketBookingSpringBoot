package me.jysh.cinematic.service.impl;

import me.jysh.cinematic.exception.SeatNotFoundException;
import me.jysh.cinematic.model.Seat;
import me.jysh.cinematic.repository.SeatRepository;
import me.jysh.cinematic.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatRepository;

    private Logger log = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> getAllSeats(Long theater_id, Long auditorium_id) {
        System.out.println("Theater_id :"+theater_id);
        System.out.println("auditorium_id :"+auditorium_id);
        log.info("Auditorium id :",auditorium_id);
        List<Seat> filterList =seatRepository.findAll().stream().
                filter(item-> item.getAuditorium()
                .getTheatre().getId()==theater_id  ).
                collect(Collectors.toList());
        System.out.println("After the filter theater_id");
        List<Seat> secondFilter = filterList.stream().
                filter(item->item.getAuditorium().
                        getId()==auditorium_id).
                collect(Collectors.toList());
        System.out.println("After the filter");
           log.info("Second  List :",secondFilter.toString()) ;
        System.out.println("List :"+ seatRepository.findAll().toString());
        return secondFilter;
    }

    @Override
    public Seat getSeatById(Long seat_id) {
        return null;
    }

    @Override
    public Seat pushSeat(Seat newSeat) {
        return null;
    }

    @Override
    public void updateSeat(List<Seat> updatedSeat) {
        //Seat getTheSeat = new Seat();
       List<Seat> setTheValue = updatedSeat;
       for(Seat seat:setTheValue) {
           // Seat getTheSeat = new Seat();
           Long id = seat.getId();
           System.out.println("id :"+ seat.toString() +" qwr :"+id);
           Seat getTheSeatDetailsForId = seatRepository.findById(id).orElseThrow(() -> new SeatNotFoundException("Seat not found with this id"));
           System.out.println("getTheSeatDetailsForId "+ getTheSeatDetailsForId.getSeatNumber()+" "+getTheSeatDetailsForId.isBooked());
           if(!getTheSeatDetailsForId.isBooked()) {
               System.out.println("inside");
               System.out.println(seat.isBooked());
               getTheSeatDetailsForId.setBooked(true);
               seatRepository.save(getTheSeatDetailsForId);
           }
           else{
               System.out.println("inside this else part");
               throw new SeatNotFoundException("The seat is all ready booked");
           }

       }


    }

    @Override
    public void deleteSeatById(Long seat_id) {

    }
}
