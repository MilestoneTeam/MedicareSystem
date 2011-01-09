package struts2.action.register;

import hibernate.daofactory.PatientDAOFactory;
import hibernate.vo.user.Patient;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PatientRegisterAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = 8573533407609895275L;
	private Map<String,Object> session;
	private Map<String,Object> request;

	private String medicareNum;
	private String password;
	private String reInputPassword;
	private Patient newPatient = new Patient();
	
	@Override
	public String execute() throws Exception {
		if(checkRegisterInformationValid()) {
			insertIntoDatabaseANewPatientRecord();
			session.put("medicareNum", medicareNum);
			
			return SUCCESS;
		}
		request.put("fail", true);
		
		return ERROR;
	}

	private void insertIntoDatabaseANewPatientRecord() {
		medicareNum = medicareNum.trim();
		newPatient.setMedicareNum(medicareNum);
		newPatient.setPassword(password);
		PatientDAOFactory.getDAO().save(newPatient);
	}
	
	private boolean checkRegisterInformationValid() {
		return checkRegisterIdValidAndAddFieldError() 
				&& checkRegisterIdNotExistsAndAddFieldError() 
				&& checkPasswordValidAndAddFieldError()
				&& checkPasswordAndReinputPasswordSameAndAddFieldError();
	}

	private boolean checkRegisterIdValidAndAddFieldError() {
		if(isRegisterIdValid())
			return true;
		
		this.addFieldError("medicareNum", "ҽ������ֻ������ĸ���������, ����Ϊ8��20λ, ��ĸ�����ִ�Сд");
		return false;
	}
	
	private boolean isRegisterIdValid() {
		return medicareNum != null 
					&& Pattern.matches("^[a-zA-Z0-9_]{8,20}$", medicareNum);
	}

	private boolean checkRegisterIdNotExistsAndAddFieldError() {
		if(PatientDAOFactory.getDAO().findById(medicareNum) == null)
			return true;
		
		this.addFieldError("medicareNum", "ҽ�������Ѵ���");
		return false;
	}
	
	private boolean checkPasswordValidAndAddFieldError() {
		if(isPasswordValid())
			return true;
		
		this.addFieldError("password", "����ֻ������ĸ�����ֺͣ� @ # _ ����, ����Ϊ5��20λ");
		return false;
	}
	
	private boolean isPasswordValid() {
		return password != null && Pattern.matches("^[a-zA-Z0-9!@#_]{5,20}$", password);
	}

	private boolean checkPasswordAndReinputPasswordSameAndAddFieldError() {
		if(password.equals(reInputPassword))
			return true;
		
		this.addFieldError("password", "������������벻һ��");
		return false;
	}

	public void setMedicareNum(String medicareNum) {
		this.medicareNum = medicareNum;
	}

	public String getMedicareNum() {
		return medicareNum;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setReInputPassword(String reInputPassword) {
		this.reInputPassword = reInputPassword;
	}

	public String getReInputPassword() {
		return reInputPassword;
	}

	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

	public Patient getNewPatient() {
		return newPatient;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
}
