package hibernate.vo;

/**
 * DoctorInfo entity. @author MyEclipse Persistence Tools
 */

public class DoctorInfo implements java.io.Serializable {

	// Fields

	private DoctorInfoId id;
	private Doctor doctor;

	// Constructors

	/** default constructor */
	public DoctorInfo() {
	}

	/** full constructor */
	public DoctorInfo(DoctorInfoId id, Doctor doctor) {
		this.id = id;
		this.doctor = doctor;
	}

	// Property accessors

	public DoctorInfoId getId() {
		return this.id;
	}

	public void setId(DoctorInfoId id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}