package hibernate.daofactory;

import hibernate.dao.PatientInfoDAO;

public class PatientInfoDAOFactory {
	
	private static PatientInfoDAO patientInfoDAOSingleInstance;
	
	public static PatientInfoDAO getDAO() {
		if(patientInfoDAOSingleInstance == null) {
			patientInfoDAOSingleInstance = new PatientInfoDAO();
		}
		
		return patientInfoDAOSingleInstance;
	}
	
}
