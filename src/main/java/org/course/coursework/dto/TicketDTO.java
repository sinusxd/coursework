package org.course.coursework.dto;

import org.course.coursework.entity.Ticket;

public class TicketDTO {
    Long id;
    FlightDTO flightDTO;
    String seatNumber;
    String flightClass;
    UserDTO userDTO;
    Double price;

    public static TicketDTO fromEntity(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setFlightDTO(FlightDTO.fromEntity(ticket.getFlight()));
        ticketDTO.setSeatNumber(ticket.getSeatNumber());
        ticketDTO.setFlightClass(ticket.getFlightClass());
        ticketDTO.setUserDTO(UserDTO.fromEntity(ticket.getUser()));
        ticketDTO.setPrice(ticket.getPrice());
        return ticketDTO;
    }

    public Ticket toEntity(){
        Ticket ticket = new Ticket();
        ticket.setId(this.getId());
        ticket.setFlight(this.getFlightDTO().toEntity());
        ticket.setSeatNumber(this.getSeatNumber());
        ticket.setFlightClass(this.getFlightClass());
        ticket.setUser(this.getUserDTO().toEntity());
        ticket.setPrice(this.getPrice());
        return ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightDTO getFlightDTO() {
        return flightDTO;
    }

    public void setFlightDTO(FlightDTO flightDTO) {
        this.flightDTO = flightDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
