package org.course.coursework.dto;

import org.course.coursework.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDTO {
    Long id;
    AirlineDTO airlineDTO;
    AirportDTO departureAirportDTO;
    AirportDTO arrivalAirportDTO;
    LocalDate departureDate;
    LocalTime departureTime;
    LocalDate arrivalDate;
    LocalTime arrivalTime;
    List<TicketDTO> ticketDTOList;

    public static FlightDTO fromEntity(Flight flight){
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flightDTO.getId());
        flightDTO.setAirlineDTO(AirlineDTO.fromEntity(flight.getAirline()));
        flightDTO.setDepartureAirportDTO(AirportDTO.fromEntity(flight.getDepartureAirport()));
        flightDTO.setArrivalAirportDTO(AirportDTO.fromEntity(flight.getArrivalAirport()));
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setDepartureTime(flight.getDepartureTime());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setArrivalTime(flight.getArrivalTime());
        if (flight.getTicketList() != null)
            flightDTO.setTicketDTOList(flight.getTicketList()
                    .stream().map(TicketDTO::fromEntity)
                    .collect(Collectors.toList()));
        return flightDTO;
    }
    public Flight toEntity(){
        Flight flight = new Flight();
        flight.setId(this.getId());
        flight.setAirline(this.getAirlineDTO().toEntity());
        flight.setDepartureAirport(this.getDepartureAirportDTO().toEntity());
        flight.setArrivalAirport(this.getArrivalAirportDTO().toEntity());
        flight.setDepartureDate(this.getDepartureDate());
        flight.setDepartureTime(this.getDepartureTime());
        flight.setArrivalDate(this.getArrivalDate());
        flight.setArrivalTime(this.getArrivalTime());
        if (this.ticketDTOList != null)
            flight.setTicketList(this.getTicketDTOList()
                    .stream().map(TicketDTO::toEntity)
                    .collect(Collectors.toList()));
        return flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirlineDTO getAirlineDTO() {
        return airlineDTO;
    }

    public void setAirlineDTO(AirlineDTO airlineDTO) {
        this.airlineDTO = airlineDTO;
    }

    public AirportDTO getDepartureAirportDTO() {
        return departureAirportDTO;
    }

    public void setDepartureAirportDTO(AirportDTO departureAirportDTO) {
        this.departureAirportDTO = departureAirportDTO;
    }

    public AirportDTO getArrivalAirportDTO() {
        return arrivalAirportDTO;
    }

    public void setArrivalAirportDTO(AirportDTO arrivalAirportDTO) {
        this.arrivalAirportDTO = arrivalAirportDTO;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<TicketDTO> getTicketDTOList() {
        return ticketDTOList;
    }

    public void setTicketDTOList(List<TicketDTO> ticketDTOList) {
        this.ticketDTOList = ticketDTOList;
    }
}
