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

    BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /*---Add new Booking---*/
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody BookingEntity bookingEntity) {
        bookingService.save(bookingEntity);
        //ID!!!
        return ResponseEntity.ok().body("Добавлена новая бронь");
    }

    /*---Get a Booking by id---*/
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        BookingEntity booking = bookingService.getByKey(id);
        if(booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Бронь не найдена");
        }
        return ResponseEntity.ok().body(booking);
    }

    /*---Update a Booking by id---*/
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody BookingEntity booking) {
        booking.setId(id);
        bookingService.update(booking);
        return ResponseEntity.ok().body("Бронь изменена");
    }
    /*---Delete a Booking by id---*/
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        BookingEntity booking = new BookingEntity();
        booking.setId(id);
        bookingService.delete(booking);
        return ResponseEntity.ok().body("Бронь удалена успешно");
    }

}
