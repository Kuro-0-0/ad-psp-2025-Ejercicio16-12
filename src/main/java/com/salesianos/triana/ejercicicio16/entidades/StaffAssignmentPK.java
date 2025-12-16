package com.salesianos.triana.ejercicicio16.entidades;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class StaffAssignmentPK implements Serializable {

    private Long attendeeId;
    private Long eventId;
}
