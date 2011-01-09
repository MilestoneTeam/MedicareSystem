package struts2.action.login;

import hibernate.daofactory.PatientDAOFactory;
import hibernate.vo.user.Patient;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PatientLoginAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = -3203048768696910194L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	private Patient patient;

	@Override
	public String execute() throws Exception {
		if(existsPatient()) {
			session.put("medicareNum", patient.getMedicareNum());
			return SUCCESS;
		}
		request.put("fail", true);
		
		return LOGIN;
	}

	private boolean existsPatient() {
		List<Patient> queryResult = PatientDAOFactory.getDAO().findByExample(patient);
		
		return queryResult.size() != 0;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
