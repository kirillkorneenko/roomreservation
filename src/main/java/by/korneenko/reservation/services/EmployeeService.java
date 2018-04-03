package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.EmployeeEntity;

public interface EmployeeService {

    void save(EmployeeEntity employeeEntity);
    EmployeeEntity getByKey(Long id);
    void  update(EmployeeEntity employeeEntity);
    void delete(EmployeeEntity employeeEntity);
}
