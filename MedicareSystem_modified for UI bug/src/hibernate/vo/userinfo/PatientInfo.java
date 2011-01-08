package hibernate.vo.userinfo;

import hibernate.vo.user.Patient;

import java.util.Date;

/**
 * PatientInfo entity. 
 * @author Milestone
 */

public class PatientInfo implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 2024813240297871781L;
	private String medicareNum;
	private Patient patient;
	private String name;
	private Byte sex;
	private Integer age;
	private Date birthday;
	private Integer marriage;
	private String nationality;

	// Constructors

	/** default constructor */
	public PatientInfo() {
	}

	/** minimal constructor */
	public PatientInfo(String medicareNum, Patient patient) {
		this.medicareNum = medicareNum;
		this.patient = patient;
	}

	/** full constructor */
	public PatientInfo(String medicareNum, Patient patient, String name,
			Byte sex, Integer age, Date birthday, Integer marriage,
			String nationality) {
		this.medicareNum = medicareNum;
		this.patient = patient;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.marriage = marriage;
		this.nationality = nationality;
	}

	// Property accessors

	public String getMedicareNum() {
		return this.medicareNum;
	}

	public void setMedicareNum(String medicareNum) {
		this.medicareNum = medicareNum;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return this.sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}