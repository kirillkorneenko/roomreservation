package by.korneenko.reservation.services;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    public boolean isUserExist(EmployeeEntity employeeEntity) { return loadUserByUsername(employeeEntity.getName()) != null; }

    @Override
    public EmployeeEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeEntity employeeEntity = null;
            employeeEntity = dao.findByField("username", username);

        if (employeeEntity == null) {
            throw new UsernameNotFoundException(String.format("Пользователь под именем '%s'.", username));
        } else {
            return employeeEntity;
        }
    }
}
