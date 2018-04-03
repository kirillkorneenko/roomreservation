package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.BookingEntity;

public interface BookingService {
    void save(BookingEntity bookingEntity);
    BookingEntity getByKey(Long id);
    void  update(BookingEntity booking);
    void delete(BookingEntity booking);
}
