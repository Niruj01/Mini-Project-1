package com.springBoot.EmployeeManagement.EmployeeList.Service;

import com.springBoot.EmployeeManagement.EmployeeList.Entity.EmployeeEntity;
import com.springBoot.EmployeeManagement.EmployeeList.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    1) To Store EmployeeDetails in Database(mySQL)

    public EmployeeEntity saveEmployee(EmployeeEntity employees){

        //save the Employee
        return employeeRepository.save(employees);
    }

//     2) Display all employee

    public List<EmployeeEntity> displayAll(){

        return employeeRepository.findAll();
    }

//    3) Display FindById Employee

    public EmployeeEntity getEmployeeById(int id) {
        Optional<EmployeeEntity> employeid = employeeRepository.findById(id);
        if(employeid.isPresent()){
            return employeid.get();
        }else{
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }

//     4) Upadate Employee

    public void updateEmployee(int id,  EmployeeEntity employeeDetails) {
        Optional<EmployeeEntity> employees = employeeRepository.findById(id);
        if(employees.isPresent()) {
            EmployeeEntity employee = employees.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());
            employee.setLocation(employeeDetails.getLocation());
            employee.setMobileNo(employeeDetails.getMobileNo());

             employeeRepository.save(employee);
        }
    }
//     5) Delete Employee

    public EmployeeEntity deleteEmployeeById(int id) {

        employeeRepository.deleteById(id);
        return null;
    }
}
