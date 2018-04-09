package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.model.BookingByTime;

import java.sql.Date;
import java.util.List;

public interface BookingService {
    Boolean save(BookingEntity bookingEntity);
    BookingEntity getByKey(Long id);
    void  update(BookingEntity booking);
    void delete(BookingEntity booking);
    List<BookingEntity> getBookingByUser(Long id);
    List<BookingEntity> getBookingByRoom(Long id, Date date);
    List<BookingEntity> getBookingByTime(BookingByTime model);
}
