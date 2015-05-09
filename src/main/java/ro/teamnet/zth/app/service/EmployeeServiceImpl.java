package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by Mi on 5/7/2015.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findAllEmployees() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee(int id) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(int id) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteEmployee(employeeDao.getEmployeeById(id));
    }

    @Override
    public void saveEmployee (Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void updateEmployee (Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.updateEmployee(employee);
    }
}
