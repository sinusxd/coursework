package org.course.coursework.service;

import org.course.coursework.entity.Airline;
import org.course.coursework.entity.Flight;
import org.course.coursework.repository.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    AirlineRepo airlineRepo;
    public List<Airline> findAll(){
        return (List<Airline>) airlineRepo.findAll();
    }

    public String addAirline(Airline airline){
        try {
            airlineRepo.save(airline);
        }
        catch (Exception e){
            return e.getMessage();
        }
        return "success";
    }
    public void deleteAirline(Long id){
        airlineRepo.deleteById(id);
    }
}
