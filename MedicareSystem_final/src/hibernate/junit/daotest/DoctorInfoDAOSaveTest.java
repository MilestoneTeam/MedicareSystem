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
		doctorInfos.setHospital("��ɽ��ѧ��һ����ҽԺ");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndHospital() {
		saveADoctorInDatabaseForForeignKey("00000001", "000001");

		doctorInfos.setPhysicianLicenseNum("00000001");
		doctorInfos.setName("Lucy");
		doctorInfos.setHospital("��ɽ��ѧ�ڶ�����ҽԺ");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndSexAndHospital() {
		saveADoctorInDatabaseForForeignKey("00000002", "000002");

		doctorInfos.setPhysicianLicenseNum("00000002");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setHospital("��ɽ��ѧ��������ҽԺ");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndSexAndLocation() {
		saveADoctorInDatabaseForForeignKey("00000003", "000003");

		doctorInfos.setPhysicianLicenseNum("00000003");
		doctorInfos.setSex(new Byte((byte) 0));
		doctorInfos.setLocation("����԰2��");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndLocation() {
		saveADoctorInDatabaseForForeignKey("00000004", "000004");

		doctorInfos.setPhysicianLicenseNum("00000004");
		doctorInfos.setName("�ѻ���");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setLocation("����԰2��");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndLocationAndPhone() {
		saveADoctorInDatabaseForForeignKey("00000005", "000005");

		doctorInfos.setPhysicianLicenseNum("00000005");
		doctorInfos.setName("Sologone");
		doctorInfos.setSex(new Byte((byte) 1));
		doctorInfos.setLocation("����԰");
		doctorInfos.setPhone("110120119");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndLocationAndProfession() {
		saveADoctorInDatabaseForForeignKey("00000006", "000006");

		doctorInfos.setPhysicianLicenseNum("00000006");
		doctorInfos.setLocation("����");
		doctorInfos.setProfession("�������");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndAgeAndProfessionAndResume() {
		saveADoctorInDatabaseForForeignKey("00000007", "000007");

		doctorInfos.setPhysicianLicenseNum("00000007");
		doctorInfos.setAge(50);
		doctorInfos.setProfession("��ҽѧ");
		doctorInfos.setResume("��ʦ��������ʦ");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndLocationAndResume() {
		saveADoctorInDatabaseForForeignKey("00000008", "000008");
		doctorInfos.setPhysicianLicenseNum("00000008");
		doctorInfos.setName("����");
		doctorInfos.setLocation("���ӻ�");
		doctorInfos.setResume("�ֲ�Ƭ��Ա");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndLocationAndPhoneAndResume() {
		saveADoctorInDatabaseForForeignKey("00000009", "000009");
		doctorInfos.setPhysicianLicenseNum("00000009");
		doctorInfos.setName("xiaolulu");
		doctorInfos.setLocation("����԰2��321");
		doctorInfos.setPhone("�����Ҹ�Ů����");
		doctorInfos.setResume("δ��");
		daoin.save(doctorInfos);
	}

	public void testDoctorInfoSavePhysicianLicenseNumAndNameAndSexAndAgeAndProfessionAndHospitalAndLocationAndPhoneAndResume() {
		saveADoctorInDatabaseForForeignKey("100000000", "1000000");

		doctorInfos.setPhysicianLicenseNum("100000000");
		doctorInfos.setName("���");
		doctorInfos.setSex(new Byte((byte) 0));
		doctorInfos.setAge(16);
		doctorInfos.setProfession("Сѧ��ҵ");
		doctorInfos.setHospital("�����˼��һҽԺ");
		doctorInfos.setLocation("�����˼�");
		doctorInfos.setPhone("5151515151");
		doctorInfos.setResume("ϲ���������----������ʦ");
		daoin.save(doctorInfos);
	}
}
