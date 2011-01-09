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

public class DoctorLoginActionTest extends TestCase {
	private DoctorLoginAction doctorloginaction = new DoctorLoginAction();
	private Mockery context = new Mockery();
	final Doctor  fakeDoctor = new Doctor();
	final List<Doctor> fakeDoctorlist = new ArrayList<Doctor>();
	final IDoctorDAO doctorDAO = context.mock(IDoctorDAO.class);
	final Doctor doctor = new Doctor();
	
	protected void setUp() throws Exception {
		fakeDoctor.setPassword("123456789");
		fakeDoctor.setPhysicianLicenseNum("江湖郎中");
		fakeDoctorlist.add(fakeDoctor);
		doctor.setPassword("123456789");
		doctor.setPhysicianLicenseNum("江湖郎中");
		
		doctorloginaction.setDoctor(doctor);
		Map<String, Object> session = new HashMap<String, Object>();
		doctorloginaction.setSession(session);
		
		Map<String, Object> request = new HashMap<String, Object>();
		doctorloginaction.setRequest(request);
    }
	
	public void testExecute1() throws Exception {
		   
			context.checking(new Expectations() {{
		    oneOf (doctorDAO).findByExample(doctor); will(returnValue(fakeDoctorlist));
		        }});
			
			DoctorDAOFactory.setDoctorDAO(doctorDAO);
			String result = doctorloginaction.execute(); 
			assertEquals( ActionSupport.SUCCESS, result);
				
	    }
	
	public void testExecute2() throws Exception {

		fakeDoctorlist.clear();
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findByExample(doctor); will(returnValue(fakeDoctorlist));
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		String result = doctorloginaction.execute();
		assertEquals( ActionSupport.LOGIN, result);	
	}
	
}
