package com.salesianos.triana.ejercicicio16.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name = "unique_ticket_type_per_event_attendee",
            columnNames = {"attendee_id", "event_id", "type"}
        )
    }
)
public class Ticket
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;
    private double price;
    private LocalDateTime purchasedAt;
    @Column(unique = true)
    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


}
