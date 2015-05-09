package ro.teamnet.zth.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.service.DepartmentService;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by Mi on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Department> getAllDepartments() {
        DepartmentDao dpd = new DepartmentDao();
        return dpd.getAllDepartments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Department getOneDepartment(@PathVariable("id") String idDep) {
        DepartmentDao departmentDao = new DepartmentDao();
        return departmentDao.getDepartmentById(Integer.valueOf(idDep));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteDepartment(@PathVariable("id") String idDepartment) {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.deleteDepartment(Integer.valueOf(idDepartment));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save(@RequestBody Department department) {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.saveDepartment(department);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody Department department) {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.updateDepartment(department);

    }
}
