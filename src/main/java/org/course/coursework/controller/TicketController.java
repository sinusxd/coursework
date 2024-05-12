package org.course.coursework.controller;

import org.course.coursework.dto.FlightDTO;
import org.course.coursework.dto.TicketDTO;
import org.course.coursework.entity.Ticket;
import org.course.coursework.exception.FlightNotFoundException;
import org.course.coursework.repository.TicketRepo;
import org.course.coursework.service.FlightService;
import org.course.coursework.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    FlightService flightService;

    @GetMapping("/getTicketsByFlightId/{flightId}")
    public ResponseEntity getTicketsByFlightId(@PathVariable Long flightId){
        System.out.println(flightId);

        FlightDTO flight = null;
        try {
            flight = flightService.findFlightById(flightId);
        }
        catch (FlightNotFoundException e){
            return ResponseEntity.badRequest().body("Такой полет не найден");
        }

        return ResponseEntity.ok(flight.getTicketDTOList());
    }



}
