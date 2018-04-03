package by.korneenko.reservation.dao;

import by.korneenko.reservation.beans.RoomEntity;

public interface RoomDao {

    void persist(RoomEntity room);
    RoomEntity getByKey(Long id);
    void update(RoomEntity room);
    void delete(RoomEntity room);
}
