package com.salesianos.triana.ejercicicio16.servicios;

import com.salesianos.triana.ejercicicio16.entidades.*;
import com.salesianos.triana.ejercicicio16.repositorios.*;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainService {

    private final VenueRepository venueRepository;
    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    private final TicketRepository ticketRepository;
    private final AttendeeRepository attendeeRepository;
    private final StaffAssignmentRepository staffAssignmentRepository;

    public Event createEvent(Event event) {
        Event newEvent = Event.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .venue(venueRepository.getReferenceById(event.getVenue().getId()))
                .organizer(organizerRepository.getReferenceById(event.getOrganizer().getId()))
                .build();
        return eventRepository.save(newEvent);
    }

    public Ticket buyTicket(Ticket ticket) {

        Attendee attendee = attendeeRepository.findById(ticket.getAttendee().getId()).orElseThrow(NoSuchElementException::new);
        Event event = eventRepository.findById(ticket.getEvent().getId()).orElseThrow(NoSuchElementException::new);

        if (attendee.getTickets().stream().anyMatch(t -> t.getEvent() == event && t.getType() == ticket.getType())) {
            throw new IllegalArgumentException("El asistente ya tiene un ticket de este tipo para el evento.");
        }

        Ticket newTicket = Ticket.builder()
                .type(ticket.getType())
                .price(ticket.getPrice())
                .purchasedAt(LocalDateTime.now())
                .qrCode(ticket.getQrCode())
                .attendee(attendee)
                .event(event)
                .build();

        return ticketRepository.save(newTicket);
    };

    public StaffAssignment assignStaffToEvent(StaffAssignment staffAssignment) {

        StaffAssignment newStaffAssignment = StaffAssignment.builder()
                .role(staffAssignment.getRole())
                .shiftStart(staffAssignment.getShiftStart())
                .shiftEnd(staffAssignment.getShiftEnd())
                .paid(staffAssignment.isPaid())
                .attendee(attendeeRepository.getReferenceById(staffAssignment.getAttendee().getId()))
                .event(eventRepository.getReferenceById(staffAssignment.getEvent().getId()))
                .build();

        return staffAssignmentRepository.save(newStaffAssignment);
    }

    public Set<Ticket> listTicketsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(NoSuchElementException::new);
        return event.getTickets();
    }

    public Set<Ticket> listTicketByVenue(Long venueId) {
        Venue venue = venueRepository.findById(venueId).orElseThrow(NoSuchElementException::new);
        return venue.getEvents().stream().flatMap(e -> e.getTickets().stream()).collect(Collectors.toSet());
    }

}
