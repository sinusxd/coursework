package org.course.coursework.dto;

import org.course.coursework.entity.Ticket;

public class TicketDTO {
    Long id;
    String seatNumber;
    String flightClass;
    Double price;

    Long userId;

    public static TicketDTO fromEntity(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setSeatNumber(ticket.getSeatNumber());
        ticketDTO.setFlightClass(ticket.getFlightClass());
        ticketDTO.setPrice(ticket.getPrice());
        if (ticket.getUser() != null)
            ticketDTO.setUserId(ticket.getUser().getId());
        return ticketDTO;
    }

    public Ticket toEntity(){
        Ticket ticket = new Ticket();
        ticket.setId(this.getId());
        ticket.setSeatNumber(this.getSeatNumber());
        ticket.setFlightClass(this.getFlightClass());
        ticket.setPrice(this.getPrice());
        return ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
