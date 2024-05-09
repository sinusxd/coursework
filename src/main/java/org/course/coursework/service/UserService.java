package org.course.coursework.service;

import org.course.coursework.entity.User;
import org.course.coursework.exception.UserAlreadyExistsException;
import org.course.coursework.exception.UserNotFoundException;
import org.course.coursework.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User addUser(User user) throws UserAlreadyExistsException {
        if(userRepo.findByUsername(user.getUsername()) != null || userRepo.findByEmail(user.getEmail()) != null)
            throw new UserAlreadyExistsException("Пользователь с таким именем/почтой уже существует!");
        return userRepo.save(user);
    }
    public User findUserByName(String username) throws UserNotFoundException {
        if (userRepo.findByUsername(username) == null)
            throw new UserNotFoundException("Пользователь не найден!");
        return userRepo.findByUsername(username);
    }
    public User findUserByEmail(String email) throws UserNotFoundException {
        if (userRepo.findByEmail(email) == null)
            throw new UserNotFoundException("Пользователь не найден!");
        return userRepo.findByEmail(email);
    }
}
