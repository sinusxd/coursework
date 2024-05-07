package org.course.coursework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    Flight flight;
    @Column(name = "seat_number")
    String seatNumber;
    @Column(name = "class")
    String flight_class;
    @ManyToMany
    @JoinTable(name = "user_ticket",
    joinColumns = @JoinColumn(name = "ticket_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }
}
