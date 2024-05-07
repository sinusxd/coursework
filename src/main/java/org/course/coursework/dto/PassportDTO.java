package org.course.coursework.dto;

import org.course.coursework.entity.Passport;

public class PassportDTO {
    Long id;
    String lastName;
    String firstName;
    String secondName;
    Integer age;
    UserDTO userDTO;

    public static PassportDTO fromEntity(Passport passport){
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setId(passport.getId());
        passportDTO.setLastName(passport.getLastName());
        passportDTO.setFirstName(passport.getFirstName());
        passportDTO.setSecondName(passport.getSecondName());
        passportDTO.setAge(passport.getAge());
        return passportDTO;
    }

    public Passport toEntity(){
        Passport passport = new Passport();
        passport.setId(this.getId());
        passport.setLastName(this.getLastName());
        passport.setFirstName(this.getFirstName());
        passport.setSecondName(this.getSecondName());
        passport.setAge(this.getAge());
        return passport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
