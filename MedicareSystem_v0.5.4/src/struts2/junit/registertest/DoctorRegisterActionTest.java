package struts2.junit.registertest;

import struts2.action.register.DoctorRegisterAction;
import junit.framework.TestCase;

public class DoctorRegisterActionTest extends TestCase {
	public void testDoctorRegisterActionValid1() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqweqwe");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		assertEquals("success", da.execute());
	}
	
	public void testDoctorRegisterActionValid2() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqweqweqweqweqweqwe");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid3() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqwe");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid4() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("11111111%");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid5() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqwe12");
		da.setPassword("123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid6() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqwe12");
		da.setPassword("123123!@");
		da.setReInputPassword("123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid7() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqwe12");
		da.setPassword("123123");
		da.setReInputPassword("123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid8() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("qweqwe12");
		da.setPassword(null);
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid9() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaoluluxiaoluluxiaolulu");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid10() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiaolulu@126.com");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid11() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiaolulu250");
		da.setPassword(null);
		da.setReInputPassword(null);
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid12() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum(null);
		da.setPassword(null);
		da.setReInputPassword(null);
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid13() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum(" ");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid14() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiao");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid15() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiao");
		da.setPassword("123123");
		da.setReInputPassword("123123");
		
		assertEquals("error", da.execute());
		
		
	}
	
	public void testDoctorRegisterActionValid16() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiaolulu");
		da.setPassword("12345");
		da.setReInputPassword("12345");
		
		assertEquals("success", da.execute());
	}
	
	public void testDoctorRegisterActionValid17() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("_xiaolulu01");
		da.setPassword("abcdefghijklmn123456");
		da.setReInputPassword("abcdefghijklmn123456");
		
		assertEquals("success", da.execute());
	}
	
	public void testDoctorRegisterActionValid18() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaolulu");
		da.setPassword("123456");
		da.setReInputPassword("123456");
		
		assertEquals("success", da.execute());
	}
	
	public void testDoctorRegisterActionValid19() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaolulu__1234567890");
		da.setPassword("123456");
		da.setReInputPassword("123456");
		
		assertEquals("success", da.execute());	
	}
	
	public void testDoctorRegisterActionValid20() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaolulu02");
		da.setPassword("1234");
		da.setReInputPassword("1234");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid21() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaolulu02");
		da.setPassword("abcdefghijklmnopqrstu");
		da.setReInputPassword("abcdefghijklmnopqrstu");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid22() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("XIAOLULU");
		da.setPassword("123456");
		da.setReInputPassword("123456");
		
		assertEquals("success", da.execute());
	}
	
	public void testDoctorRegisterActionValid23() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum("xiaolulu");
		da.setPassword("123456");
		da.setReInputPassword("123456");
		
		assertEquals("error", da.execute());
	}
	
	public void testDoctorRegisterActionValid24() throws Exception {
		DoctorRegisterAction da = new DoctorRegisterAction();
		da.setPhysicianLicenseNum(" shuzimeiti ");
		da.setPassword("123456");
		da.setReInputPassword("123456");
		
		assertEquals("success", da.execute());
	}
}
