package hibernate.dao;

import java.util.List;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO<E> {
	public Session getSession();
	
	public void save(E transientInstance);
	public void delete(E persistentInstance);
	public void update(E instance);
	
	public E findById(Object id);
	public List<E> findByExample(E instance);
	public List<E> findByProperty(String propertyName, Object value);
	public List<E> findAll();
}