package org.course.coursework.controller;

import org.course.coursework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    FlightService flightService;
    @GetMapping("/search")
    public List<String> searchCities(@RequestParam String query) {
        return flightService.findTop10ByQuery(query);
    }

}
