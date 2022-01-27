package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long>{

}
