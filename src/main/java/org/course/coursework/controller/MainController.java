package org.course.coursework.controller;

import org.course.coursework.dto.FlightDTO;
import org.course.coursework.dto.SearchDTO;
import org.course.coursework.entity.User;
import org.course.coursework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
@Controller
public class MainController {
    @Autowired
    FlightService flightService;
    @GetMapping("/index")
    public String showForm(Model model) {
        model.addAttribute("searchDTO", new SearchDTO());
        return "index";
    }

    @PostMapping("/index")
    public ModelAndView searchFlights(@ModelAttribute SearchDTO searchDTO){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject(searchDTO);
        String from = (searchDTO.getFrom().substring(0, searchDTO.getFrom().indexOf(" ")));
        String to = (searchDTO.getTo().substring(0, searchDTO.getTo().indexOf(" ")));
        List<FlightDTO> flightDTOS = flightService.findFlights(from, to);
        if (flightDTOS.size() != 0){
            modelAndView.addObject("flights", flightDTOS);
        }
        return modelAndView;
    }

}
