package org.course.coursework.dto;

import org.course.coursework.entity.Passport;
import org.course.coursework.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    Long id;
    String username;
    String email;
    PassportDTO passportDTO;
    List<TicketDTO> ticketDTOList;

    public static UserDTO fromEntity(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassportDTO(PassportDTO.fromEntity(user.getPassport()));
        if (user.getTicketList() != null)
            userDTO.setTicketDTOList(user.getTicketList()
                    .stream().map(TicketDTO::fromEntity)
                    .collect(Collectors.toList()));
        return userDTO;
    }
    public User toEntity(){
        User user = new User();
        user.setId(this.getId());
        user.setUsername(this.getUsername());
        user.setEmail(this.getEmail());
        if(this.getPassportDTO() != null)
            user.setPassport(this.getPassportDTO().toEntity());
        if (ticketDTOList != null)
            user.setTicketList(this.getTicketDTOList()
                    .stream().map(TicketDTO::toEntity).collect(Collectors.toList()));
        return user;
    }

    public boolean addTicket(TicketDTO ticketDTO){
        if (ticketDTOList != null)
            return ticketDTOList.add(ticketDTO);
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PassportDTO getPassportDTO() {
        return passportDTO;
    }

    public void setPassportDTO(PassportDTO passportDTO) {
        this.passportDTO = passportDTO;
    }

    public List<TicketDTO> getTicketDTOList() {
        return ticketDTOList;
    }

    public void setTicketDTOList(List<TicketDTO> ticketDTOList) {
        this.ticketDTOList = ticketDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passportDTO=" + passportDTO +
                ", ticketDTOList=" + ticketDTOList +
                '}';
    }
}
