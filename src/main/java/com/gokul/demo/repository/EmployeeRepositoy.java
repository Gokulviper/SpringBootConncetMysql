package com.gokul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokul.demo.model.Employee;

public interface EmployeeRepositoy extends JpaRepository<Employee,Long>{
//we dont have to add @Repository annotation because jpaRepository already have the annotation
}
