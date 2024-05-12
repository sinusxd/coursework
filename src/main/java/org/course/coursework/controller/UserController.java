package org.course.coursework.controller;

import org.course.coursework.config.SecurityUtil;
import org.course.coursework.dto.FlightDTO;
import org.course.coursework.dto.TicketDTO;
import org.course.coursework.entity.Ticket;
import org.course.coursework.entity.User;
import org.course.coursework.exception.UserNotFoundException;
import org.course.coursework.service.FlightService;
import org.course.coursework.service.TicketService;
import org.course.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TicketService ticketService;

    @GetMapping("/myTickets")
    public ModelAndView showUserTickets(){
        try {
            User user = userService.findUserByName(SecurityUtil.getCurrentUsername());
            List<Ticket> ticketList = user.getTicketList();
            return new ModelAndView("user-page", "tickets", ticketList);
        }
        catch (UserNotFoundException e){
            return null;
        }


    }

}
