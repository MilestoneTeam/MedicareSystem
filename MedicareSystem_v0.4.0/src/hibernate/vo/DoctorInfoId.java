package hibernate.vo;

/**
 * DoctorInfoId entity. @author MyEclipse Persistence Tools
 */

public class DoctorInfoId implements java.io.Serializable {

	// Fields

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
	public DoctorInfoId() {
	}

	/** minimal constructor */
	public DoctorInfoId(Doctor doctor) {
		this.doctor = doctor;
	}

	/** full constructor */
	public DoctorInfoId(Doctor doctor, String name, Byte sex, Integer age,
			String profession, String hospital, String location, String phone,
			String resume) {
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

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DoctorInfoId))
			return false;
		DoctorInfoId castOther = (DoctorInfoId) other;

		return ((this.getDoctor() == castOther.getDoctor()) || (this
				.getDoctor() != null
				&& castOther.getDoctor() != null && this.getDoctor().equals(
				castOther.getDoctor())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getSex() == castOther.getSex()) || (this.getSex() != null
						&& castOther.getSex() != null && this.getSex().equals(
						castOther.getSex())))
				&& ((this.getAge() == castOther.getAge()) || (this.getAge() != null
						&& castOther.getAge() != null && this.getAge().equals(
						castOther.getAge())))
				&& ((this.getProfession() == castOther.getProfession()) || (this
						.getProfession() != null
						&& castOther.getProfession() != null && this
						.getProfession().equals(castOther.getProfession())))
				&& ((this.getHospital() == castOther.getHospital()) || (this
						.getHospital() != null
						&& castOther.getHospital() != null && this
						.getHospital().equals(castOther.getHospital())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null
						&& castOther.getPhone() != null && this.getPhone()
						.equals(castOther.getPhone())))
				&& ((this.getResume() == castOther.getResume()) || (this
						.getResume() != null
						&& castOther.getResume() != null && this.getResume()
						.equals(castOther.getResume())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDoctor() == null ? 0 : this.getDoctor().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getSex() == null ? 0 : this.getSex().hashCode());
		result = 37 * result
				+ (getAge() == null ? 0 : this.getAge().hashCode());
		result = 37
				* result
				+ (getProfession() == null ? 0 : this.getProfession()
						.hashCode());
		result = 37 * result
				+ (getHospital() == null ? 0 : this.getHospital().hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		result = 37 * result
				+ (getResume() == null ? 0 : this.getResume().hashCode());
		return result;
	}

}