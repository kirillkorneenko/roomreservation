package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE )
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*---Add new User---*/
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.save(employeeEntity);
        //ID!!!!!
        return ResponseEntity.ok().body("Добавлен новый пользователь с id :" );
    }

    /*---Get a User by id---*/
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        EmployeeEntity employee = employeeService.getByKey(id);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
        return ResponseEntity.ok().body(employee);
    }

    /*---Update a user by id---*/
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EmployeeEntity employee) {
        employee.setId(id);
        employeeService.update(employee);
        return ResponseEntity.ok().body("Пользователь изменен успешно");
    }

    /*---Delete a user by id---*/
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(id);
        employeeService.delete(employee);
        return ResponseEntity.ok().body("Пользователь удален успешно");
    }
}
