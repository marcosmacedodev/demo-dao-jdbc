package app;

import java.util.List;

import daos.DaoFactory;
import daos.DepartmentDAO;
import db.DB;
import entities.Department;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DepartmentDAO departmentDAO = DaoFactory.createDepartamentDAO();
		System.out.println("--------------FindAll----------------");
		System.out.println();
		List<Department> deps = departmentDAO.findAll();
		for(Department dep : deps)
			System.out.println(dep);
		
//		System.out.println("--------------Insert----------------");
//		System.out.println();
//		Seller newSeller = new Seller();
//		newSeller.setName("John Brown");
//		newSeller.setEmail("john_brown@outlook.com");
//		newSeller.setBirthDate(new Date());
//		newSeller.setBaseSalary(1000.0);
//		newSeller.setDepartment(new Department(2, null));
//		
//		sellerDAO.deleteById(8);
//		
//		System.out.println(newSeller);
		
		DB.closeConnection();

	}

}
