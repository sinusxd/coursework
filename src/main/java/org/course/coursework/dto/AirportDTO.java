package org.course.coursework.dto;

import org.course.coursework.entity.Airport;

public class AirportDTO {
    Long id;
    String airportCode;
    String airportName;
    String city;
    String country;

    public static AirportDTO fromEntity(Airport airport){
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setId(airport.getId());
        airportDTO.setAirportCode(airport.getAirportCode());
        airportDTO.setAirportName(airport.getAirportName());
        airportDTO.setCity(airport.getCity());
        airportDTO.setCountry(airport.getCountry());
        return airportDTO;
    }
    public Airport toEntity(){
        Airport airport = new Airport();
        airport.setId(this.getId());
        airport.setAirportCode(this.getAirportCode());
        airport.setAirportName(this.getAirportName());
        airport.setCity(this.getCity());
        airport.setCountry(this.getCountry());
        return airport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
