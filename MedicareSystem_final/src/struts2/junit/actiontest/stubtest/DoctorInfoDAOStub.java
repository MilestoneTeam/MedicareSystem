package struts2.junit.actiontest.stubtest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.dao.IDoctorInfoDAO;
import hibernate.vo.userinfo.DoctorInfo;

public class DoctorInfoDAOStub implements IDoctorInfoDAO{

	public void delete(DoctorInfo persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	public List<DoctorInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DoctorInfo> findByExample(DoctorInfo instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public DoctorInfo findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DoctorInfo> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(DoctorInfo transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public void update(DoctorInfo instance) {
		// TODO Auto-generated method stub
		
	}
	
	public List<DoctorInfo> findByExampleSuccessfully(DoctorInfo instance) {
		List<DoctorInfo> doctorinfolist = new ArrayList<DoctorInfo>();
		doctorinfolist.add(instance);
		return doctorinfolist;
	}
	
	public List<DoctorInfo> findByExampleFailed(DoctorInfo instance) {
		return null;
	}
	
	public DoctorInfo findByIdSuccessfully(Object id) {
		DoctorInfo doctorinfo = new DoctorInfo();
		doctorinfo.setPhysicianLicenseNum("ID"+(String)id);
		return doctorinfo;
	}
	
	public DoctorInfo findByIdSuccessfaild(Object id) {
		return null;
	}

}
