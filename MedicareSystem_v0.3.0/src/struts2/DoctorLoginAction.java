package struts2;

import hibernate.vo.Doctor;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorLoginAction extends ActionSupport {

	private static final long serialVersionUID = -7120138636395312026L;
	private Doctor doctor;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

}
