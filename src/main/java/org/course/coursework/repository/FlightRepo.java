package org.course.coursework.repository;

import org.course.coursework.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Long> {
    List<Flight> findTop10ByArrivalAirport_CityStartingWith(String query);
    List<Flight> findFlightsByDepartureAirport_CityAndArrivalAirport_City(String departureCity, String arrivalCity);
}
