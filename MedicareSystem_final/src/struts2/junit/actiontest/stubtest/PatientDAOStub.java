package struts2.junit.actiontest.stubtest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.dao.IPatientDAO;
import hibernate.vo.user.Patient;

public class PatientDAOStub implements IPatientDAO {

	public void delete(Patient persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> findByExample(Patient instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Patient transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public void update(Patient instance) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Patient> findByExampleSuccessfully(Patient instance) {
		List<Patient> patientlist = new ArrayList<Patient>();
		patientlist.add(instance);
		return patientlist;
	}
	
	public List<Patient> findByExampleFailed(Patient instance) {
		return null;
	}
	
	public Patient findByIdSuccessfully(Object id) {
		Patient patient = new Patient();
		patient.setMedicareNum("ID"+(String)id);
		patient.setPassword("Password" + (String)id );
		return patient;
	}
	
	public Patient findByIdSuccessfaild(Object id) {
		return null;
	}

}
