package hibernate.daofactory;

import hibernate.dao.DoctorDAO;
import hibernate.dao.IDoctorDAO;

public class DoctorDAOFactory {
	
	private static IDoctorDAO doctorDAOSingleInstance;
	
	public static IDoctorDAO getDAO() {
		if(doctorDAOSingleInstance == null) {
			doctorDAOSingleInstance = new DoctorDAO();
		}
		
		return doctorDAOSingleInstance;
	}
	
	public static void setDoctorDAO( IDoctorDAO doctorDAO )
	{
		doctorDAOSingleInstance = doctorDAO;
	}
}
