package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.model.BookingByTime;
import by.korneenko.reservation.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class BookingController {

    BookingService bookingService;


    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /*---Add new Booking---*/
    @PostMapping("/booking/add")
    public ResponseEntity<String> save(@RequestBody BookingEntity bookingEntity) {
        if(bookingService.save(bookingEntity)){
        return ResponseEntity.ok().body("Добавлена новая бронь");
        }
        else return ResponseEntity.status(HttpStatus.CONFLICT).body("Бронь не может быть добавлена");
    }

    /*---Get a Booking by id---*/
    @GetMapping("/booking/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id)  {
        BookingEntity booking = bookingService.getByKey(id);
        if(booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Бронь не найдена");
        }
        return ResponseEntity.ok().body(booking);
    }

    /*---Get a Booking by id---*/
    @PutMapping("/bookingByTime")
    public ResponseEntity<?> bookingByTime(@RequestBody BookingByTime modelRequest)  {
        List<BookingEntity> list = bookingService.getBookingByTime(modelRequest);
        if(list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Брони не найдены");
        }
        return ResponseEntity.ok().body(list);
    }

    /*---Update a Booking by id---*/
    @PutMapping("/booking/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody BookingEntity booking) {
        booking.setId(id);
        bookingService.update(booking);
        return ResponseEntity.ok().body("Бронь изменена");
    }
    /*---Delete a Booking by id---*/
    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        BookingEntity booking = new BookingEntity();
        booking.setId(id);
        bookingService.delete(booking);
        return ResponseEntity.ok().body("Бронь удалена успешно");
    }

    @GetMapping("/booking/bookingByEmployee/{id}")
    public ResponseEntity<?> getBookingByEmployee(@PathVariable("id") long id){
        List<BookingEntity> list = bookingService.getBookingByUser(id);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Брони не найдены");
        }
        return ResponseEntity.ok().body(list);
    }



}
