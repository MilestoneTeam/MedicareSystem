package hibernate.junit.daotest;

import hibernate.dao.DoctorDAO;
import hibernate.vo.user.Doctor;
import junit.framework.TestCase;

public class DoctorDAOSaveTest extends TestCase {
	private DoctorDAO dao = new DoctorDAO();
	private Doctor doctor = new Doctor();

	public void tearDown() throws Exception {

		dao.delete(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordFollowRequirement01() {
		doctor.setPhysicianLicenseNum("aaaaaaaa");
		doctor.setPassword("11111");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordFollowRequirement02() {
		doctor.setPhysicianLicenseNum("12345678");
		doctor.setPassword("22222");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordFollowRequirement03() {
		doctor.setPhysicianLicenseNum("________");
		doctor.setPassword("33333");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordFollowRequirement04() {
		doctor.setPhysicianLicenseNum("aa11_bb22_");
		doctor.setPassword("abcde");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordFollowRequirement05() {
		doctor.setPhysicianLicenseNum("_123_abc_3g");
		doctor.setPassword("12345");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPasswordHasSpecialCharacters01() {
		doctor.setPhysicianLicenseNum("abcdefg_123456");
		doctor.setPassword("!@#$%");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPasswordHasSpecialCharacters02() {
		doctor.setPhysicianLicenseNum("aaa1234567890");
		doctor.setPassword("^&*()");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordBothHaveSpecialCharacters() {
		doctor.setPhysicianLicenseNum("_~!@#$%^&*()-=+");
		doctor.setPassword("~-=+_");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordBothHaveSpecialCharactersOfSpace() {
		doctor.setPhysicianLicenseNum("123 456 890 ");
		doctor.setPassword("12 34 ");
		dao.save(doctor);
	}

	public void testDoctorSaveWithPhysicianLicenseNumAndPasswordAreBothAllSpaces() {
		doctor.setPhysicianLicenseNum("        ");
		doctor.setPassword("     ");

		dao.save(doctor);
	}

	public void testDoctorSaveWithShorterPhysicianLicenseNumThanRequired() {
		doctor.setPhysicianLicenseNum("1234");
		doctor.setPassword("12abcd56");
		dao.save(doctor);
	}

	public void testDoctorSaveWithShorterPasswordThanRequired() {
		doctor.setPhysicianLicenseNum("asdfg5678");
		doctor.setPassword("331");
		dao.save(doctor);
	}

	public void testDoctorSaveWithShorterBothPhysicianLicenseNumAndPasswordThanRequired() {
		doctor.setPhysicianLicenseNum("1");
		doctor.setPassword("1");
		dao.save(doctor);
	}

	public void testDoctorSaveWithBothPhysicianLicenseNumAndPasswordAllHavePunctuations() {
		doctor.setPhysicianLicenseNum("127,¡££¿78");
		doctor.setPassword("£¬¡£¡¢£¿£º£»");
		dao.save(doctor);
	}
}
