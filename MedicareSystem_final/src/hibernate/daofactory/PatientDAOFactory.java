package hibernate.daofactory;

import hibernate.dao.IPatientDAO;
import hibernate.dao.PatientDAO;

public class PatientDAOFactory {
	
	private static IPatientDAO patientDAOSingleInstance;
	
	public static IPatientDAO getDAO() {
		if(patientDAOSingleInstance == null) {
			patientDAOSingleInstance = new PatientDAO();
		}
		
		return patientDAOSingleInstance;
	}
	
	public static void setPatientDAO( IPatientDAO patientDAO)
	{
		patientDAOSingleInstance = patientDAO;
	}
}
