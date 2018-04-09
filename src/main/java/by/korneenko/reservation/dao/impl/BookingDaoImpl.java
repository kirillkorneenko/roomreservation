package by.korneenko.reservation.dao.impl;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.dao.AbstractDao;
import by.korneenko.reservation.dao.BookingDao;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookingDaoImpl extends AbstractDao<Long,BookingEntity> implements BookingDao{

    @Override
    public List<BookingEntity> getBookingByUser(Long id) {
        //**creating CriteriaBuilder**
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<BookingEntity> criteria = builder.createQuery(BookingEntity.class);
        Root<BookingEntity> bookingRoot = criteria.from(BookingEntity.class);
        criteria.select(bookingRoot);

        //**Adding where clause**
        criteria.where(builder.equal(bookingRoot.get("idEmployee"), id));

        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<BookingEntity> getBookingByRoom(Long id, Date date) {
        //**creating CriteriaBuilder**
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<BookingEntity> criteria = builder.createQuery(BookingEntity.class);
        Root<BookingEntity> bookingRoot = criteria.from(BookingEntity.class);
        criteria.select(bookingRoot);

        //**Adding where clause**
        criteria.where(builder.equal(bookingRoot.get("idRoom"), id));
        criteria.where(builder.equal(bookingRoot.get("date"), date));

        return getEntityManager().createQuery(criteria).getResultList();
    }
}
