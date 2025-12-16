package com.salesianos.triana.ejercicicio16.entidades;

import jakarta.persistence.*;
import lombok.*;

import javax.accessibility.AccessibleText;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StaffAssignment {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @EmbeddedId
    private StaffAssignmentPK id = new StaffAssignmentPK();

    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;
    private boolean paid;

    @ManyToOne
    @MapsId("attendeeId")
    @JoinColumn(name = "attendee_id")
    private Attendee attendee;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

}
