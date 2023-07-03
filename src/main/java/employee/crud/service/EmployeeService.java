package employee.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import employee.crud.ResourceNotFoundException.ResourceNotFoundException;
import employee.crud.entites.Employee;
import employee.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public List<Employee> createMultipleEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByAgeAndCity(int age, String city) {
        return employeeRepository.findByAgeAndCity(age, city);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
		/* existingEmployee.setId(employeeDetails.getId()); */
        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setAge(employeeDetails.getAge());
        existingEmployee.setCity(employeeDetails.getCity());
        existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        System.out.println("Data Deleted Successfully");
    }
}
