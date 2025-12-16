package com.salesianos.triana.ejercicicio16.repositorios;

import com.salesianos.triana.ejercicicio16.entidades.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
