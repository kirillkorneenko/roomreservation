package by.korneenko.reservation.dao.impl;

import by.korneenko.reservation.beans.RoomEntity;
import by.korneenko.reservation.dao.AbstractDao;
import by.korneenko.reservation.dao.RoomDao;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl extends AbstractDao<Long,RoomEntity> implements RoomDao{


}
