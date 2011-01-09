package struts2.action.register;

import hibernate.daofactory.DoctorDAOFactory;
import hibernate.vo.user.Doctor;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorRegisterAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = 8573533407609895275L;
	private Map<String,Object> session;
	private Map<String,Object> request;
	
	private String physicianLicenseNum;
	private String password;
	private String reInputPassword;
	private Doctor newDoctor = new Doctor();
	
	@Override
	public String execute() throws Exception {
		if(checkRegisterInformationValid()) {
			insertIntoDatabaseANewDoctorRecord();
			session.put("physicianLicenseNum", physicianLicenseNum);
			return SUCCESS;
		}
		request.put("fail", true);
		
		return ERROR;
	}

	private void insertIntoDatabaseANewDoctorRecord() {
		physicianLicenseNum = physicianLicenseNum.trim();
		newDoctor.setPhysicianLicenseNum(physicianLicenseNum);
		newDoctor.setPassword(password);
		DoctorDAOFactory.getDAO().save(newDoctor);
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
		
		this.addFieldError("physicianLicenseNum", "ҽʦ�ʸ�֤��ֻ������ĸ�����ֺ��»������, ����Ϊ8��20λ, ��ĸ�����ִ�Сд");
		return false;
	}
	
	private boolean isRegisterIdValid() {
		return physicianLicenseNum != null 
					&& Pattern.matches("^[a-zA-Z0-9_]{8,20}$", physicianLicenseNum);
	}

	private boolean checkRegisterIdNotExistsAndAddFieldError() {
		if(DoctorDAOFactory.getDAO().findById(physicianLicenseNum) == null)
			return true;
		
		this.addFieldError("physicianLicenseNum", "ҽʦ�ʸ�֤���Ѵ���");
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

	public void setPhysicianLicenseNum(String physicianLicenseNum) {
		this.physicianLicenseNum = physicianLicenseNum;
	}

	public String getPhysicianLicenseNum() {
		return physicianLicenseNum;
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
	
	public Doctor getNewDoctor() {
		return newDoctor;
	}

	public void setNewDoctor(Doctor newDoctor) {
		this.newDoctor = newDoctor;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
}
