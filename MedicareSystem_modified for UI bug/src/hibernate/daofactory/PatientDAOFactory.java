package hibernate.daofactory;

import hibernate.dao.PatientDAO;

public class PatientDAOFactory {
	
	private static PatientDAO patientDAOSingleInstance;
	
	public static PatientDAO getDAO() {
		if(patientDAOSingleInstance == null) {
			patientDAOSingleInstance = new PatientDAO();
		}
		
		return patientDAOSingleInstance;
	}
	
}
