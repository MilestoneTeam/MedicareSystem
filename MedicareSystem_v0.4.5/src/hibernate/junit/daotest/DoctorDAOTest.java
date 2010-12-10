package hibernate.junit.daotest;

import hibernate.dao.DoctorDAO;
import hibernate.vo.Doctor;
import junit.framework.TestCase;

public class DoctorDAOTest extends TestCase {
	public void testDoctorSave() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = new Doctor();
		doctor.setPhysicianLicenseNum("1a2a3d");
		doctor.setPassword("111");
		dao.save(doctor);

	}
	
	public void testNoMatchQuery() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("abc");
		
		assertEquals(true, doctor == null);
	}
	
/*	public void testDoctorDelete() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("1a2a");
		dao.delete(doctor);
		
	}*/
	
}
