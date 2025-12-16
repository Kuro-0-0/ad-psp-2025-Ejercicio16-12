package com.salesianos.triana.ejercicicio16.repositorios;

import com.salesianos.triana.ejercicicio16.entidades.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
