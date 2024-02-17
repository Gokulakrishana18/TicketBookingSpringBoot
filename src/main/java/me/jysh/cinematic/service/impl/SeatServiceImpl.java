package me.jysh.cinematic.service.impl;

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
        List<Seat> filterList =seatRepository.findAll().stream().filter(item-> item.getAuditorium()
                .getTheatre().getId()==theater_id  ).
                collect(Collectors.toList());
        List<Seat> secondFilter = filterList.stream().
                filter(item->item.getAuditorium().
                        getId()==auditorium_id).
                collect(Collectors.toList());
       log.info("Second  List :",secondFilter.toString()) ;
//        && item.getAuditorium().
//                getTheatre().getId()==theater_id
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
    public String updateSeat(Seat updatedSeat) {
        //Seat getTheSeat = new Seat();
       List<Seat> setTheValue = Collections.singletonList(updatedSeat);
       for(Seat seat:setTheValue){
          // Seat getTheSeat = new Seat();
         Long id =   seat.getId();
         Seat getTheSeatDetailsForId = seatRepository.findById(id).get();
           getTheSeatDetailsForId.setBooked(seat.isBooked());
           getTheSeatDetailsForId.setSeatNumber(seat.getSeatNumber());
           getTheSeatDetailsForId.setSeatPrice(seat.getSeatPrice());
           getTheSeatDetailsForId.setSeatType(seat.getSeatType());
          seatRepository.save(getTheSeatDetailsForId);
       }
        return "Okay";
    }

    @Override
    public void deleteSeatById(Long seat_id) {

    }
}
