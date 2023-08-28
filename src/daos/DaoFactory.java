package daos;

import entities.Department;
import entities.Seller;

public class DaoFactory {
	
	public static EntityDAO<Department> createDepartamentDAO() {
		return new DepartmentDAO();
	}
	
	public static EntityDAO<Seller> createSellerDAO() {
		return new SellerDAO();
	}

}
