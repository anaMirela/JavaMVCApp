package ro.teamnet.zth.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.EmployeeService;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Mi on 5/6/2015.
 */
@Controller
@RequestMapping(value  = "/employees")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> getAllEmployees() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Employee getOneEmployee(@PathVariable("id") String idEmployee) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        return employeeService.findOneEmployee(Integer.valueOf(idEmployee));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") String idEmployee) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.deleteEmployee(Integer.valueOf(idEmployee));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save(@RequestBody Employee employee) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody Employee employee) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.updateEmployee(employee);
    }
}
