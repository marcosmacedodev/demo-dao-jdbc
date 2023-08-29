package app;

import java.util.List;

import daos.DaoFactory;
import daos.SellerDAO;
import db.DB;
import entities.Seller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SellerDAO sellerDAO = DaoFactory.createSellerDAO();
		
		List<Seller> sellers = sellerDAO.findAll();
		for(Seller seller : sellers)
			System.out.println(seller);
		
		DB.closeConnection();

	}

}
