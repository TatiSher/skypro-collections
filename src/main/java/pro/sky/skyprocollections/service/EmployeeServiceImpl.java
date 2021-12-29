package pro.sky.skyprocollections.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollections.data.Employee;
import pro.sky.skyprocollections.exceptions.EmployeeExistsException;
import pro.sky.skyprocollections.exceptions.NoEmployeeFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.add(employee)) {
            throw new EmployeeExistsException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new NoEmployeeFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new NoEmployeeFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getEmployees(){
        return Set.copyOf(employees);
    }

}