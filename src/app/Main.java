package app;

import java.util.Date;
import java.util.List;

import daos.DaoFactory;
import daos.SellerDAO;
import db.DB;
import entities.Department;
import entities.Seller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SellerDAO sellerDAO = DaoFactory.createSellerDAO();
		System.out.println("--------------FindAll----------------");
		System.out.println();
		List<Seller> sellers = sellerDAO.findAll();
		for(Seller seller : sellers)
			System.out.println(seller);
		
//		System.out.println("--------------Insert----------------");
//		System.out.println();
//		Seller newSeller = new Seller();
//		newSeller.setName("John Brown");
//		newSeller.setEmail("john_brown@outlook.com");
//		newSeller.setBirthDate(new Date());
//		newSeller.setBaseSalary(1000.0);
//		newSeller.setDepartment(new Department(2, null));
//		
//		sellerDAO.insert(newSeller);
//		
//		System.out.println(newSeller);
		
		DB.closeConnection();

	}

}
