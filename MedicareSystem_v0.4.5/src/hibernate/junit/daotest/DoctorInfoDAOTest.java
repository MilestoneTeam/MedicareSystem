package hibernate.junit.daotest;

import hibernate.dao.DoctorInfoDAO;
import hibernate.vo.DoctorInfo;
import hibernate.vo.DoctorInfoId;
import junit.framework.TestCase;

public class DoctorInfoDAOTest extends TestCase {
	public void testDoctorInfoSave() {
		DoctorInfoDAO dao = new DoctorInfoDAO();
		DoctorInfo d = new DoctorInfo();
		DoctorInfoId did = new DoctorInfoId();
		did.setAge(1);
		//did.setDoctor(new Doctor)
	}
}
