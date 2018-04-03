package by.korneenko.reservation.dao.impl;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.dao.AbstractDao;
import by.korneenko.reservation.dao.BookingDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDaoImpl extends AbstractDao<Long,BookingEntity> implements BookingDao{

}
