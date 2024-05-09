package org.course.coursework.controller;

import org.course.coursework.repository.TicketRepo;
import org.course.coursework.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;


}
