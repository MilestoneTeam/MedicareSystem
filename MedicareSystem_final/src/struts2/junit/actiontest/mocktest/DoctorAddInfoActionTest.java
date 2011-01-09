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

import struts2.action.add.userinfo.DoctorAddInfoAction;

import com.opensymphony.xwork2.ActionSupport;
public class DoctorAddInfoActionTest extends TestCase {
	private DoctorAddInfoAction doctoraddinfoaction = new DoctorAddInfoAction();
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
		Map<String, Object> session = new HashMap< String, Object>();
		session.put("physicianLicenseNum", doctor.getPhysicianLicenseNum());
	
		doctoraddinfoaction.setDoctor(doctor);
		doctoraddinfoaction.setSession(session);
    }
	
	public void testExecute1() throws Exception {
		    
		context.checking(new Expectations() {{
	    oneOf (doctorDAO).findByExample(doctor); will(returnValue(fakeDoctorlist));
	        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		String result = doctoraddinfoaction.execute(); 
		assertEquals( ActionSupport.SUCCESS, result);
		
	}
	
	public void testExecute2() throws Exception {
		fakeDoctorlist.clear();
		context.checking(new Expectations() {{
		    oneOf (doctorDAO).findByExample(doctor); will(returnValue(fakeDoctorlist));
		        }});
		
		DoctorDAOFactory.setDoctorDAO(doctorDAO);
		String result = doctoraddinfoaction.execute();
		assertEquals( ActionSupport.LOGIN, result);
	}
	
}
