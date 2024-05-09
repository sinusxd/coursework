package org.course.coursework.service;

import org.course.coursework.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;

}
