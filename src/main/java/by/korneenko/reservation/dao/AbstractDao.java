package by.korneenko.reservation.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Repository
public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager(){ return em ;}

    public T getByKey(PK key) { return getEntityManager().find(persistentClass, key); }

    public void persist(T entity) { getEntityManager().persist(entity); }

    public void flush() {
    	getEntityManager().flush();
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public CriteriaBuilder getCriteriaBuilder(){
    	return getEntityManager().getCriteriaBuilder();
    }
}
