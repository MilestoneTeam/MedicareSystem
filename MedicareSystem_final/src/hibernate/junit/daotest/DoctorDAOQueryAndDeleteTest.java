package hibernate.junit.daotest;

import java.util.ArrayList;
import java.util.List;

import hibernate.dao.DoctorDAO;
import hibernate.vo.user.Doctor;
import junit.framework.TestCase;

public class DoctorDAOQueryAndDeleteTest extends TestCase {

	private DoctorDAO dao = new DoctorDAO();
	private Doctor doctor = new Doctor();
	List<Doctor> doctorlist = new ArrayList<Doctor>();

	public void testNoMatchQueryByPhysicianLicenseNumWithNegativeNumber() {
		doctorlist = dao.findByProperty("physicianLicenseNum", "-1");
		assertEquals(false, doctor == null);

	}

	public void testNoMatchQueryByPhysicianLicenseNumWithZero() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "0");
		assertEquals(false, doctor == null);
	}

	public void testNoMatchQueryByPasswordWithNegativeNumber() {

		doctorlist = dao.findByProperty("password", "-4");
		assertEquals(false, doctor == null);
	}

	public void testNoMatchQueryByPasswordWithIntegerButFloatFormat() {

		doctorlist = dao.findByProperty("password", "11111.00");
		assertEquals(false, doctor == null);
	}

	public void testNoMatchQueryByPasswordWithCharactors() {

		doctorlist = dao.findByProperty("password", "aaaaaaa");
		assertEquals(false, doctor == null);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedByNumber() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "1");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedBySpecialCharacters() {

		doctorlist = dao.findByProperty("physicianLicenseNum",
				"_~!@#$%^&*()-=+");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedByNumberAndPunctuation() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "127,¡££¿78");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedBySpaces() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "        ");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExisted() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "123456789sda");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedByNumber() {
		doctorlist = dao.findByProperty("password", "1");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedBySpecialCharacters() {

		doctorlist = dao.findByProperty("password", "^&*()");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedByByNumberAndSpace() {

		doctorlist = dao.findByProperty("password", "12 34");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedBySpaces() {

		doctorlist = dao.findByProperty("password", "     ");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordNotExisted() {

		doctorlist = dao.findByProperty("password", "asdfgh");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingBothPropertyPhysicianLicenseNumAndPasswordAllHasExisted() {

		doctor.setPhysicianLicenseNum("1234");
		doctor.setPassword("12abcd56");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingNeitherPropertyPhysicianLicenseNumOrPasswordHasExisted() {

		doctor.setPhysicianLicenseNum("111sss222aaa000");
		doctor.setPassword("xiaolulu");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumExistedButPasswordNotExisted() {

		doctor.setPhysicianLicenseNum("_123_abc_3g");
		doctor.setPassword("sxiaolulu");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExistedButPasswordExisted() {

		doctor.setPhysicianLicenseNum("YouAreBest!");
		doctor.setPassword("11111");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExistedByNumber() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "1000009000000");
		assertEquals(false, doctor == null);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordNotExistedByNumber() {

		doctorlist = dao.findByProperty("password", "1290.67");
		assertEquals(false, doctor == null);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExistedBySpecialCharacters() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "_+^&asdjiw ");
		assertEquals(false, doctor == null);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedByNumber() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "12345678");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedBySpecialCharacters() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "________");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedByNumberAndPunctuation() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "127,¡££¿78");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumHasExistedBySpaces() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "        ");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExisted() {

		doctorlist = dao.findByProperty("physicianLicenseNum", "kkkkkkkkkk");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedByNumber() {

		doctorlist = dao.findByProperty("password", "331");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedBySpecialCharacters() {

		doctorlist = dao.findByProperty("password", "~-=+_");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedByByNumberAndCharacters() {

		doctorlist = dao.findByProperty("password", "12abcd56");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedBySpaces() {

		doctorlist = dao.findByProperty("password", "     ");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordNotExisted() {

		doctorlist = dao.findByProperty("password", "yahooo");
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingBothPropertyPhysicianLicenseNumAndPasswordAllHasExisted() {

		doctor.setPhysicianLicenseNum("1");
		doctor.setPassword("1");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingNeitherPropertyPhysicianLicenseNumOrPasswordHasExisted() {

		doctor.setPhysicianLicenseNum("helloworld!");
		doctor.setPassword("123321");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumExistedButPasswordNotExisted() {

		doctor.setPhysicianLicenseNum("1");
		doctor.setPassword("sbiaolulu");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExistedButPasswordExisted() {

		doctor.setPhysicianLicenseNum("100and200");
		doctor.setPassword("331");
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testDoctorDeleteByAddARecordWithPhysicianLicenseNumWithCharactors() {

		doctor.setPhysicianLicenseNum("asdwqr fsdf");
		dao.delete(doctor);
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testDoctorDeleteByAddARecordWithPasswordWithCharactors() {

		doctor.setPassword("111111");
		dao.delete(doctor);
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testDoctorDeleteByAddARecordWithPasswordWithSpaces() {

		doctor.setPassword("        ");
		dao.delete(doctor);
		doctorlist = dao.findByExample(doctor);
		assertEquals(true, doctorlist.size() == 0);
	}

	public void testDoctorDeleteByAddARecord() {

		doctor.setPhysicianLicenseNum("aaaaaaaa");
		doctor.setPassword("111111");
		dao.delete(doctor);
	}

	public void testDoctorDeleteByAddARecordWithWrongPhysicianLicenseNumAndRightPassword() {

		doctor.setPhysicianLicenseNum("-1");
		doctor.setPassword("111111");
		dao.delete(doctor);
	}

	public void testDoctorDeleteByAddARecordWithRightPhysicianLicenseNumAndWrongPassword() {

		doctor.setPhysicianLicenseNum("12345678");
		doctor.setPassword("-123");
		dao.delete(doctor);
	}

	public void testDoctorDeleteByAddARecordWithWrongPhysicianLicenseNumAndWrongPassword() {

		doctor.setPhysicianLicenseNum("0");
		doctor.setPassword("-123");
		dao.delete(doctor);
	}

}
