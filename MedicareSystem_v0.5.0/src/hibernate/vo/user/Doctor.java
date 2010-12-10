package hibernate.vo.user;

import hibernate.vo.userinfo.DoctorInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * Doctor entity. @author MyEclipse Persistence Tools
 */

public class Doctor implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -6350869443875137059L;
	private String physicianLicenseNum;
	private String password;
	private Set<DoctorInfo> doctorinfos = new HashSet<DoctorInfo>(0);

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
	public Doctor(String physicianLicenseNum, String password, Set<DoctorInfo> doctorinfos) {
		this.physicianLicenseNum = physicianLicenseNum;
		this.password = password;
		this.doctorinfos = doctorinfos;
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

	public Set<DoctorInfo> getDoctorinfos() {
		return this.doctorinfos;
	}

	public void setDoctorinfos(Set<DoctorInfo> doctorinfos) {
		this.doctorinfos = doctorinfos;
	}

}