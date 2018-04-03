package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.RoomEntity;

public interface RoomService {
    void save(RoomEntity roomEntity);
    RoomEntity getByKey(Long id);
    void  update(RoomEntity roomEntity);
    void delete(RoomEntity roomEntity);
}
