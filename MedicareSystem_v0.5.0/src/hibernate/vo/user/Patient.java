package hibernate.vo.user;

import hibernate.vo.userinfo.PatientInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * Patient entity. 
 * @author Milestone
 */

public class Patient implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -1970838864283067828L;
	private String medicareNum;
	private String password;
	private Set<PatientInfo> patientinfos = new HashSet<PatientInfo>(0);

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String medicareNum, String password) {
		this.medicareNum = medicareNum;
		this.password = password;
	}

	/** full constructor */
	public Patient(String medicareNum, String password, Set<PatientInfo> patientinfos) {
		this.medicareNum = medicareNum;
		this.password = password;
		this.patientinfos = patientinfos;
	}

	// Property accessors

	public String getMedicareNum() {
		return this.medicareNum;
	}

	public void setMedicareNum(String medicareNum) {
		this.medicareNum = medicareNum;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PatientInfo> getPatientinfos() {
		return this.patientinfos;
	}

	public void setPatientinfos(Set<PatientInfo> patientinfos) {
		this.patientinfos = patientinfos;
	}

}