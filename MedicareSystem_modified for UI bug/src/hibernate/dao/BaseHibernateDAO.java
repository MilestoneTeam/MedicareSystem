package hibernate.dao;

import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public abstract class BaseHibernateDAO<E> implements IBaseHibernateDAO<E> {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	public E findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}