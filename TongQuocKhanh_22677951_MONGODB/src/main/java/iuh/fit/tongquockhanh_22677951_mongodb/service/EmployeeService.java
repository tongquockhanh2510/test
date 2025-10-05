package iuh.fit.tongquockhanh_22677951_mongodb.service;

import iuh.fit.tongquockhanh_22677951_mongodb.entity.Employee;
import iuh.fit.tongquockhanh_22677951_mongodb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByDepartmentId(String departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> findAllFiltered(String name, Integer age, Double salary, String departmentId) {
        List<Employee> employees = findAll();
        return employees.stream()
                .filter(e -> name == null || e.getName() != null && e.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(e -> age == null || e.getAge() != null && e.getAge().equals(age))
                .filter(e -> salary == null || e.getSalary() != null && e.getSalary().equals(salary))
                .filter(e -> departmentId == null || departmentId.isEmpty() || departmentId.equals(e.getDepartmentId()))
                .toList();
    }
}
