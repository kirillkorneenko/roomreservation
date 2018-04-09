package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.dao.BookingDao;
import by.korneenko.reservation.model.BookingByTime;
import by.korneenko.reservation.util.TimeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private BookingDao dao;

    @Autowired
    public void setDao(BookingDao dao) {
        this.dao = dao;
    }

    @Transactional
    public Boolean save(BookingEntity bookingEntity){
        List<BookingEntity> list = this.getBookingByRoom(bookingEntity.getIdRoom(), bookingEntity.getDate());
        if(TimeCheck.timeCheck(list, bookingEntity.getTimeStart(), bookingEntity.getTimeEnd())){
            dao.persist(bookingEntity);
            return true;
        } else return false;


    }

    @Transactional
    public BookingEntity getByKey(Long id){ return  dao.getByKey(id);}

    @Transactional
    public void  update(BookingEntity booking){  dao.update(booking);}

    @Transactional
    public void delete(BookingEntity booking){dao.delete(booking);}

    @Override
    public List<BookingEntity> getBookingByUser(Long id) {
        return dao.getBookingByUser(id);
    }

    @Override
    public List<BookingEntity> getBookingByRoom(Long id, Date date) {
        return dao.getBookingByRoom(id, date);
    }

    @Override
    public List<BookingEntity> getBookingByTime(BookingByTime model) {
        List<BookingEntity> list = this.getBookingByUser(model.getIdEmployee());
        return  TimeCheck.timeEntry(list, model.getStart(),model.getEnd());
    }

}
