package struts2;

import java.util.List;

import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.Doctor;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorLoginAction extends ActionSupport {

	private static final long serialVersionUID = -7120138636395312026L;
	private Doctor doctor;

	@Override
	public String execute() throws Exception {
		List<Doctor> queryResult = DoctorDAOFactory.getDAO().findByExample(doctor);
		if(queryResult.size() == 0)
			return LOGIN;
		
		return SUCCESS;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

}
