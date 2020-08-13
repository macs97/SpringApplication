package com.tcs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.spring.entity.Employee;
import com.tcs.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/getAll")
	public ResponseEntity<Iterable<Employee>> getAll() {
		try {
			return new ResponseEntity<Iterable<Employee>>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value= "/save")
	public ResponseEntity<HttpStatus> save(@RequestBody Employee employee) {
		try {
			service.save(employee);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody Employee employee) {
		try {
			boolean response = service.update(id, employee);
			if(response) {				
				return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);	
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
		try {
			service.delete(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
}
