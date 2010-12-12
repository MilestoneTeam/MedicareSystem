package hibernate.junit.daotest;

import java.util.ArrayList;
import java.util.List;

import hibernate.dao.DoctorDAO;
import hibernate.vo.user.Doctor;
import junit.framework.TestCase;

public class DoctorDAOTest extends TestCase {
	public void testDoctorSave() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = new Doctor();
		doctor.setPhysicianLicenseNum("aaaaaaaa");
		doctor.setPassword("111111");
		dao.save(doctor);

		doctor.setPhysicianLicenseNum("bbbbbbbb");
		doctor.setPassword("222222");
		dao.save(doctor);
		
		doctor.setPhysicianLicenseNum("cccccccc");
		doctor.setPassword("333333");
		dao.save(doctor);
	}
	
	public void testNoMatchQuery() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("abcdefg");
		assertEquals( true, doctor == null);
		
		List<Doctor> doctorlist = new ArrayList<Doctor>();
		Doctor example = new Doctor();
		example.setPhysicianLicenseNum("cccccccc");
		example.setPassword("222222");
		doctorlist = dao.findByExample(example);

		assertEquals( true, doctorlist.size() == 0 );
		
		doctorlist = dao.findByProperty("physicianLicenseNum", "abcdefg");
		assertEquals( true, doctorlist.size() == 0 );
		
		doctorlist = dao.findByProperty("password", "555555");
		assertEquals( true, doctorlist.size() == 0 );
		
		
	}
	
	public void testMatchQuery() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("bbbbbbbb");
		assertEquals( false, doctor == null );
		
		List<Doctor> doctorlist = new ArrayList<Doctor>();
		Doctor example = new Doctor();
		example.setPhysicianLicenseNum("cccccccc");
		example.setPassword("333333");
		doctorlist = dao.findByExample(example);
		assertEquals( false, doctorlist.size() == 0 );
		
		doctorlist = dao.findByProperty("physicianLicenseNum", "aaaaaaaa");
		assertEquals( false, doctorlist.size() == 0 );
		
		doctorlist = dao.findByProperty("password", "111111");
		assertEquals( false, doctorlist.size() == 0 );
		
	}
	
	public void testDoctorDelete() {
		DoctorDAO dao = new DoctorDAO();
		Doctor doctor = dao.findById("cccccccc");
		dao.delete(doctor);
		doctor = dao.findById("cccccccc");
		assertEquals( true, doctor == null);
		
		doctor = new Doctor();
		doctor.setPhysicianLicenseNum("aaaaaaaa");
		doctor.setPassword("111111");
		dao.delete( doctor );
		
	}
	
}
