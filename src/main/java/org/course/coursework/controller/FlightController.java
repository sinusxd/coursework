package org.course.coursework.controller;

import org.course.coursework.config.SecurityUtil;
import org.course.coursework.dto.FlightDTO;
import org.course.coursework.entity.Flight;
import org.course.coursework.entity.User;
import org.course.coursework.exception.FlightNotFoundException;
import org.course.coursework.exception.UserNotFoundException;
import org.course.coursework.service.FlightService;
import org.course.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    UserService userService;
    @GetMapping("/view-ticket")
    public String viewTicket(@RequestParam("flightId") Long flightId, Model model){
        FlightDTO flight = null;
        try {
            flight = flightService.findFlightById(flightId);
        }
        catch (FlightNotFoundException e){
            model.addAttribute("error", e.getMessage());
            return "view-ticket";
        }
        model.addAttribute("flight", flight);
        try {
            User user = userService.findUserByName(SecurityUtil.getCurrentUsername());
            model.addAttribute("passport", user.getPassport());
        }
        catch (UserNotFoundException e){
            model.addAttribute("error", e.getMessage());
        }

        return "view-ticket";
    }

}
