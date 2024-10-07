package com.project.crudemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudemp.Exception.ResourceNotFoundException;
import com.project.crudemp.model.Emplyee;
import com.project.crudemp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/employees")
public List<Emplyee>getAllEmployees(){
    return employeeRepository.findAll();
}


@PostMapping("/create")
public Emplyee createEmploye(@RequestBody Emplyee e)
{
return employeeRepository.save(e);
}
@GetMapping("/employees/{id}")
public ResponseEntity<Emplyee> getEmployeeById(@PathVariable long id) {
    Emplyee emp = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("employee not found"));
    return ResponseEntity.ok(emp);
}

@DeleteMapping("/delete/{id}")
public void deleteEmployeeById(@PathVariable Long id)
{
    employeeRepository.deleteById(id);
}
@PutMapping("/update/{id}")
public ResponseEntity<Emplyee> update(@PathVariable Long id, @RequestBody Emplyee empDetails) {
    Emplyee emp = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("employee not found"));
    emp.setFirstname(empDetails.getFirstname());
    emp.setEmail(empDetails.getEmail());
    emp.setLastname(empDetails.getLastname());
    emp.setphone(empDetails.getPhone());  // Assurez-vous de mettre à jour le champ phone également
    Emplyee updated = employeeRepository.save(emp);
    return ResponseEntity.ok(updated);
}










}
