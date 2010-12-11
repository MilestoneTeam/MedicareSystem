package struts2.action.login;

import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.user.Doctor;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorLoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7120138636395312026L;
	private Map<String, Object> session;
	
	private Doctor doctor;

	@Override
	public String execute() throws Exception {
		if(existsDoctor()) {
			session.put("physicianLicenseNum", doctor.getPhysicianLicenseNum());	
			return SUCCESS;
		}
		this.addFieldError("doctor.physicianLicenseNum", "用户名或密码错误");
		
		return LOGIN;
	}

	private boolean existsDoctor() {
		List<Doctor> queryResult = DoctorDAOFactory.getDAO().findByExample(doctor);
		return queryResult.size() != 0;
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
