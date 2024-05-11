package org.course.coursework.service;

import org.course.coursework.dto.FlightDTO;
import org.course.coursework.entity.Flight;
import org.course.coursework.exception.FlightNotFoundException;
import org.course.coursework.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    public List<String> findTop10ByQuery(String query){
        return flightRepo.findTop10ByArrivalAirport_CityStartingWith(query)
                .stream().map(el -> el.getArrivalAirport().getCity() + " (" + el.getArrivalAirport().getAirportCode() +
                        "), " + el.getArrivalAirport().getCountry())
                .collect(Collectors.toList());
    }

    public List<FlightDTO> findFlights(String from, String to){
        return flightRepo.findFlightsByDepartureAirport_CityAndArrivalAirport_City(from, to)
                .stream().map(FlightDTO::fromEntity).collect(Collectors.toList());

    }
    public FlightDTO findFlightById(Long id) throws FlightNotFoundException {
        Optional<Flight> flight = flightRepo.findById(id);
        if (flight.isPresent()){
            return FlightDTO.fromEntity(flight.get());
        }
        throw new FlightNotFoundException("Полета с id: " + id + " не найдено!");
    }
}
