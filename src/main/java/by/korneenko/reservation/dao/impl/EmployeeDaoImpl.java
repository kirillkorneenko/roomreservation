package by.korneenko.reservation.dao.impl;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.dao.AbstractDao;
import by.korneenko.reservation.dao.EmployeeDao;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl extends AbstractDao<Long,EmployeeEntity> implements EmployeeDao{


}
