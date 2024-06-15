package com.springBoot.EmployeeManagement.EmployeeList.Controller;

import com.springBoot.EmployeeManagement.EmployeeList.Entity.EmployeeEntity;
import com.springBoot.EmployeeManagement.EmployeeList.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    //injecting service layer into EmployeeController
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")

    public String index(){
        return "redirect:/home";
    }

    //To display all employeedetails in home page
    @GetMapping("/home")

    public String showAllEmployee(Model model){
        List<EmployeeEntity> employees = employeeService.displayAll();
        model.addAttribute("employees",employees);
        // retrun to home.html
        return "home";
    }

    //controller to /addEmployeeDetails->display form
    @GetMapping("/addEmployeeDetails")
    public String ShowAddEmployeeForm(){
        //return addEmployeeForm.html
        return "addEmployeeForm";
    }

    //Controller endpoint /addEmployee->save Employee
    @PostMapping("/addEmployeeDetails")
    public String addEmployee(@ModelAttribute EmployeeEntity employees){

        employeeService.saveEmployee(employees);
        return "redirect:/home";//redirect to home after form submit
    }

    //To display particular Employee by Name
    @GetMapping("/viewEmployee/{id}")

    public String showByName(@PathVariable(value = "id") int id, Model model){
        EmployeeEntity employeeId = employeeService.getEmployeeById(id);
        model.addAttribute("employees",employeeId);
        // return to displayEmployee.html to view partiular employeeDetails
        return "displayEmployee";
    }

    //To get updateForm....

    @GetMapping("/updateForm/{id}")
    public String showUpdateForm(@PathVariable (value = "id") int id,Model model){
        EmployeeEntity employee = employeeService.getEmployeeById(id);
        model.addAttribute("employees",employee);
        return "updateForm";
    }

    @PostMapping ("/updateForm/{id}")
    public String updateEmployee(@PathVariable (value = "id") int id,@ModelAttribute("employees") EmployeeEntity employees) {
        employeeService.updateEmployee(id,employees);

        return "redirect:/home";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id,Model model) {

        // call delete employee method
        EmployeeEntity employees=employeeService.deleteEmployeeById(id);
        model.addAttribute("employees",employees);
        return "redirect:/home";
    }






}
