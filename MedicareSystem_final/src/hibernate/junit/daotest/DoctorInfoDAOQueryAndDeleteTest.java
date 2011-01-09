package hibernate.junit.daotest;

import java.util.List;

import hibernate.dao.DoctorInfoDAO;
import hibernate.vo.userinfo.DoctorInfo;
import junit.framework.TestCase;

public class DoctorInfoDAOQueryAndDeleteTest extends TestCase {

	private DoctorInfoDAO dao = new DoctorInfoDAO();
	private DoctorInfo doctorInfo = new DoctorInfo();

	public void testNoMatchQueryByIdWithNegativeNumber() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("-17");
		assertEquals(true, docinfo == null);
	}

	public void testNoMatchQueryByIdWithZero() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("0");
		assertEquals(true, docinfo == null);
	}

	public void testNoMatchQueryByIdWithLargerThanCurrentStoredMaxId() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("13");
		assertEquals(true, docinfo == null);
	}

	public void testNoMatchQueryByIdWithIntegerButFloatFormat() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("5.00");
		assertEquals(true, docinfo == null);
	}

	public void testNoMatchQueryByIdWithDecimal() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("8.12");
		assertEquals(true, docinfo == null);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("physicianLicenseNum",
				"5555");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPhysicianLicenseNumExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("physicianLicenseNum",
				"1234");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameNotExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", "巨魔战将");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameIsRepeat() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", "Sologone");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySex() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("sex", ((byte) 1));

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySexIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("sex", null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySexWithIllegalValue() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("sex", ((byte) 4));

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeNotExist() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("age", 10);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeExist() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("age", 16);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("age", null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryByIdBetweenCurrentStoredMinAndMax() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("7");
		assertEquals(true, docinfo == null);
	}

	public void testMatchQueryByCurrentStoredMinId() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("2");
		assertEquals(true, docinfo == null);
	}

	public void testMatchQueryByCurrentStoredMaxId() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("13");
		assertEquals(true, docinfo == null);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumNotExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("physicianLicenseNum",
				"oooooooo");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("physicianLicenseNum",
				"00000004");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPhysicianLicenseNumIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("physicianLicenseNum",
				null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", "狙击手");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameNotExisted() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", "lili");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameIsRepeat() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("name", "Sologone");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertySex() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("sex", ((byte) 0));

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertySexIsNULL() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("sex", null);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyAgeExist() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("age", 15);

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyLocationExist() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("location", "至善园2号");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyHospitalExist() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		List<DoctorInfo> docinfo = dao.findByProperty("hospital", "天上人间第一医院");

		assertEquals(true, docinfo.size() == 0);
	}

	public void testDoctorInfoDeleteThroughAddAnRecordWithAge() {
		doctorInfo.setAge(34);
		dao.delete(doctorInfo);
	}

	public void testDoctorInfoDeleteThroughAddAnRecordWithHospital() {

		doctorInfo.setHospital("恐怖医院");
		dao.delete(doctorInfo);
	}

	public void testDoctorInfoDeleteThroughAddAnRecordWithLocation() {
		doctorInfo.setLocation("天堂吧");
		dao.delete(doctorInfo);
	}

	public void testDoctorInfoDeleteThroughAddAnRecordWithPhysicianLicenseNum() {

		doctorInfo.setPhysicianLicenseNum("00000000");
		dao.delete(doctorInfo);
	}

	public void testDoctorInfoDeleteThroughAddAnRecordWith() {

		doctorInfo.setSex(new Byte((byte) 0));
		doctorInfo.setPhone("1234");
		dao.delete(doctorInfo);
	}
}
