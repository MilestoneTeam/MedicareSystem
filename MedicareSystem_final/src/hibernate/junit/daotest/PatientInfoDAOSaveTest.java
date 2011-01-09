package hibernate.junit.daotest;

import java.util.ArrayList;
import java.util.List;

import hibernate.dao.PatientDAO;
import hibernate.dao.PatientInfoDAO;
import hibernate.vo.user.Patient;
import hibernate.vo.userinfo.PatientInfo;
import junit.framework.TestCase;

public class PatientInfoDAOSaveTest extends TestCase {

	private PatientInfoDAO patientInfoDAO = new PatientInfoDAO();
	private PatientInfo patientInfo = new PatientInfo();
	private PatientDAO patientDAO = new PatientDAO();
	private Patient patientForForeignKeyConstaint = new Patient();
	private List<PatientInfo> patinfolist = new ArrayList<PatientInfo>();

	protected void tearDown() throws Exception {
		patinfolist.clear();
		patientInfoDAO.delete(patientInfo);
		patientDAO.delete(patientForForeignKeyConstaint);
	}

	public void testPatientInfoSaveMedicareNumAndAgeAndNationality() {
		saveAPatientInDatabaseForForeignKey("1", "1");

		patientInfo.setMedicareNum("1");
		patientInfo.setAge(65);
		patientInfo.setNationality("中国");
		
		patientInfoDAO.save(patientInfo);

	}

	private void saveAPatientInDatabaseForForeignKey(String medicareNum, String password) {
		patientForForeignKeyConstaint.setMedicareNum(medicareNum);
		patientForForeignKeyConstaint.setPassword(password);
		
		patientDAO.save(patientForForeignKeyConstaint);
	}

	public void testPatientInfoSaveMedicareNumAndNameAndNationality1() {
		saveAPatientInDatabaseForForeignKey("1234","1");

		patientInfo.setMedicareNum("1234");
		patientInfo.setName("Lucy");
		patientInfo.setNationality("美国");
		
		patientInfoDAO.save(patientInfo);

	}

	public void testPatientInfoSaveMedicareNumAndNameAndNationality2() {
		saveAPatientInDatabaseForForeignKey("00000000","1");

		patientInfo.setMedicareNum("00000000");
		patientInfo.setName("Lucy");
		patientInfo.setNationality("美国");
		
		patientInfoDAO.save(patientInfo);
	}

	public void testPatientInfoSaveMedicareNumAndSexAndNationality() {
		saveAPatientInDatabaseForForeignKey("00000001","1");

		patientInfo.setMedicareNum("00000001");
		patientInfo.setSex(new Byte((byte) 1));
		patientInfo.setNationality("英国");
		
		patientInfoDAO.save(patientInfo);
	}

	public void testPatientInfoSaveMedicareNumAndSexAndMarriage() {
		saveAPatientInDatabaseForForeignKey("00000002","1");

		patientInfo.setMedicareNum("00000002");
		patientInfo.setSex(new Byte((byte) 0));
		patientInfo.setMarriage(1);
		
		patientInfoDAO.save(patientInfo);
	}

	public void testPatientInfoSaveMedicareNumAndNameAndSexAndMarriage() {
		saveAPatientInDatabaseForForeignKey("00000003","1");

		patientInfo.setMedicareNum("00000003");
		patientInfo.setName("狙击手");
		patientInfo.setSex(new Byte((byte) 1));
		patientInfo.setMarriage(0);
		
		patientInfoDAO.save(patientInfo);
	}

	public void testPatientInfoSaveMedicareNumAndNameAndSexAndMarriageAndNationality() {
		saveAPatientInDatabaseForForeignKey("00000004","1");

		patientInfo.setMedicareNum("00000004");
		patientInfo.setName("Sologone");
		patientInfo.setSex(new Byte((byte) 1));
		patientInfo.setMarriage(0);
		patientInfo.setNationality("中国");
		
		patientInfoDAO.save(patientInfo);
	}

}
