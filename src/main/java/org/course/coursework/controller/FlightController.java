package org.course.coursework.controller;

import org.course.coursework.config.SecurityUtil;
import org.course.coursework.dto.FlightDTO;
import org.course.coursework.entity.Flight;
import org.course.coursework.entity.Ticket;
import org.course.coursework.entity.User;
import org.course.coursework.exception.FlightNotFoundException;
import org.course.coursework.exception.UserNotFoundException;
import org.course.coursework.service.FlightService;
import org.course.coursework.service.TicketService;
import org.course.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    UserService userService;
    @Autowired
    TicketService ticketService;
    @GetMapping("/view-ticket")
    public String viewTicket(@RequestParam("flightId") Long flightId, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);
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

    @PostMapping("/view-ticket")
    public ModelAndView bookTicketAtFlight(@RequestParam("flightId") Long id, @RequestParam("ticketPlace") String ticketPlace){

        ModelAndView modelAndView = new ModelAndView("redirect");
        Ticket ticket = ticketService.getTicketByPlace(ticketPlace, id);
        User user = null;
        try {
            user = userService.findUserByName(SecurityUtil.getCurrentUsername());
        }
        catch (UserNotFoundException e){
            modelAndView.addObject("error", e.getMessage());
            return modelAndView;
        }
        ticket.setUser(user);
        ticketService.saveTicket(ticket);
        return new ModelAndView("redirect", "success", "Билет успешно забронирован!");
    }

}
