package org.course.coursework.repository;

import org.course.coursework.entity.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends CrudRepository<Airline, Long> {
}
