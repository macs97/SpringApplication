package com.tcs.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.spring.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
