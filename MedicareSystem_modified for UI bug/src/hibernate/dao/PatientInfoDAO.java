package hibernate.dao;

import hibernate.vo.userinfo.PatientInfo;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * PatientInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.vo.userinfo.PatientInfo
 * @author MyEclipse Persistence Tools
 */

public class PatientInfoDAO extends BaseHibernateDAO<PatientInfo> {
	private static final Log log = LogFactory.getLog(PatientInfoDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String MARRIAGE = "marriage";
	public static final String NATIONALITY = "nationality";

	public void save(PatientInfo transientInstance) {
		log.debug("saving PatientInfo instance");
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

	public void delete(PatientInfo persistentInstance) {
		log.debug("deleting PatientInfo instance");
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
	
	public void update(PatientInfo instance) {
		log.debug("attaching dirty PatientInfo instance");
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

	public PatientInfo findById(java.lang.String id) {
		log.debug("getting PatientInfo instance with id: " + id);
		try {
			PatientInfo instance = (PatientInfo) getSession().get("hibernate.vo.userinfo.PatientInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PatientInfo> findByExample(PatientInfo instance) {
		log.debug("finding PatientInfo instance by example");
		try {
			List results = getSession().createCriteria("hibernate.vo.userinfo.PatientInfo")
										.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<PatientInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding PatientInfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryPropertyString = "from PatientInfo as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryPropertyString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PatientInfo> findAll() {
		log.debug("finding all PatientInfo instances");
		try {
			String queryString = "from PatientInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}