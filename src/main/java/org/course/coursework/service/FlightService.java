package org.course.coursework.service;

import org.course.coursework.dto.FlightDTO;
import org.course.coursework.entity.Flight;
import org.course.coursework.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    public List<String> findTop10ByQuery(String query){
        return flightRepo.findTop10ByArrivalAirport_CityStartingWith(query)
                .stream().map(el -> el.getArrivalAirport().getCity())
                .collect(Collectors.toList());
    }
}
