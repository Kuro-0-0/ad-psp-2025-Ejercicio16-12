package com.salesianos.triana.ejercicicio16.repositorios;

import com.salesianos.triana.ejercicicio16.entidades.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>
{
}
