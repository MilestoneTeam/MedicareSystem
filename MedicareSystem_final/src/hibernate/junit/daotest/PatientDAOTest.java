package hibernate.junit.daotest;

import java.util.ArrayList;
import java.util.List;

import hibernate.dao.PatientDAO;
import hibernate.vo.user.Patient;
import junit.framework.TestCase;

public class PatientDAOTest extends TestCase {

	private PatientDAO dao = new PatientDAO();
	private Patient patient = new Patient();
	private List<Patient> patientlist = new ArrayList<Patient>();

	protected void tearDown() throws Exception {
		patientlist.clear();
		Patient patientInDataBase = dao.findById(patient.getMedicareNum());
		dao.delete(patientInDataBase);

	}

	public void testPatientSaveWithMedicareNumAndPasswordFollowRequirement02() {

		patient.setMedicareNum("12345678");
		patient.setPassword("22222");
		dao.save(patient);
	}

	public void testPatientSaveWithMedicareNumAndPasswordFollowRequirement03() {

		patient.setMedicareNum("________");
		patient.setPassword("33333");
		dao.save(patient);

	}

	public void testPatientSaveWithMedicareNumAndPasswordFollowRequirement04() {

		patient.setMedicareNum("aa11_bb22_");
		patient.setPassword("abcde");
		dao.save(patient);
	}

	public void testPatientSaveWithMedicareNumAndPasswordFollowRequirement05() {

		patient.setMedicareNum("_123_abc_3g");
		patient.setPassword("12345");
		dao.save(patient);
	}

	public void testPatientSaveWithPasswordHasSpecialCharacters01() {

		patient.setMedicareNum("abcdefg_123456");
		patient.setPassword("!@#$%");
		dao.save(patient);
	}

	public void testPatientSaveWithPasswordHasSpecialCharacters02() {

		patient.setMedicareNum("aaa1234567890");
		patient.setPassword("^&*()");
		dao.save(patient);
	}

	public void testPatientSaveWithMedicareNumAndPasswordBothHaveSpecialCharacters() {

		patient.setMedicareNum("_~!@#$%^&*()-=+");
		patient.setPassword("~-=+_");
		dao.save(patient);
	}

	public void testPatientSaveWithMedicareNumAndPasswordBothHaveSpecialCharactersOfSpace() {

		patient.setMedicareNum("123 456 890 ");
		patient.setPassword("12 34 ");
		dao.save(patient);
	}

	public void testPatientSaveWithMedicareNumAndPasswordAreBothAllSpaces() {

		patient.setMedicareNum("        ");
		patient.setPassword("     ");
		dao.save(patient);
	}

	public void testPatientSaveWithShorterMedicareNumThanRequired() {

		patient.setMedicareNum("1234");
		patient.setPassword("12abcd56");
		dao.save(patient);
	}

	public void testPatientSaveWithShorterPasswordThanRequired() {

		patient.setMedicareNum("asdfg5678");
		patient.setPassword("331");
		dao.save(patient);
	}

	public void testPatientSaveWithShorterBothMedicareNumAndPasswordThanRequired() {

		patient.setMedicareNum("2");
		patient.setPassword("1");
		dao.save(patient);
	}

	public void testPatientSaveWithBothMedicareNumAndPasswordAllHavePunctuations() {

		patient.setMedicareNum("127,。？78");
		patient.setPassword("，。、？：；");
		dao.save(patient);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumHasExistedByNumber() {

		patient.setMedicareNum("1");
		patient.setPassword("22222");
		dao.save(patient);
		patientlist = dao.findByProperty("medicareNum", "1");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumHasExistedBySpecialCharacters() {
		patient.setMedicareNum("_~!@#$%^&*()-=");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "_~!@#$%^&*()-=");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumHasExistedByNumberAndPunctuation() {
		patient.setMedicareNum("127,。？7");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "127,。？7");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumHasExistedBySpaces() {
		patient.setMedicareNum("        ");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "        ");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumNotExisted() {

		patient.setMedicareNum("127,。？7");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "123456789sda");
		assertEquals(true, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedByNumber() {
		patient.setMedicareNum("127,。？7");
		patient.setPassword("1");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "1");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedBySpecialCharacters() {
		patient.setMedicareNum("127,。？7");
		patient.setPassword("^&*()");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "^&*()");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedByByNumberAndSpace() {
		patient.setMedicareNum("127,。？7");
		patient.setPassword("12 34");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "12 34");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordHasExistedBySpaces() {
		patient.setMedicareNum("127,。？7");
		patient.setPassword("     ");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "     ");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyPasswordNotExisted() {

		patient.setMedicareNum("127,。？7");
		patient.setPassword("22222");
		dao.save(patient);
		patientlist = dao.findByProperty("password", "asdfgh");
		assertEquals(true, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingBothPropertyMedicareNumAndPasswordAllHasExisted() {

		patient.setMedicareNum("12345");
		patient.setPassword("12abcd5");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingNeitherPropertyMedicareNumOrPasswordHasExisted() {

		patient.setMedicareNum("111sss222aaa000");
		patient.setPassword("xiaolulu");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumExistedButPasswordNotExisted() {

		patient.setMedicareNum("_123_abc_3g");
		patient.setPassword("sxiaolulu");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testNoMatchQueryThroughByFindingPropertyMedicareNumNotExistedButPasswordExisted() {

		patient.setMedicareNum("YouAreBest!");
		patient.setPassword("11111");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumHasExistedByNumber() {

		patient.setMedicareNum("123456878");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "12345678");
		assertEquals(true, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumHasExistedBySpecialCharacters() {

		patient.setMedicareNum("________");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "________");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumHasExistedByNumberAndPunctuation() {
		patient.setMedicareNum("127,。？");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "127,。？");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumHasExistedBySpaces() {
		patient.setMedicareNum("      ");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "        ");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumNotExisted() {
		patient.setMedicareNum("127");
		patient.setPassword("22222");
		dao.save(patient);

		patientlist = dao.findByProperty("medicareNum", "kkkkkkk");
		assertEquals(true, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedByNumber() {
		patient.setMedicareNum("127");
		patient.setPassword("331");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "331");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedBySpecialCharacters() {
		patient.setMedicareNum("127");
		patient.setPassword("~-=+_");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "~-=+_");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedByByNumberAndCharacters() {
		patient.setMedicareNum("127");
		patient.setPassword("12abcd56");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "12abcd56");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordHasExistedBySpaces() {
		patient.setMedicareNum("127");
		patient.setPassword("      ");
		dao.save(patient);
		;

		patientlist = dao.findByProperty("password", "     ");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyPasswordNotExisted() {
		patient.setMedicareNum("1270");
		patient.setPassword("yahooo");
		dao.save(patient);

		patientlist = dao.findByProperty("password", "yahooo");
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingBothPropertyMedicareNumAndPasswordAllHasExisted() {

		patient.setMedicareNum("3");
		patient.setPassword("1");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingNeitherPropertyMedicareNumOrPasswordHasExisted() {

		patient.setMedicareNum("helloworld!");
		patient.setPassword("123321");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumExistedButPasswordNotExisted() {

		patient.setMedicareNum("1");
		patient.setPassword("sbiaolulu");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testMatchQueryThroughByFindingPropertyMedicareNumNotExistedButPasswordExisted() {

		patient.setMedicareNum("100and200");
		patient.setPassword("331");
		dao.save(patient);
		patientlist = dao.findByExample(patient);
		assertEquals(false, patientlist.size() == 0);
	}

	public void testPatientDeleteByAddARecord() {

		patient.setMedicareNum("aaaaaaaa");
		patient.setPassword("111111");
		dao.save(patient);
		dao.delete(patient);

		patient.setMedicareNum("aaaaaaaa");// 方便进行tearDown();
		patient.setPassword("111111");
		dao.save(patient);
	}

	public void testPatientDeleteByAddARecordWithWrongMedicareNumAndRightPassword() {

		patient.setMedicareNum("-1");
		patient.setPassword("111111");
		dao.save(patient);
		dao.delete(patient);

		patient.setMedicareNum("aaaaaaaa");// 方便进行tearDown();
		patient.setPassword("111111");
		dao.save(patient);
	}

	public void testPatientDeleteByAddARecordWithRightMedicareNumAndWrongPassword() {

		patient.setMedicareNum("12345678");
		patient.setPassword("-123");
		dao.save(patient);
		dao.delete(patient);

		patient.setMedicareNum("aaaaaaaa");// 方便进行tearDown();
		patient.setPassword("111111");
		dao.save(patient);
	}

	public void testPatientDeleteByAddARecordWithWrongMedicareNumAndWrongPassword() {

		patient.setMedicareNum("0");
		patient.setPassword("-123");
		dao.save(patient);
		dao.delete(patient);

		patient.setMedicareNum("aaaaaaaa");// 方便进行tearDown();
		patient.setPassword("111111");
		dao.save(patient);
	}

}
