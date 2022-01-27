package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Timesheet;
import net.javaguides.springboot.repository.TimesheetRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/api/v1/")
public class TimesheetController {

	@Autowired
	private TimesheetRepository timesheetRepository;

	// get all timesheets
	@GetMapping("/timesheets")
	public List<Timesheet> getAllTimesheets() {
		return timesheetRepository.findAll();
	}

	@GetMapping("/student")
	public String getStudent() {
		return "Welcome student";
	}

	// create timesheet rest api
	@PostMapping("/timesheets")
	public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
		return timesheetRepository.save(timesheet);
	}

	// get timesheet by id rest api
	@GetMapping("/timesheets/{id}")
	public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
		Timesheet timesheet = timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exist with id :" + id));
		return ResponseEntity.ok(timesheet);
	}

	// update timesheet rest api

	@PutMapping("/timesheets/{id}")
	public ResponseEntity<Timesheet> updateTimesheet(@PathVariable Long id, @RequestBody Timesheet timesheetDetails) {
		Timesheet timesheet = timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exist with id :" + id));

		timesheet.setFirstName(timesheetDetails.getFirstName());
		timesheet.setLastName(timesheetDetails.getLastName());
		timesheet.setEmailId(timesheetDetails.getEmailId());

		Timesheet updatedTimesheet = timesheetRepository.save(timesheet);
		return ResponseEntity.ok(updatedTimesheet);
	}

	// delete timesheet rest api
	@DeleteMapping("/timesheets/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTimesheet(@PathVariable Long id) {
		Timesheet timesheet = timesheetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exist with id :" + id));

		timesheetRepository.delete(timesheet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
