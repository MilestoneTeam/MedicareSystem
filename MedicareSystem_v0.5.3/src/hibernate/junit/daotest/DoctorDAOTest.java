package hibernate.junit.daotest;

import java.util.HashSet;
import java.util.Set;

import hibernate.dao.DoctorDAO;
import hibernate.vo.user.Doctor;
import hibernate.vo.userinfo.DoctorInfo;
import junit.framework.TestCase;

public class DoctorDAOTest extends TestCase {

	public void testDoctorSave() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = new Doctor();
		doctor.setPhysicianLicenseNum("xx");
		doctor.setPassword("111");
		DoctorInfo di = new DoctorInfo();
		di.setAge(11);
		di.setName("aaa");
		di.setDoctor(doctor);
		Set<DoctorInfo> s = new HashSet<DoctorInfo>();
		s.add(di);
		doctor.setDoctorInfos(s);
		dao.save(doctor);

	}
	
	public void testNoMatchQuery() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findByExample(new Doctor("xx","111")).get(0);
		
		assertEquals(true, doctor != null);
	}
	
	public void testDoctorDelete() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("1a2a");
		dao.delete(doctor);
		
	}
	
}
