package org.course.coursework.service;

import org.course.coursework.entity.Ticket;
import org.course.coursework.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;
    public Ticket getTicketById(Long  id){
        Optional<Ticket> ticket = ticketRepo.findById(id);
        if (ticket.isPresent())
            return ticket.get();
        return null;
    }

    public Ticket getTicketByPlace(String seatNumber, Long id){
        return ticketRepo.findTicketBySeatNumberAndFlight_Id(seatNumber, id);
    }

    public void saveTicket(Ticket ticket){
        ticketRepo.save(ticket);
    }

}
