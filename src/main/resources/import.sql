-- ---------------------------------
-- 1. ORGANIZERS
-- Atributos: (name, email)
-- ---------------------------------
INSERT INTO organizer (name, email) VALUES ('TechConferences S.L.', 'info@techconf.com');
INSERT INTO organizer (name, email) VALUES ('MusicFest Group', 'contact@musicfest.org');

-- ---------------------------------
-- 2. VENUES
-- Atributos: (name, address)
-- ---------------------------------
INSERT INTO venue (name, address) VALUES ('Fira Gran Via', 'Av. Joan Carles I, 64');
INSERT INTO venue (name, address) VALUES ('Sala Apollo', 'C/ Nou de la Rambla, 113');

-- ---------------------------------
-- 3. ATTENDEES (Usuarios)
-- Atributos: (first_name, email)
-- ---------------------------------
INSERT INTO attendee (first_name, email) VALUES ('Laura García', 'laura.garcia@email.com');
INSERT INTO attendee (first_name, email) VALUES ('Pedro Ruiz', 'pedro.ruiz@email.com');
INSERT INTO attendee (first_name, email) VALUES ('Sofía Martínez', 'sofia.mtz@email.com');
INSERT INTO attendee (first_name, email) VALUES ('Javier López', 'javi.lopez@email.com');
INSERT INTO attendee (first_name, email) VALUES ('Elena Torres', 'elena.torres@email.com');

-- ---------------------------------
-- 4. EVENTS
-- Atributos: (title, description, event_date_time, organizer_id, venue_id)
-- Nota: organizer_id y venue_id ahora se refieren a las IDs autogeneradas (1, 2, 3...)
-- ---------------------------------
-- Evento 1: Organizer 1, Venue 1
INSERT INTO event (title, description,  organizer_id, venue_id) VALUES ('Future Tech Summit', 'Conferencia sobre IA y Big Data.', 1, 1);
-- Evento 2: Organizer 2, Venue 2
INSERT INTO event (title, description,  organizer_id, venue_id) VALUES ('Indie Rock Night', 'Concierto de bandas emergentes.', 2, 2);
-- Evento 3: Organizer 1, Venue 1
INSERT INTO event (title, description,  organizer_id, venue_id) VALUES ('Cyber Security Day', 'Taller y networking sobre seguridad.', 1, 1);

-- ---------------------------------
-- 5. TICKETS
-- Atributos: (attendee_id, event_id, type, price, purchased_at, qr_code)
-- Nota: `type` debe coincidir con el Enum (STANDARD, VIP)
-- ---------------------------------
-- Evento 1 (Future Tech Summit)
INSERT INTO ticket (attendee_id, event_id, type, price, purchased_at, qr_code) VALUES (1, 1, 'STANDARD', 250.00, '2025-03-01 10:00:00', 'QR-FT-A1-STD'); -- Laura
INSERT INTO ticket (attendee_id, event_id, type, price, purchased_at, qr_code) VALUES (2, 1, 'VIP', 500.00, '2025-03-05 11:30:00', 'QR-FT-A2-VIP');   -- Pedro

-- Evento 2 (Indie Rock Night)
INSERT INTO ticket (attendee_id, event_id, type, price, purchased_at, qr_code) VALUES (3, 2, 'STANDARD', 30.00, '2025-06-10 15:00:00', 'QR-IR-A3-STD'); -- Sofía
INSERT INTO ticket (attendee_id, event_id, type, price, purchased_at, qr_code) VALUES (4, 2, 'STANDARD', 30.00, '2025-06-11 16:00:00', 'QR-IR-A4-STD'); -- Javier

-- Evento 3 (Cyber Security Day)
INSERT INTO ticket (attendee_id, event_id, type, price, purchased_at, qr_code) VALUES (5, 3, 'STANDARD', 150.00, '2025-07-25 09:00:00', 'QR-CS-A5-STD'); -- Elena

-- ---------------------------------
-- 6. STAFF ASSIGNMENTS
-- Atributos: (attendee_id, event_id, role, shift_start, shift_end, paid)
-- Nota: `role` debe coincidir con el Enum (SECURITY, USHER, TECH)
-- ---------------------------------
-- Evento 1 (Future Tech Summit)
INSERT INTO staff_assignment (attendee_id, event_id, role, shift_start, shift_end, paid) VALUES (4, 1, 'TECH', '2025-07-20 07:00:00', '2025-07-20 18:00:00', TRUE);   -- Javier (Staff Técnico)
INSERT INTO staff_assignment (attendee_id, event_id, role, shift_start, shift_end, paid) VALUES (5, 1, 'USHER', '2025-07-20 08:30:00', '2025-07-20 13:00:00', FALSE); -- Elena (Staff Acomodador)

-- Evento 2 (Indie Rock Night)
INSERT INTO staff_assignment (attendee_id, event_id, role, shift_start, shift_end, paid) VALUES (1, 2, 'SECURITY', '2025-08-15 20:00:00', '2025-08-16 02:00:00', TRUE);  -- Laura (Staff Seguridad)