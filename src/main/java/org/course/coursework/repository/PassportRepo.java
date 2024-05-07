package org.course.coursework.repository;

import org.course.coursework.entity.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends CrudRepository<Passport, Long> {
}
