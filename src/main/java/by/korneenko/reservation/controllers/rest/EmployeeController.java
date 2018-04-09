package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.services.EmployeeService;
import by.korneenko.reservation.services.EmployeeServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*---Add new User---*/
    @PostMapping("/employee/add")
    public ResponseEntity<String> save(@RequestBody EmployeeEntity employeeEntity) {

        if (employeeService.isUserExist(employeeEntity)) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Такой пользователь уже зарегистрирован");
        }
        employeeService.save(employeeEntity);
        return ResponseEntity.ok().body("Добавлен новый пользователь" );
    }

    /*---Get a User by id---*/
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        EmployeeEntity employee = employeeService.getByKey(id);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
        return ResponseEntity.ok().body(employee);
    }

    /*---Update a user by id---*/
    @PutMapping("/employee/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EmployeeEntity employee) {
        employee.setId(id);
        employeeService.update(employee);
        return ResponseEntity.ok().body("Пользователь изменен успешно");
    }

    /*---Delete a user by id---*/
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(id);
        employeeService.delete(employee);
        return ResponseEntity.ok().body("Пользователь удален успешно");
    }


}
