package org.course.coursework.controller;

import org.course.coursework.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class MainController {
    @GetMapping("/index")
    public String showForm(Model model) {
        List<String> categories = Arrays.asList("Technology", "Business", "Education");
        model.addAttribute("categories", categories);

        // Если есть объект, связанный с формой
        model.addAttribute("user", new User());
        return "index";
    }

}
