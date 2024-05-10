package org.course.coursework.controller;

import org.course.coursework.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {
    @Autowired
    AirportService airportService;
    @GetMapping("/search")
    public List<String> searchCities(@RequestParam String query) {
        return airportService.findTop10ByQue(query);
    }
}
