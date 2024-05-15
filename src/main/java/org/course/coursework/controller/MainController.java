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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    FlightService flightService;
    @GetMapping("/index")
    public String showForm(Model model) {
        model.addAttribute("searchDTO", new SearchDTO());
        model.addAttribute("flights", flightService.findAll().stream()
                .map(FlightDTO::fromEntity).collect(Collectors.toList()));
        return "index";
    }
    public static String formatLocalDate(LocalDate date) {
        // Получаем день месяца
        int dayOfMonth = date.getDayOfMonth();

        // Получаем название месяца на русском языке
        String month = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru"));

        // Получаем день недели на русском языке
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("ru"));

        // Форматируем строку
        return String.format("%d %s, %s", dayOfMonth, month, dayOfWeek);
    }
    @PostMapping("/index")
    public ModelAndView searchFlights(@ModelAttribute SearchDTO searchDTO){
        System.out.println(searchDTO);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject(searchDTO);
        String from = (searchDTO.getFrom().substring(0, searchDTO.getFrom().indexOf(" ")));
        String to = (searchDTO.getTo().substring(0, searchDTO.getTo().indexOf(" ")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate when = LocalDate.parse(searchDTO.getWhen(), formatter);
        modelAndView.addObject("date", MainController.formatLocalDate(when));
        String classSelect = searchDTO.getClassSelect();
        List<FlightDTO> flightDTOS = flightService.findFlights(from, to, when);
        if (flightDTOS.size() != 0){
            modelAndView.addObject("flights", flightDTOS);
        }
        return modelAndView;
    }

}
