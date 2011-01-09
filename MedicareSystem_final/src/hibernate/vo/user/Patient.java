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
	private Set<PatientInfo> patientInfos = new HashSet<PatientInfo>(0);

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
	public Patient(String medicareNum, String password, Set<PatientInfo> patientInfos) {
		this.medicareNum = medicareNum;
		this.password = password;
		this.setPatientInfos(patientInfos);
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

	public void setPatientInfos(Set<PatientInfo> patientInfos) {
		this.patientInfos = patientInfos;
	}

	public Set<PatientInfo> getPatientInfos() {
		return patientInfos;
	}

}