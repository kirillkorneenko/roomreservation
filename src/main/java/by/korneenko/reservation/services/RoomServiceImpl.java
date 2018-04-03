package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.RoomEntity;
import by.korneenko.reservation.dao.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomDao dao;

    @Autowired
    public void setDao(RoomDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void save(RoomEntity roomEntity){ dao.persist(roomEntity); }

    @Transactional
    public RoomEntity getByKey(Long id){ return  dao.getByKey(id);}

    @Transactional
    public void  update(RoomEntity room){  dao.update(room);}

    @Transactional
    public void delete(RoomEntity room){dao.delete(room);}
}
