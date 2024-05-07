package org.course.coursework.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    Airline airline;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id")
    Airport departureAirport;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id")
    Airport arrivalAirport;
    @Column(name = "departure_date")
    LocalDate departureDate;
    @Column(name = "departure_time")
    LocalTime departureTime;
    @Column(name = "arrival_date")
    LocalDate arrivalDate;
    @Column(name = "arrival_time")
    LocalTime arrivalTime;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    List<Ticket> ticketList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Boolean addTicket(Ticket ticket){
        if (ticketList != null)
            return ticketList.add(ticket);
        return false;
    }
}
