package org.course.coursework.dto;

import org.course.coursework.entity.Airline;

public class AirlineDTO {
    Long id;
    String name;
    String icaoCode;

    public static AirlineDTO fromEntity(Airline airline){
        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.setId(airline.getId());
        airlineDTO.setName(airline.getName());
        airlineDTO.setIcaoCode(airline.getIcaoCode());
        return airlineDTO;
    }

    public Airline toEntity(){
        Airline airline = new Airline();
        airline.setId(this.getId());
        airline.setName(this.getName());
        airline.setIcaoCode(this.getIcaoCode());
        return airline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }
}
