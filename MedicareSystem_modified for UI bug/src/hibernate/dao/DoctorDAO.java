package hibernate.dao;

import hibernate.vo.user.Doctor;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;

/**
 * A data access object (DAO) providing persistence and search support for
 * Doctor entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.vo.user.Doctor
 * @author Milestone
 */

public class DoctorDAO extends BaseHibernateDAO<Doctor> {
	private static final Log log = LogFactory.getLog(DoctorDAO.class);
	// property constants
	public static final String PASSWORD = "password";

	public void save(Doctor transientInstance) {
		log.debug("saving Doctor instance");
		try {
			getSession().beginTransaction();
			getSession().save(transientInstance);
			getSession().getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("save failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}

	public void delete(Doctor persistentInstance) {
		log.debug("deleting Doctor instance");
		try {
			getSession().beginTransaction();
			getSession().delete(persistentInstance);
			getSession().getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("delete failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}
	
	public void update(Doctor instance) {
		log.debug("attaching dirty Doctor instance");
		try {
			getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			getSession().getTransaction().commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("attach failed", re);
			throw re;
		} finally {
			getSession().close();
		}
	}

	public Doctor findById(java.lang.String id) {
		log.debug("getting Doctor instance with id: " + id);
		try {
			Doctor instance = (Doctor)getSession().get("hibernate.vo.user.Doctor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Doctor> findByExample(Doctor instance) {
		log.debug("finding Doctor instance by example");
		try {
			List results = getLikeResultsByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	private List getLikeResultsByExample(Doctor example) {
		return getSession().createCriteria("hibernate.vo.user.Doctor")
							.add( Expression.eq("physicianLicenseNum", example.getPhysicianLicenseNum()))
							.add( Expression.eq("password", example.getPassword()))				
							.list();
	}

	public List<Doctor> findByProperty(String propertyName, Object value) {
		log.debug("finding Doctor instance with property: " + propertyName + ", value: " + value);
		try {
			String queryPropertyString = "from Doctor as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryPropertyString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Doctor> findAll() {
		log.debug("finding all Doctor instances");
		try {
			String queryAllString = "from Doctor";
			Query queryObject = getSession().createQuery(queryAllString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}