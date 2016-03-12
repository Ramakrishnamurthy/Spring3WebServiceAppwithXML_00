package com.dineshonjava.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dineshonjava.DAO.EmpDao;
import com.dineshonjava.web.model.Employee;
import com.dineshonjava.web.model.Employees;

@Controller
public class WebServiceController {
	@Autowired
	private EmpDao empDao;

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", headers = "Accept=*/*")
	public @ResponseBody
	Employee getEmployeeById(@PathVariable int id) {
		System.out.println("controller");

		return empDao.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees", headers = "Accept=*/*")
	public @ResponseBody
	Employees getEmployees() {
		Employees employees = new Employees();
		employees.setEmployees(empDao.getAllEmployees());
		return employees;
	}
	//@RequestMapping(value = "/getString", method = RequestMethod.GET, produces = "application/json")

	@RequestMapping(method = RequestMethod.GET, value = "/hi", headers = "Accept=*/*")
	public @ResponseBody
	String sayHi() {
		System.out.println("hi");
		return "hello";
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
}
