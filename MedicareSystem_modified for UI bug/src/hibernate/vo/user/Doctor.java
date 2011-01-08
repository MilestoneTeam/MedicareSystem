package hibernate.vo.user;

import hibernate.vo.userinfo.DoctorInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * Doctor entity. 
 * @author Milestone
 */

public class Doctor implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -6350869443875137059L;
	private String physicianLicenseNum;
	private String password;
	private Set<DoctorInfo> doctorInfos = new HashSet<DoctorInfo>(0);

	// Constructors

	/** default constructor */
	public Doctor() {
	}

	/** minimal constructor */
	public Doctor(String physicianLicenseNum, String password) {
		this.physicianLicenseNum = physicianLicenseNum;
		this.password = password;
	}

	/** full constructor */
	public Doctor(String physicianLicenseNum, String password, Set<DoctorInfo> doctorInfos) {
		this.physicianLicenseNum = physicianLicenseNum;
		this.password = password;
		this.setDoctorInfos(doctorInfos);
	}

	// Property accessors

	public String getPhysicianLicenseNum() {
		return this.physicianLicenseNum;
	}

	public void setPhysicianLicenseNum(String physicianLicenseNum) {
		this.physicianLicenseNum = physicianLicenseNum;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDoctorInfos(Set<DoctorInfo> doctorInfos) {
		this.doctorInfos = doctorInfos;
	}

	public Set<DoctorInfo> getDoctorInfos() {
		return doctorInfos;
	}

}