package struts2.junit.actiontest.stubtest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.dao.IPatientInfoDAO;
import hibernate.vo.userinfo.PatientInfo;

public class PatientInfoDAOStub implements IPatientInfoDAO {

	public void delete(PatientInfo persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	public List<PatientInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PatientInfo> findByExample(PatientInfo instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public PatientInfo findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PatientInfo> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PatientInfo transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public void update(PatientInfo instance) {
		// TODO Auto-generated method stub
		
	}
	
	public List<PatientInfo> findByExampleSuccessfully(PatientInfo instance) {
		List<PatientInfo> patientinfolist = new ArrayList<PatientInfo>();
		patientinfolist.add(instance);
		return patientinfolist;
	}
	
	public List<PatientInfo> findByExampleFailed(PatientInfo instance) {
		return null;
	}
	
	public PatientInfo findByIdSuccessfully(Object id) {
		PatientInfo patientinfo = new PatientInfo();
		patientinfo.setMedicareNum("ID"+(String)id);
		return patientinfo;
	}
	
	public PatientInfo findByIdSuccessfaild(Object id) {
		return null;
	}

}
