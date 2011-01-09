package struts2.junit.actiontest.mocktest;


import hibernate.dao.IPatientDAO;
import hibernate.daofactory.PatientDAOFactory;
import hibernate.vo.user.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;

import struts2.action.add.userinfo.PatientAddInfoAction;

import com.opensymphony.xwork2.ActionSupport;

public class PatientAddInfoActionTest extends TestCase{
	private PatientAddInfoAction patientaddinfoaction = new PatientAddInfoAction();
	private Mockery context = new Mockery();
	
	final Patient  fakePatient = new Patient();
	final List<Patient> fakePatientlist = new ArrayList<Patient>();
	final IPatientDAO patientDAO = context.mock(IPatientDAO.class);
	final Patient patient = new Patient();
	
	protected void setUp() throws Exception {
		
		fakePatient.setPassword("987654321");
		fakePatient.setMedicareNum("跛足道人");
		fakePatientlist.add(fakePatient);
		patient.setPassword("987654321");
		patient.setMedicareNum("跛足道人");
		Map<String, Object> session = new HashMap< String, Object>();
		session.put("medicareNum", patient.getMedicareNum() );
		patientaddinfoaction.setPatient(patient);
		patientaddinfoaction.setSession(session);
    }
	
	public void testExecute1() throws Exception {      
			context.checking(new Expectations() {{
		    oneOf (patientDAO).findByExample(patient); will(returnValue(fakePatientlist));
		        }});
			
			PatientDAOFactory.setPatientDAO(patientDAO);
			String result = patientaddinfoaction.execute(); 
			assertEquals( ActionSupport.SUCCESS, result);
				
	    }
	
	public void testExecute2() throws Exception {
		fakePatientlist.clear();
		context.checking(new Expectations() {{
		    oneOf (patientDAO).findByExample(patient); will(returnValue(fakePatientlist));
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		String result = patientaddinfoaction.execute();
		assertEquals( ActionSupport.LOGIN, result);	
	}
}
