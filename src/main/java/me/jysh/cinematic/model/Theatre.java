package me.jysh.cinematic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Id;
import lombok.*;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "theatre_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name ="location")
    private String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
//  @JsonBackReference
    @JsonIgnore
    private Set<Auditorium> auditoriums;
}
