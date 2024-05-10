package org.course.coursework.service;

import org.course.coursework.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    AirportRepo airportRepo;
    public List<String> findTop10ByQue(String query){
        return airportRepo.findTop10ByCityStartingWith(query)
                .stream().map(el -> el.getCity() + " (" + el.getAirportCode() + "), " +
                        el.getCountry())
                .collect(Collectors.toList());
    }
}
