package hibernate.junit.daotest;

import hibernate.dao.DoctorInfoDAO;
import hibernate.vo.userinfo.DoctorInfo;
import junit.framework.TestCase;

public class DoctorInfoDAOTest extends TestCase {
	public void testDoctorInfoSave() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo d = dao.findById("aa");
		System.out.println(d.getDoctor().getPassword());
		
	}
}
