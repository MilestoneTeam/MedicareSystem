package hibernate.daofactory;

import hibernate.dao.DoctorDAO;

public class DoctorDAOFactory {
	
	private static DoctorDAO doctorDAOSingleInstance;
	
	public static DoctorDAO getDAO() {
		if(doctorDAOSingleInstance == null)
			doctorDAOSingleInstance = new DoctorDAO();
		
		return doctorDAOSingleInstance;
	}
	
}
