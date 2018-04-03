package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE )
public class BookingController {


    @Autowired
    BookingService bookingService;

    /*---Add new User---*/
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody BookingEntity bookingEntity) {
        bookingService.save(bookingEntity);
        //ID!!!
        return ResponseEntity.ok().body("Добавлен новый пользователь с id :");
    }

    /*---Get a User by id---*/
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        BookingEntity booking = bookingService.getByKey(id);
        if(booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
        return ResponseEntity.ok().body(booking);
    }

    /*---Update a user by id---*/
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody BookingEntity booking) {
        booking.setId(id);
        bookingService.update(booking);
        return ResponseEntity.ok().body("Пользователь изменен успешно");
    }

    /*---Delete a user by id---*/
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        BookingEntity booking = new BookingEntity();
        booking.setId(id);
        bookingService.delete(booking);
        return ResponseEntity.ok().body("Пользователь удален успешно");
    }

}
