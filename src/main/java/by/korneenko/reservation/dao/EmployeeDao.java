package by.korneenko.reservation.dao;

import by.korneenko.reservation.beans.EmployeeEntity;

public interface EmployeeDao {
    void persist(EmployeeEntity employeeEntity);
    EmployeeEntity getByKey(Long id);
    void update(EmployeeEntity employeeEntity);
    void delete(EmployeeEntity employee);
    EmployeeEntity findByField(String field, String value) ;
}
