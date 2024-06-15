package com.springBoot.EmployeeManagement.EmployeeList.Controller;


import com.springBoot.EmployeeManagement.EmployeeList.Entity.EmployeeEntity;
import com.springBoot.EmployeeManagement.EmployeeList.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SwaggerController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")

    public List<EmployeeEntity> findAll(){
        return employeeService.displayAll();
    }

    @PostMapping("/saveEmployee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/byEmployeeId/{id}")
    public EmployeeEntity getEmployeeById(@RequestParam int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("updateById/{id}")
    public void updateByEmployeeId(@PathVariable int id, @RequestBody EmployeeEntity employee){
         employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/deleteById/{id}")
    public EmployeeEntity deleteEmployee(@RequestParam int id){
        return employeeService.deleteEmployeeById(id);
    }
}
