package struts2.junit.registertest;

import struts2.action.register.DoctorRegisterAction;
import junit.framework.TestCase;

public class DoctorRegisterActionTest extends TestCase {
	public void testIdValid1() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123");
		da.setPhysicianLicenseNum("qweqweqwe");
		da.setReInputPassword("123123");
		assertEquals("success", da.execute());
	}
	
	public void testIdValid2() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123");
		da.setPhysicianLicenseNum("qweqweqweqweqweqweqwe");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid3() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123");
		da.setPhysicianLicenseNum("qweqwe");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid4() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123");
		da.setPhysicianLicenseNum("11111111%");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid5() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123");
		da.setPhysicianLicenseNum("qweqwe12");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid6() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123!@");
		da.setPhysicianLicenseNum("qweqwe12");
		da.setReInputPassword("123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid7() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword("123123");
		da.setPhysicianLicenseNum("qweqwe12");
		da.setReInputPassword("123");
		
		assertEquals("error", da.execute());
	}
	
	public void testIdValid8() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPassword(null);
		da.setPhysicianLicenseNum("qweqwe12");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
}
