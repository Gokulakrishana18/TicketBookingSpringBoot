package me.jysh.cinematic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Id;
//import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
@Entity

@Table(name = "auditorium")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auditorium_id")
    private Long id;

    @Column(name = "seat_count")
    private Integer seatCount;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    //@JsonManagedReference
    private Theatre theatre;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    //@JsonBackReference
    //@JsonManagedReference
    @JsonIgnore
    @JsonIgnoreProperties("auditorium")
    private Set<Seat> seats;

//    @ManyToOne
//    @JoinColumn(name = "theatre_id")
//   @JsonManagedReference
//    private Theatre theatre;
//
//    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
//    //@JsonBackReference
//    @JsonIgnoreProperties("auditorium")
//    private List<Seat> seats;

    //@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<Screening> screenings;
}
