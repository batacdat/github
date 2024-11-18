package com.sqc.academy;
import com.sqc.academy.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Hồ Văn Trung", LocalDate.of(2000, 12, 12), "Nam", 15000000f),
            new Employee(2, "Nguyễn Văn Minh", LocalDate.of(1995, 5, 20), "Nam", 12000000f),
            new Employee(3, "Phương", LocalDate.of(1998, 3, 15), "Nữ", 13000000f),
            new Employee(4, "Ngọc Mai", LocalDate.of(1997, 7, 22), "Nữ", 14000000f),
            new Employee(5, "Trần Văn An", LocalDate.of(1996, 11, 30), "Nam", 16000000f)
    ));

    @GetMapping
//chỉ cho phép sử dụng phương thức GET để lấy GT
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employees);
    }
//reponseEntity : trả về status của đối tượng
    @RequestMapping("/{id}")
    public ResponseEntity<Employee> getByIdEmployees(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // thêm mới :POST
    @PostMapping
    public Employee save( @RequestBody Employee employee) {
        employee.setId((int) (Math.random() * 100000000));
        employees.add(employee);
        return employee;
    }
    //xóa :DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Employee>> deleteByIdEmployees(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    //sửa :PUT
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateByIdEmployees(@PathVariable int id, @RequestBody Employee employee) {
        for (Employee employee1 : employees) {
            if (employee1.getId() == id) {
                employee1.setName(employee.getName());
                employee1.setBirthday(employee.getBirthday());
                employee1.setSex(employee.getSex());
                employee1.setSalary(employee.getSalary());
                return ResponseEntity.ok(employee1);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}



