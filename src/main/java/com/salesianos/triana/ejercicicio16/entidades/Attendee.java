package com.salesianos.triana.ejercicicio16.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Attendee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String email;

    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<StaffAssignment> staffAssignments = new HashSet<>();

}
