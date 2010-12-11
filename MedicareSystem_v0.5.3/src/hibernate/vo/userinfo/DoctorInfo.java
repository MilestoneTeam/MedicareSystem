package hibernate.vo.userinfo;

import hibernate.vo.user.Doctor;

/**
 * DoctorInfo entity. 
 * @author Milestone
 */

public class DoctorInfo implements java.io.Serializable {

	private static final long serialVersionUID = 3638134923726566351L;
	
	// Fields
	private String physicianLicenseNum;
	private Doctor doctor;
	private String name;
	private Byte sex;
	private Integer age;
	private String profession;
	private String hospital;
	private String location;
	private String phone;
	private String resume;
	
	// Constructors

	/** default constructor */
	public DoctorInfo() {
	}
	
	/** minimal constructor */
	public DoctorInfo(String physicianLicenseNum) {
		this.physicianLicenseNum = physicianLicenseNum;
	}
	
	/** full constructor */
	public DoctorInfo(String physicianLicenseNum, Doctor doctor, String name, Byte sex, Integer age,
			String profession, String hospital, String location, String phone,
			String resume) {
		this.physicianLicenseNum = physicianLicenseNum;
		this.doctor = doctor;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.hospital = hospital;
		this.location = location;
		this.phone = phone;
		this.resume = resume;
	}
	
	// Property accessors
	
	public String getPhysicianLicenseNum() {
		return physicianLicenseNum;
	}

	public void setPhysicianLicenseNum(String physicianLicenseNum) {
		this.physicianLicenseNum = physicianLicenseNum;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}