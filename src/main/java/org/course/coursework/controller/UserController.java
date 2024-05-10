package org.course.coursework.controller;

import org.course.coursework.dto.FlightDTO;
import org.course.coursework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    FlightService flightService;

}
