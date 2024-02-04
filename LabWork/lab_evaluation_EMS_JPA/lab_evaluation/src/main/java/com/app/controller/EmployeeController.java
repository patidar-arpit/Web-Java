package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}

	
	@GetMapping("/form")
	public String AddEmployee() {
	
		return "/add_Employee";
	}
	
	
	 @GetMapping("/addEmployee")
     public String AddEmployee1(Model map,@RequestParam String fn,@RequestParam String ln,@RequestParam  String city, @RequestParam  String company) {
		 
		System.out.println();
		Employee emp  =new Employee(fn,ln,city,company);
		System.out.println(emp);
		Employee e = empService.addEmployee(emp).orElseThrow();
		map.addAttribute("emp",e);
		return "/details"; 
		
	}
	 
	@GetMapping("/display")
	public String displayEmployeeDetails(Model map) { 
		
		System.out.println("iNSIDE THE DISPLAY");
		List<Employee> res = empService.displayAllEmployees();
		map.addAttribute("emp_details", res);
		return "/details";
		
	}
	
	@GetMapping("/company_name")
	 public String acceptCompanyname(){
		return "/accept_cmp_name";
	}
	
	@GetMapping("/companyWiseDetail")
	public String getCompanyWiseEmpDetail(Model map,@RequestParam String companyName){
		
		List<Employee> emps = empService.getCompanyWiseEmpDetail(companyName);
		map.addAttribute("company_wise",emps);
		return "/details";
	}
	
	@GetMapping("/firstName")
	public String findByFirstName(Model map) {
		String firstName = "bittu";
		map.addAttribute("emp_by_firstName",empService.getEmployeeByFirstName(firstName));
	    return "/details";
	}
		 
}
