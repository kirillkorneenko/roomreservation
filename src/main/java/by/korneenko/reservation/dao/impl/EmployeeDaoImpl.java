package by.korneenko.reservation.dao.impl;

import by.korneenko.reservation.beans.EmployeeEntity;
import by.korneenko.reservation.dao.AbstractDao;
import by.korneenko.reservation.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Repository
public class EmployeeDaoImpl extends AbstractDao<Long,EmployeeEntity> implements EmployeeDao{

    @Override
    public EmployeeEntity findByField(String field, String value) {
        //**creating CriteriaBuilder**
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteria = builder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> userRoot = criteria.from(EmployeeEntity.class);
        criteria.select(userRoot);

        //**Adding where clause**
        criteria.where(builder.equal(userRoot.get(field), value));

        return getEntityManager().createQuery(criteria).getSingleResult();
    }

}
