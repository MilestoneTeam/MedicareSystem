package hibernate.daofactory;

import hibernate.dao.DoctorInfoDAO;

public class DoctorInfoDAOFactory {
	
	private static DoctorInfoDAO doctorInfoDAOSingleInstance;
	
	public static DoctorInfoDAO getDAO() {
		if(doctorInfoDAOSingleInstance == null) {
			doctorInfoDAOSingleInstance = new DoctorInfoDAO();
		}
		
		return doctorInfoDAOSingleInstance;
	}
	
}
