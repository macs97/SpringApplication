package com.tcs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.dao.EmployeeDao;
import com.tcs.spring.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	public Iterable<Employee> getAll() {
		return dao.findAll();
	}
	
	public void save(Employee employee) {
		dao.save(employee);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean update(int id, Employee employee) {
		if(dao.existsById(id)) {
			employee.setId(id);
			dao.save(employee);
			return true;
		} else {
			return false;
		}
	}

}
