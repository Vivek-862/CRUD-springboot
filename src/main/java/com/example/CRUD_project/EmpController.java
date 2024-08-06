package com.example.CRUD_project;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping
public class EmpController {
    // List<Employee> employees= new ArrayList<>();
    //  EmployeeService  employeeService = new EmployeeServiceImp();
    
    //Dependency Injection
    @Autowired
    EmployeeService  employeeService; 

   @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
    return employeeService.readEmployees();
   }

   @GetMapping("/employees/{id}")
   public Employee getAllEmployeeById(@PathVariable Long id){
   return employeeService.readEmployee(id);
  }

   @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
       return  employeeService.createEmployee(employee);
        //employees.add(employee);
        
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id))
            return "Delete Successfully";
        
            
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee){

        return employeeService.updateEmployee(id, employee);
    }

}