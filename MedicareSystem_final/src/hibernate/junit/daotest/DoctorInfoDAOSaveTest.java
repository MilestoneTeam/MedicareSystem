package hibernate.junit.daotest;

import java.util.ArrayList;

import hibernate.dao.DoctorDAO;
import hibernate.dao.DoctorInfoDAO;

import hibernate.vo.user.Doctor;
import hibernate.vo.userinfo.DoctorInfo;
import junit.framework.TestCase;

public class DoctorInfoDAOSaveTest extends TestCase {

	private DoctorInfoDAO daoin = new DoctorInfoDAO();
	private DoctorInfo doctorInfos = new DoctorInfo();
	private DoctorDAO dao = new DoctorDAO();
	private Doctor doctorForForeignKeyConstaint = new Doctor();
	private ArrayList<DoctorInfo> docinfolist = new ArrayList<DoctorInfo>();

	protected void tearDown() throws Exception {
		docinfolist.clear();
		daoin.delete(doctorInfos);
		dao.delete(doctorForForeignKeyConstaint);
	}

	private void saveADoctorInDatabaseForForeignKey(String PhysicianLicenseNum,
			String password) {
		doctorForForeignKeyConstaint
				.setPhysicianLicenseNum(PhysicianLicenseNum);
		doctorForForeignKeyConstaint.setPassword(password);

		dao.save(doctorForForeignKeyConstaint);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndAgeAndHospital() {

		saveADoctorInDatabaseForForeignKey("00000000", "000000");
		doctorInfos.setPhysicianLicenseNum("00000000");
		doctorInfos.setAge(65);
		doctorInfos.setHospital("中山大学第一附属医院");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndHospital() {
		saveADoctorInDatabaseForForeignKey("00000001", "000001");

		doctorInfos.setPhysicianLicenseNum("00000001");
		doctorInfos.setName("Lucy");
		doctorInfos.setHospital("中山大学第二附属医院");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndSexAndHospital() {
		saveADoctorInDatabaseForForeignKey("00000002", "000002");

		doctorInfos.setPhysicianLicenseNum("00000002");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setHospital("中山大学第三附属医院");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndSexAndLocation() {
		saveADoctorInDatabaseForForeignKey("00000003", "000003");

		doctorInfos.setPhysicianLicenseNum("00000003");
		doctorInfos.setSex(new Byte((byte) 0));
		doctorInfos.setLocation("至善园2号");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndLocation() {
		saveADoctorInDatabaseForForeignKey("00000004", "000004");

		doctorInfos.setPhysicianLicenseNum("00000004");
		doctorInfos.setName("狙击手");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setLocation("至善园2号");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndLocationAndPhone() {
		saveADoctorInDatabaseForForeignKey("00000005", "000005");

		doctorInfos.setPhysicianLicenseNum("00000005");
		doctorInfos.setName("Sologone");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setLocation("明德园");
		doctorInfos.setPhone("110120119");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndLocationAndProfession() {
		saveADoctorInDatabaseForForeignKey("00000006", "000006");

		doctorInfos.setPhysicianLicenseNum("00000006");
		doctorInfos.setLocation("天堂");
		doctorInfos.setProfession("软件工程");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndAgeAndProfessionAndResume() {
		saveADoctorInDatabaseForForeignKey("00000007", "000007");

		doctorInfos.setPhysicianLicenseNum("00000007");
		doctorInfos.setAge(50);
		doctorInfos.setProfession("法医学");
		doctorInfos.setResume("老师是王青老师");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndLocationAndResume() {
		saveADoctorInDatabaseForForeignKey("00000008", "000008");
		doctorInfos.setPhysicianLicenseNum("00000008");
		doctorInfos.setName("贞子");
		doctorInfos.setLocation("电视机");
		doctorInfos.setResume("恐怖片演员");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndLocationAndPhoneAndResume() {
		saveADoctorInDatabaseForForeignKey("00000009", "000009");
		doctorInfos.setPhysicianLicenseNum("00000009");
		doctorInfos.setName("xiaolulu");
		doctorInfos.setLocation("至善园2号321");
		doctorInfos.setPhone("我想找个女朋友");
		doctorInfos.setResume("未婚");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndAgeAndProfessionAndHospitalAndLocationAndPhoneAndResume() {
		saveADoctorInDatabaseForForeignKey("100000000", "1000000");

		doctorInfos.setPhysicianLicenseNum("100000000");
		doctorInfos.setName("凤姐");
		doctorInfos.setSex(new Byte((byte) 0));
		doctorInfos.setAge(16);
		doctorInfos.setProfession("小学毕业");
		doctorInfos.setHospital("天上人间第一医院");
		doctorInfos.setLocation("天上人间");
		doctorInfos.setPhone("5151515151");
		doctorInfos.setResume("喜欢软件工程----的王老师");
		daoin.save(doctorInfos);
	}
}
