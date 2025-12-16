# ad-psp-2025-Ejercicio16-12

## Relaciones entre entidades
### 1. Attendee - Ticket
- **Relación**: Attendee - Ticket
- **Anotación**: @OneToMany en Attendee, @ManyToOne en Ticket
- **Justificación**: He escogido una relación bidireccional debido a que se necesita acceder a la lista de Tickets comprados por un Attendee (desde la entidad Attendee) y también se necesita saber a qué Attendee pertenece un Ticket específico (desde la entidad Ticket).

### 2. Attendee - StaffAssignment
- **Relación**: Attendee - StaffAssignment
- **Anotación**: @OneToMany en Attendee, @ManyToOne en StaffAssignment
- **Justificación**: He escogido una relación bidireccional debido a que un Attendee (actuando como miembro del staff) puede tener múltiples StaffAssignments (desde Attendee), y cada StaffAssignment debe saber a qué Attendee está asociado (desde StaffAssignment). Permite listar fácilmente todas las tareas de staff de un Attendee y viceversa.

### 3. Event - Ticket
- **Relación**: Event - Ticket
- **Anotación**: @OneToMany en Event, @ManyToOne en Ticket
- **Justificación**: He escogido una relación bidireccional debido a que es esencial conocer todos los Tickets vendidos para un Event concreto (desde Event), y cada Ticket debe saber a qué Event corresponde (desde Ticket). Esto es fundamental para las estadísticas y la gestión de entradas del evento.

### 4.Event - StaffAssignment
- **Relación**: Event - StaffAssignment
- **Anotación**: @OneToMany en Event, @ManyToOne en StaffAssignment
- **Justificación**: He escogido una relación bidireccional debido a que se requiere listar todas las StaffAssignments para un Event (desde Event), y cada StaffAssignment debe estar vinculada al Event al que pertenece (desde StaffAssignment). La bidireccionalidad facilita la administración del personal por evento.

### 5. Event - Organizer
- **Relación**: Event - Organizer
- **Anotación**: @ManyToOne en Event (la relación de Organizer a Event se analiza en el siguiente punto)
- **Justificación**: La relación definida directamente en Event es bidireccional hacia Organizer (ManyToOne). Se necesita acceder al Organizer desde el Event para saber quién lo organiza, al igual que el Organizer necesita acceder a sus eventos organizados.

### 6.Organizer - Event
- **Relación**: Organizer - Event
- **Anotación**: @OneToMany en Organizer, @ManyToOne en Event
- **Justificación**: He escogido una relación bidireccional (complementando el punto anterior) debido a que es muy probable que se necesite acceder a la lista de todos los Events organizados por un Organizer específico (desde Organizer), además de saber quién organiza un Event concreto (desde Event).
 
### 7. Event - Venue
- **Relación**: Event - Venue
- **Anotación**: @ManyToOne en Event (la relación de Venue a Event se analiza en el siguiente punto)
- **Justificación**: La relación definida directamente en Event es unidireccional hacia Venue (ManyToOne). Se necesita acceder al Venue desde el Event para saber dónde se celebra.

### 8. Venue - Event
- **Relación**: Venue - Event
- **Anotación**: @OneToMany en Venue, @ManyToOne en Event
- **Justificación**: He escogido una relación bidireccional (complementando el punto anterior) debido a que se necesita obtener la lista de todos los Events que se celebran o se han celebrado en un Venue específico (desde Venue), además de saber la localización de un Event (desde Event).