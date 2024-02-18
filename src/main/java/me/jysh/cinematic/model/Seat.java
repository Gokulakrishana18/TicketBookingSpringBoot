package me.jysh.cinematic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private Long id;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name="is_booked")
    private boolean isBooked;

    @Column(name="seat_type")
    private String seatType;

    @Column(name="seat_price")
    private int seatPrice;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
   // @JsonManagedReference
  // @JsonBackReference

    private Auditorium auditorium;

//    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<SeatBooked> bookedSeats;
}