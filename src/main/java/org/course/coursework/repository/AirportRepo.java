package org.course.coursework.repository;

import org.course.coursework.entity.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepo extends CrudRepository<Airport, Long> {
    List<Airport> findTop10ByCityStartingWith(String query);
}
