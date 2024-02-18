package me.jysh.cinematic.service;

import me.jysh.cinematic.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats(Long theater_id, Long auditorium_id);

//    List<Seat> getAllSeats(Long theater_id, long auditorium_id);

    Seat getSeatById(Long seat_id);

    Seat pushSeat(Seat newSeat);

    void updateSeat(List<Seat> updatedSeat);

    void deleteSeatById(Long seat_id);
}
