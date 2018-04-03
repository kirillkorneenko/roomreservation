package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.dao.EmployeeDao;
import org.hibernate.annotations.LazyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao dao;

    @Autowired
    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void save(EmployeeEntity employeeEntity){ dao.persist(employeeEntity); }

    @Transactional
    public EmployeeEntity getByKey(Long id){ return  dao.getByKey(id);}

    @Transactional
    public void  update(EmployeeEntity employee){  dao.update(employee);}

    @Transactional
    public void delete(EmployeeEntity employee){dao.delete(employee);}
}
