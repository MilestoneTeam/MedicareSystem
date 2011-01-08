package hibernate.dao;

import hibernate.vo.user.Patient;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;

/**
 * A data access object (DAO) providing persistence and search support for
 * Patient entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.vo.user.Patient
 * @author Milestone
 */

public class PatientDAO extends BaseHibernateDAO<Patient> {
	private static final Log log = LogFactory.getLog(PatientDAO.class);
	// property constants
	public static final String PASSWORD = "password";

	public void save(Patient transientInstance) {
		log.debug("saving Patient instance");
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

	public void delete(Patient persistentInstance) {
		log.debug("deleting Patient instance");
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
	
	public void update(Patient instance) {
		log.debug("attaching dirty Patient instance");
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

	public Patient findById(java.lang.String id) {
		log.debug("getting Patient instance with id: " + id);
		try {
			Patient instance = (Patient) getSession().get("hibernate.vo.user.Patient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Patient> findByExample(Patient instance) {
		log.debug("finding Patient instance by example");
		try {
			List results = getLikeResultsByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	private List getLikeResultsByExample(Patient instance) {
		return getSession().createCriteria("hibernate.vo.user.Patient")
					.add( Expression.eq("medicareNum", instance.getMedicareNum()))
					.add( Expression.eq("password", instance.getPassword()))
					.list();
	}

	public List<Patient> findByProperty(String propertyName, Object value) {
		log.debug("finding Patient instance with property: " + propertyName + ", value: " + value);
		try {
			String queryPropertyString = "from Patient as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryPropertyString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Patient> findAll() {
		log.debug("finding all Patient instances");
		try {
			String queryAllString = "from Patient";
			Query queryObject = getSession().createQuery(queryAllString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}