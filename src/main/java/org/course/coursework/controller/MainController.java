package org.course.coursework.controller;

import org.course.coursework.dto.SearchDTO;
import org.course.coursework.entity.User;
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
    @GetMapping("/index")
    public String showForm(Model model) {
        model.addAttribute("searchDTO", new SearchDTO());
        return "index";
    }

    @PostMapping("/index")
    public ModelAndView searchFlights(@ModelAttribute SearchDTO searchDTO){
        System.out.println(searchDTO.toString());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("criteria", searchDTO);
        return modelAndView;
    }

}
