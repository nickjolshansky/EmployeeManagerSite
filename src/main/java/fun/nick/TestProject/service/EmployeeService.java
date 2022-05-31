package fun.nick.TestProject.service;

import fun.nick.TestProject.exceptions.EmployeeNotFoundException;
import fun.nick.TestProject.model.Employee;
import fun.nick.TestProject.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

     private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeByID(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found."));
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
