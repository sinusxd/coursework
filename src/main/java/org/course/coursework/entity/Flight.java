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
    @OneToOne
    @JoinColumn(name = "airline_id")
    Airline airline;
    @OneToOne
    @JoinColumn(name = "departure_airport_id")
    Airport departureAirport;
    @OneToOne
    @JoinColumn(name = "arrival_airport_id")
    Airport arrivalAirport;
    @Column(name = "departure_date")
    LocalDate departureDate;
    @Column(name = "arrival_time")
    LocalTime arrivalTime;
    @Column(name = "arrival_date")
    LocalDate arrivalDate;
    @Column(name = "departure_time")
    LocalTime departureTime;
    @OneToMany(mappedBy = "flight")
    List<Ticket> ticketList;
}
