package daos;

import daos.impl.DepartmentDaoImpl;
import daos.impl.SellerDaoImpl;
import db.DB;

public class DaoFactory {
	
	public static DepartmentDAO createDepartamentDAO() {
		return new DepartmentDaoImpl();
	}
	
	public static SellerDAO createSellerDAO() {
		return new SellerDaoImpl(DB.getConnection());
	}

}
