package struts2.junit.actiontest.stubtest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.dao.IDoctorDAO;
import hibernate.vo.user.Doctor;

public class DoctorDAOStub implements IDoctorDAO {

	public void delete(Doctor persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doctor> findByExample(Doctor instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Doctor findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doctor> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Doctor transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public void update(Doctor instance) {
		// TODO Auto-generated method stub
		
	}

	public List<Doctor> findByExampleSuccessfully(Doctor instance) {
		List<Doctor> doctorlist = new ArrayList<Doctor>();
		doctorlist.add(instance);
		return doctorlist;
	}
	
	public List<Doctor> findByExampleFailed(Doctor instance) {
		return null;
	}
	
	public Doctor findByIdSuccessfully(Object id) {
		Doctor doctor = new Doctor();
		doctor.setPhysicianLicenseNum("ID"+(String)id);
		doctor.setPassword("Password" + (String)id );
		return doctor;
	}
	
	public Doctor findByIdSuccessfaild(Object id) {
		return null;
	}
}
