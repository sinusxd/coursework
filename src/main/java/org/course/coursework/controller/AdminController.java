package org.course.coursework.controller;

import org.course.coursework.entity.Airline;
import org.course.coursework.entity.Airport;
import org.course.coursework.entity.Flight;
import org.course.coursework.service.AirlineService;
import org.course.coursework.service.AirportService;
import org.course.coursework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/admin")
    public String adminHome(Model model) {
        model.addAttribute("airlines", airlineService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("flights", flightService.findAll());
        return "admin";
    }

    @PostMapping("/admin/airports/add")
    public ModelAndView addAirport(Airport airport){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        String status = airportService.addAirport(airport);
        if (!status.equals("success"))
            modelAndView.addObject("error", status);
        return modelAndView;
    }

    @PostMapping("/admin/airlines/add")
    public ModelAndView addAirline(Airline airline){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        String status = airlineService.addAirline(airline);
        if (!status.equals("success"))
            modelAndView.addObject("error", status);
        return modelAndView;
    }

    @DeleteMapping("/admin/flights/add")
    public ModelAndView addFlight(Flight flight){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        String status = flightService.addFlight(flight);
        if (!status.equals("success"))
            modelAndView.addObject("error", status);
        return modelAndView;
    }

    @GetMapping("/admin/airports/delete/{id}")
    public ModelAndView removeAirport(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        airportService.deleteAirport(id);
        return modelAndView;
    }

    @GetMapping("/admin/airlines/delete/{id}")
    public ModelAndView removeAirline(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        airlineService.deleteAirline(id);
        return modelAndView;
    }


    @GetMapping("/admin/flights/delete/{id}")
    public ModelAndView removeFlight(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        flightService.deleteFlight(id);
        return modelAndView;
    }
}
