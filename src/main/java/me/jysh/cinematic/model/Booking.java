package me.jysh.cinematic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonManagedReference
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private Users user;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<SeatBooked> bookedSeats;
}
