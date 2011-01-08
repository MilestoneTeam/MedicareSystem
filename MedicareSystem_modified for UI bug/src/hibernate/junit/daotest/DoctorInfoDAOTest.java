package hibernate.junit.daotest;

import java.util.List;

import hibernate.dao.DoctorInfoDAO;
import hibernate.vo.userinfo.DoctorInfo;
import junit.framework.TestCase;

public class DoctorInfoDAOTest extends TestCase {
	public void testDoctorInfoSave() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo1 = new DoctorInfo();
		docinfo1.setPhysicianLicenseNum("aaaaaaaa");
		docinfo1.setAge(65);
		docinfo1.setHospital("中山大学第一附属医院");
		dao.save(docinfo1);
		
		DoctorInfo docinfo2 = new DoctorInfo();
		docinfo2.setPhysicianLicenseNum("bbbbbbbb");
		docinfo2.setLocation("广州大学城中环X路");
		docinfo2.setName("黑暗游侠");
		docinfo2.setProfession("Roshan");
		dao.save(docinfo2);
		
		DoctorInfo docinfo3 = new DoctorInfo();
		docinfo3.setPhysicianLicenseNum("cccccccc");
		docinfo3.setPhone("020-39331274");
		docinfo3.setProfession("Roshan");
		dao.save(docinfo3);
		
		DoctorInfo docinfo4 = new DoctorInfo();
		docinfo4.setPhysicianLicenseNum("dddddddd");
		docinfo4.setResume("imba");
		docinfo4.setSex( new Byte((byte) 0));
		dao.save(docinfo4);
		
	}
	
	public void testNoMatchQuery() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo docinfo = dao.findById("eeeeeeee");
		assertEquals( true, docinfo == null );
		
		DoctorInfo example = new DoctorInfo();
		
		example.setName("黑暗游侠");
		List<DoctorInfo> docinfolist = dao.findByExample(example);
		System.out.println( docinfolist.size());
		assertEquals( true, docinfolist.size() == 0 );
		
		docinfolist = dao.findByProperty("name", "巨魔战将");
		assertEquals( true, docinfolist.size() == 0 );
		
	}
	
/*	public void testMatchQuery() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo d = dao.findById("aa");
		System.out.println(d.getDoctor().getPassword());
		
	}
	
	public void testDoctorInfoDelete() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo d = dao.findById("aa");
		System.out.println(d.getDoctor().getPassword());
		
	}*/
}
