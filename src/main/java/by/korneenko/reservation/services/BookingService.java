package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.dao.BookingDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

@Service
@Transactional
public class BookingService {

    @PersistenceContext
    private BookingDao dao;

    @Transactional
    public void save(BookingEntity bookingEntity){ dao.persist(bookingEntity); }

    @Transactional
    public BookingEntity getByKey(Long id){ return  dao.getByKey(id);}

    @Transactional
    public void  update(BookingEntity booking){  dao.update(booking);}

    @Transactional
    public void delete(BookingEntity booking){dao.delete(booking);}

}
