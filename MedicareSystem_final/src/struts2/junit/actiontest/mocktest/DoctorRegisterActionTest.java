package struts2.junit.actiontest.mocktest;

import hibernate.dao.IDoctorDAO;
import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.user.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;

import struts2.action.register.DoctorRegisterAction;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorRegisterActionTest extends TestCase{
	private DoctorRegisterAction doctorregisteraction = new DoctorRegisterAction();
	private Mockery context = new Mockery();
	final Doctor  fakeDoctor = new Doctor();
	final List<Doctor> fakeDoctorlist1 = null;
	final List<Doctor> fakeDoctorlist2 = new ArrayList<Doctor>();
	Map<String,Object> session;
	final IDoctorDAO doctorDAO = context.mock(IDoctorDAO.class);
	final Doctor doctor = new Doctor();
	
	protected void setUp() throws Exception {

		doctorregisteraction.setPhysicianLicenseNum("famousdoctor");
		doctorregisteraction.setPassword("123456789");
		doctorregisteraction.setReInputPassword("123456789");
		
		session = new HashMap<String,Object>();
		doctorregisteraction.setSession(session);
		
		Map<String, Object> request = new HashMap<String, Object>();
		doctorregisteraction.setRequest(request);
		
		fakeDoctor.setPhysicianLicenseNum("famousdoctor");
		fakeDoctor.setPassword("123456789");
		fakeDoctorlist2.add(fakeDoctor);
		doctor.setPhysicianLicenseNum("famousdoctor");
		doctor.setPassword("123456789");
    }
	
	public void testExecute1() throws Exception {
		
		
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).save(doctor); 
		        }});
		
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute(); 
		assertEquals( ActionSupport.SUCCESS, result);
	
	}
	
	public void testExecute2() throws Exception {
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist2));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute3() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum(null);

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById(null); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute4() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("qq");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("qq"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute5() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("1234567");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("1234567"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute6() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("12345678");
		doctor.setPhysicianLicenseNum("12345678");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("12345678"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute7() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("123456789012345678901");
		doctor.setPhysicianLicenseNum("123456789012345678901");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("123456789012345678901"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute8() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("!@#$%^&*()");
		doctor.setPhysicianLicenseNum("!@#$%^&*()");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("!@#$%^&*()"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute9() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("________");
		doctor.setPhysicianLicenseNum("________");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("________"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute10() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("          ");
		doctor.setPhysicianLicenseNum("          ");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("          "); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute11() throws Exception {
		doctorregisteraction.setPhysicianLicenseNum("doctor 001");
		doctor.setPhysicianLicenseNum("doctor 001");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("doctor 001"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute12() throws Exception {
		doctorregisteraction.setPassword("1234");
		doctorregisteraction.setReInputPassword("1234");
		doctor.setPassword("1234");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute13() throws Exception {
		doctorregisteraction.setPassword("12345");
		doctorregisteraction.setReInputPassword("12345");
		doctor.setPassword("12345");
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute14() throws Exception {
		doctorregisteraction.setPassword("12345678901234567890");
		doctorregisteraction.setReInputPassword("12345678901234567890");
		doctor.setPassword("12345678901234567890");
		fakeDoctorlist2.clear();
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute15() throws Exception {
		doctorregisteraction.setPassword("123456789012345678901");
		doctorregisteraction.setReInputPassword("123456789012345678901");
		doctor.setPassword("123456789012345678901");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute16() throws Exception {
		doctorregisteraction.setPassword("123!@#_");
		doctorregisteraction.setReInputPassword("123!@#_");
		doctor.setPassword("123!@#_");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.SUCCESS, result);
	}
	
	public void testExecute17() throws Exception {
		doctorregisteraction.setPassword("123&*~+|");
		doctorregisteraction.setReInputPassword("123&*~+|");
		doctor.setPassword("123&*~+|");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}
	
	public void testExecute18() throws Exception {
		doctorregisteraction.setReInputPassword("9876543210");

		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findById("famousdoctor"); will(returnValue(fakeDoctorlist1));
		        }});
		context.checking(new Expectations() {{
			oneOf (doctorDAO).save(doctor); 
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		doctorregisteraction.setNewDoctor( doctor );
		String result = doctorregisteraction.execute();
		assertEquals( ActionSupport.ERROR, result);
	}


}
