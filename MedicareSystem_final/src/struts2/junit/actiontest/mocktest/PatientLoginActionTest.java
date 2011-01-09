package struts2.junit.actiontest.mocktest;

import struts2.action.login.*;

import hibernate.dao.*;
import hibernate.vo.user.*;
import hibernate.daofactory.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import junit.framework.*;

import org.jmock.Expectations;
import org.jmock.Mockery;

import com.opensymphony.xwork2.ActionSupport;

public class PatientLoginActionTest extends TestCase {
	private PatientLoginAction patientloginaction = new PatientLoginAction();
	private Mockery context = new Mockery();
	final Patient fakePatient = new Patient();
	final List<Patient> fakePatientlist = new ArrayList<Patient>();
	final IPatientDAO patientDAO = context.mock(IPatientDAO.class);
	final Patient patient = new Patient();

	protected void setUp() throws Exception {
		fakePatient.setPassword("987654321");
		fakePatient.setMedicareNum("õË×ãµÀÈË");
		fakePatientlist.add(fakePatient);
		patient.setPassword("987654321");
		patient.setMedicareNum("õË×ã");
		patientloginaction.setPatient(patient);

		Map<String, Object> session = new HashMap<String, Object>();
		patientloginaction.setSession(session);

		Map<String, Object> request = new HashMap<String, Object>();
		patientloginaction.setRequest(request);

	}

	public void testExecute1() throws Exception {

		context.checking(new Expectations() {
			{
				oneOf(patientDAO).findByExample(patient);
				will(returnValue(fakePatientlist));
			}
		});

		PatientDAOFactory.setPatientDAO(patientDAO);
		String result = patientloginaction.execute();
		assertEquals(ActionSupport.SUCCESS, result);

	}

	public void testExecute2() throws Exception {
		fakePatientlist.clear();
		context.checking(new Expectations() {
			{
				oneOf(patientDAO).findByExample(patient);
				will(returnValue(fakePatientlist));
			}
		});

		PatientDAOFactory.setPatientDAO(patientDAO);
		String result = patientloginaction.execute();
		assertEquals(ActionSupport.LOGIN, result);
	}
}
