package by.korneenko.reservation.dao;

import by.korneenko.reservation.beans.BookingEntity;

import java.sql.Date;
import java.util.List;

public interface BookingDao {
    void persist(BookingEntity booking);
    BookingEntity getByKey(Long id);
    void update(BookingEntity booking);
    void delete(BookingEntity booking);
    List<BookingEntity> getBookingByUser(Long id);
    List<BookingEntity> getBookingByRoom(Long id, Date date);
}
