package struts2.action.add.userinfo;

import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.user.Doctor;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorAddInfoAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7120138636395312026L;
	private Map<String, Object> session;
	private Doctor doctor;

	@Override
	public String execute() throws Exception {
		List<Doctor> queryResult = DoctorDAOFactory.getDAO().findByExample(doctor);
		if(queryResult.size() != 0) {
			session.put("physicianLicenseNum", doctor.getPhysicianLicenseNum());
			return SUCCESS;
		}
		
		return LOGIN;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
