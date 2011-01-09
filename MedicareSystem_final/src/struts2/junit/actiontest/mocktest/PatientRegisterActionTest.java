package struts2.junit.actiontest.mocktest;

import hibernate.dao.IPatientDAO;
import hibernate.daofactory.PatientDAOFactory;
import hibernate.vo.user.Patient;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jmock.Expectations;
import org.jmock.Mockery;

import com.opensymphony.xwork2.ActionSupport;

import struts2.action.register.PatientRegisterAction;
import junit.framework.TestCase;

public class PatientRegisterActionTest extends TestCase {
	private PatientRegisterAction patientregisteraction = new PatientRegisterAction();
	private Mockery context = new Mockery();
	final Patient  fakePatient = new Patient();
	final List<Patient> fakePatientlist1 = null;
	final List<Patient> fakePatientlist2 = new ArrayList<Patient>();
	
	final IPatientDAO patientDAO = context.mock(IPatientDAO.class);
	final Patient patient = new Patient();

	protected void setUp() throws Exception {
		patientregisteraction.setMedicareNum("oldpatient");
		patientregisteraction.setPassword("999999999");
		patientregisteraction.setReInputPassword("999999999");
		
		Map<String,Object> session = new HashMap<String,Object>();
		patientregisteraction.setSession(session);
		
		Map<String, Object> request = new HashMap<String, Object>();
		patientregisteraction.setRequest(request);
		
		fakePatient.setMedicareNum("oldpatient");
		fakePatient.setPassword("999999999");
		fakePatientlist2.add(fakePatient);
		patient.setMedicareNum("oldpatient");
		patient.setPassword("999999999");
    }
	
	public void testExecute1() throws Exception {
		

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		
		context.checking(new Expectations() {{
		    oneOf (patientDAO).save(patient); 
		        }});
		
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute(); 
		assertEquals( ActionSupport.SUCCESS, result);
			
	}
	
	public void testExecute2() throws Exception {
		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist2));
		        }});
		context.checking(new Expectations() {{
		    oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute3() throws Exception {
		patientregisteraction.setMedicareNum(null);

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById(null); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute4() throws Exception {
		patientregisteraction.setMedicareNum("qq");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("qq"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute5() throws Exception {
		patientregisteraction.setMedicareNum("1234567");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("1234567"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute6() throws Exception {
		patientregisteraction.setMedicareNum("12345678");
		patient.setMedicareNum("12345678");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("12345678"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute7() throws Exception {
		patientregisteraction.setMedicareNum("123456789012345678901");
		patient.setMedicareNum("123456789012345678901");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("123456789012345678901"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute8() throws Exception {
		patientregisteraction.setMedicareNum("!@#$%^&*()");
		patient.setMedicareNum("!@#$%^&*()");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("!@#$%^&*()"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute9() throws Exception {
		patientregisteraction.setMedicareNum("________");
		patient.setMedicareNum("________");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("________"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute10() throws Exception {
		patientregisteraction.setMedicareNum("          ");
		patient.setMedicareNum("          ");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("          "); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute11() throws Exception {
		patientregisteraction.setMedicareNum("patient 001");
		patient.setMedicareNum("patient 001");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("patient 001"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute12() throws Exception {
		patientregisteraction.setPassword("1234");
		patientregisteraction.setReInputPassword("1234");
		patient.setPassword("1234");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute13() throws Exception {
		patientregisteraction.setPassword("12345");
		patientregisteraction.setReInputPassword("12345");
		patient.setPassword("12345");
		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute14() throws Exception {
		patientregisteraction.setPassword("12345678901234567890");
		patientregisteraction.setReInputPassword("12345678901234567890");
		patient.setPassword("12345678901234567890");
		fakePatientlist2.clear();
		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute15() throws Exception {
		patientregisteraction.setPassword("123456789012345678901");
		patientregisteraction.setReInputPassword("123456789012345678901");
		patient.setPassword("123456789012345678901");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute16() throws Exception {
		patientregisteraction.setPassword("123!@#_");
		patientregisteraction.setReInputPassword("123!@#_");
		patient.setPassword("123!@#_");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute17() throws Exception {
		patientregisteraction.setPassword("123&*~+|");
		patientregisteraction.setReInputPassword("123&*~+|");
		patient.setPassword("123&*~+|");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute18() throws Exception {
		patientregisteraction.setReInputPassword("9876543210");

		context.checking(new Expectations() {{
		    oneOf (patientDAO).findById("oldpatient"); will(returnValue(fakePatientlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (patientDAO).save(patient); 
		        }});
		
		PatientDAOFactory.setPatientDAO(patientDAO);
		patientregisteraction.setNewPatient( patient );
		String result = patientregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
}
