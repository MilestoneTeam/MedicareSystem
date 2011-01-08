package struts2.action.login;

import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.user.Doctor;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorLoginAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = -7120138636395312026L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	private Doctor doctor;

	@Override
	public String execute() throws Exception {
		if(existsDoctor()) {
			session.put("physicianLicenseNum", doctor.getPhysicianLicenseNum());	
			return SUCCESS;
		}
		request.put("fail", true);
		
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

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
