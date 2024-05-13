package org.course.coursework.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.course.coursework.dto.PassportDTO;
import org.course.coursework.dto.UserDTO;
import org.course.coursework.dto.UserRegistrationDTO;
import org.course.coursework.entity.User;
import org.course.coursework.exception.UserAlreadyExistsException;
import org.course.coursework.exception.UserNotFoundException;
import org.course.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/register")
    public String getRegPage(){
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute UserRegistrationDTO registrationDTO){
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return new ModelAndView("register", "passwordError", "Пароли не совпадают");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(registrationDTO.getUsername());
        userDTO.setEmail(registrationDTO.getEmail());
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setFirstName(registrationDTO.getFirstName());
        passportDTO.setLastName(registrationDTO.getLastName());
        passportDTO.setSecondName(registrationDTO.getSecondName());
        passportDTO.setAge(registrationDTO.getAge());
        userDTO.setPassportDTO(passportDTO);
        User newUser = userDTO.toEntity();
        newUser.setPasswordHash(passwordEncoder.encode(registrationDTO.getPassword()));
        try {
            userService.addUser(newUser);
        }
        catch (UserAlreadyExistsException e){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("error", e.getMessage());
            return modelAndView;
        }
        catch (Exception e){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("unknownError", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("login", "success", "Registration successful");
    }
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Exception lastException = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (lastException != null) {
                model.addAttribute("error", "Неверные данные для входа");
            }
        }
        return "login";
    }
}
