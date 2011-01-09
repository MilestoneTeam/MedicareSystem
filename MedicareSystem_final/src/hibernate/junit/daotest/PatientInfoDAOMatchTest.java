package hibernate.junit.daotest;

import hibernate.dao.PatientDAO;
import hibernate.dao.PatientInfoDAO;
import hibernate.vo.user.Patient;
import hibernate.vo.userinfo.PatientInfo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class PatientInfoDAOMatchTest extends TestCase {

	private PatientInfoDAO patientInfoDao = new PatientInfoDAO();
	private PatientInfo patientInfo = new PatientInfo();
	private PatientDAO patientDAO = new PatientDAO();// 外键约束；
	private Patient patientForForeignKeyConstaint = new Patient();
	private List<PatientInfo> patientInfolist = new ArrayList<PatientInfo>();

	protected void setUp() throws Exception {
		savePreparingPatientInDatabase();
		savePreparingPatientInfoInDatabase();
	}

	private void savePreparingPatientInfoInDatabase() {
		patientInfo.setMedicareNum("777");
		patientInfo.setName("Sologone");
		patientInfo.setSex(new Byte((byte) 1));
		patientInfo.setAge(16);
		patientInfo.setMarriage(0);
		patientInfo.setNationality("美国");
		patientInfoDao.save(patientInfo);
	}

	private void savePreparingPatientInDatabase() {
		patientForForeignKeyConstaint.setMedicareNum("777");
		patientForForeignKeyConstaint.setPassword("1");
		patientDAO.save(patientForForeignKeyConstaint);
	}

	protected void tearDown() throws Exception {
		patientInfolist.clear();
		PatientInfo patientInfoInDatabase = patientInfoDao.findById(patientInfo
				.getMedicareNum());
		patientInfoDao.delete(patientInfoInDatabase);
		Patient patientInDatabase = patientDAO
				.findById(patientForForeignKeyConstaint.getMedicareNum());
		patientDAO.delete(patientInDatabase);// 删除外键；

	}

	public void testNoMatchQueryByIdWithNegativeNumber() {
		PatientInfo patinfo = patientInfoDao.findById("-17");
		assertEquals(true, patinfo == null);
	}

	public void testNoMatchQueryByIdWithZero() {
		PatientInfo patinfo = patientInfoDao.findById("0");
		assertEquals(true, patinfo == null);
	}

	public void testNoMatchQueryByIdWithLargerThanCurrentStoredMaxId() {
		PatientInfo patinfo = patientInfoDao.findById("13");
		assertEquals(true, patinfo == null);
	}

	public void testNoMatchQueryByIdWithIntegerButFloatFormat() {
		PatientInfo patinfo = patientInfoDao.findById("5.00");
		assertEquals(true, patinfo == null);
	}

	public void testNoMatchQueryByIdWithDecimal() {
		PatientInfo patinfo = patientInfoDao.findById("8.12");
		assertEquals(true, patinfo == null);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumNotExisted() {
		patientInfolist = patientInfoDao.findByProperty("medicareNum", "5555");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumExisted() {
		patientInfolist = patientInfoDao.findByProperty("medicareNum", "777");
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameNotExisted() {
		patientInfolist = patientInfoDao.findByProperty("name", "巨魔战将");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("name", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyNameExisted() {
		patientInfolist = patientInfoDao.findByProperty("name", "Sologone");
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySex() {
		patientInfolist = patientInfoDao.findByProperty("sex", ((byte) 1));
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySexIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("sex", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertySexWithIllegalValue() {
		patientInfolist = patientInfoDao.findByProperty("sex", ((byte) 4));
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeNotExist() {
		patientInfolist = patientInfoDao.findByProperty("age", 10);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeExist() {
		patientInfolist = patientInfoDao.findByProperty("age", 16);
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyAgeIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("age", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMarriageIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("marriage", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMarriageExist() {
		patientInfolist = patientInfoDao.findByProperty("marriage", 0);
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMarriageNotExist() {
		patientInfolist = patientInfoDao.findByProperty("marriage", 1);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumNotExisted() {
		patientInfolist = patientInfoDao.findByProperty("medicareNum",
				"oooooooo");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumExisted() {
		patientInfolist = patientInfoDao.findByProperty("medicareNum", "1");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("medicareNum", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameExisted() {
		patientInfolist = patientInfoDao.findByProperty("name", "Sologone");
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameNotExisted() {
		patientInfolist = patientInfoDao.findByProperty("name", "lili");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("name", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNameIsRepeat() {
		patientInfolist = patientInfoDao.findByProperty("name", "Sologone");
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertySex() {
		patientInfolist = patientInfoDao.findByProperty("sex", ((byte) 1));
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertySexIsNULL() {
		patientInfolist = patientInfoDao.findByProperty("sex", null);
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyAgeExist() {
		patientInfolist = patientInfoDao.findByProperty("age", 16);
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMarriageExist() {
		patientInfolist = patientInfoDao.findByProperty("marriage", 0);
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNationalityExist() {
		patientInfolist = patientInfoDao.findByProperty("nationality", "美国");
		assertEquals(false, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNationalityNotExist() {
		patientInfolist = patientInfoDao.findByProperty("nationality", "中国");
		assertEquals(true, patientInfolist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyNationalityIsNull() {
		patientInfolist = patientInfoDao.findByProperty("nationality", null);
		assertEquals(true, patientInfolist.size() == 0);
	}
}
