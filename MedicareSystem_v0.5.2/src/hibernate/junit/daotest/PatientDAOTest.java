package hibernate.junit.daotest;

import hibernate.dao.PatientDAO;
import hibernate.vo.user.Patient;
import junit.framework.TestCase;

public class PatientDAOTest extends TestCase {
	public void testSavePatient() {
		Patient patient = new Patient();
		patient.setMedicareNum("12311");
		patient.setPassword("321");
		PatientDAO dao = new PatientDAO();
		dao.save(patient);
	}
}
