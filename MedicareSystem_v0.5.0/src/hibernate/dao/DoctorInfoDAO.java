package hibernate.dao;

import hibernate.vo.userinfo.DoctorInfo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * DoctorInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.vo.userinfo.DoctorInfo
 * @author Milestone
 */

public class DoctorInfoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(DoctorInfoDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String PROFESSION = "profession";
	public static final String HOSPITAL = "hospital";
	public static final String LOCATION = "LOCATION";
	public static final String PHONE = "PHONE";
	public static final String RESUME = "RESUME";

	public void save(DoctorInfo transientInstance) {
		log.debug("saving DoctorInfo instance");
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

	public void delete(DoctorInfo persistentInstance) {
		log.debug("deleting DoctorInfo instance");
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

	public void update(DoctorInfo instance) {
		log.debug("attaching dirty DoctorInfo instance");
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
	
	public DoctorInfo findById(java.lang.String id) {
		log.debug("getting DoctorInfo instance with id: " + id);
		try {
			DoctorInfo instance = (DoctorInfo) getSession().get(
					"hibernate.vo.userinfo.DoctorInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DoctorInfo> findByExample(DoctorInfo instance) {
		log.debug("finding DoctorInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate.vo.userinfo.DoctorInfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<DoctorInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding DoctorInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DoctorInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DoctorInfo> findAll() {
		log.debug("finding all DoctorInfo instances");
		try {
			String queryString = "from DoctorInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}