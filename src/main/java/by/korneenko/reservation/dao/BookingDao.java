package by.korneenko.reservation.dao;

import by.korneenko.reservation.beans.BookingEntity;

public interface BookingDao {
    void persist(BookingEntity booking);
    BookingEntity getByKey(Long id);
    void update(BookingEntity booking);
    void delete(BookingEntity booking);
}
