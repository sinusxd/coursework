package org.course.coursework.repository;

import org.course.coursework.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> { }
