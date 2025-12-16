package com.salesianos.triana.ejercicicio16.repositorios;

import com.salesianos.triana.ejercicicio16.entidades.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
