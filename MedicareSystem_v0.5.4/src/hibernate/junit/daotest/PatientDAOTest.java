package hibernate.junit.daotest;

import java.util.List;

import hibernate.dao.PatientDAO;
import hibernate.vo.user.Patient;
import junit.framework.TestCase;

public class PatientDAOTest extends TestCase {
	public void testPatientSave() {
		Patient patient = new Patient();
		patient.setMedicareNum("xiaolulu");
		patient.setPassword("123456");
		PatientDAO dao = new PatientDAO();
		dao.save(patient);
		
		patient.setMedicareNum("Littlelulu");
		patient.setPassword("456789");
		dao.save(patient);
		
		patient.setMedicareNum("sbxiaolulu");
		patient.setPassword("456789");
		dao.save(patient);
		
	}
	
	public void testNoMatchQuery() {
		PatientDAO dao = new PatientDAO();
		Patient patient = dao.findById("nishisb");
		assertEquals( true, patient == null );
		
		patient = new Patient();
		patient.setMedicareNum("yangtuo");
		patient.setPassword("456789");
		List<Patient> patientlist = dao.findByExample(patient);
		assertEquals( true, patientlist.size() == 0 );
		
		patient = new Patient();
		patient.setMedicareNum("sbxiaolulu");
		patient.setPassword("987654");
		patientlist = dao.findByExample(patient);
		assertEquals( true, patientlist.size() == 0 );
		
	}
	
	public void testMatchQuery() {
		PatientDAO dao = new PatientDAO();
		Patient patient = dao.findById("Littlelulu");
		assertEquals( false, patient == null );
		
		Patient example = new Patient();
		example.setMedicareNum("sbxiaolulu");
		example.setPassword("456789");
		List<Patient> patientlist = dao.findByExample(example);
		System.out.println( patientlist.size());
		assertEquals( false, patientlist.size() == 0 );
		
		patientlist = dao.findByProperty("medicareNum", "xiaolulu");
		assertEquals( false, patientlist.size() == 0 );
		
		patientlist = dao.findByProperty("password", "456789");
		assertEquals( true, patientlist.size() == 2 );
		
	}
	
	public void testPatientDelete() {
		PatientDAO dao = new PatientDAO();
		Patient patient = dao.findById("xiaolulu");
		dao.delete(patient);
		patient = dao.findById("xiaolulu");
		assertEquals( true, patient == null );
		
		patient = new Patient();
		patient.setMedicareNum("sbxiaolulu");
		patient.setPassword("123456789");
	}
}
