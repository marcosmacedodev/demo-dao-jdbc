package app;

import daos.DaoFactory;
import daos.SellerDAO;
import db.DB;
import entities.Seller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SellerDAO sellerDAO = DaoFactory.createSellerDAO();
		
		Seller seller = sellerDAO.findById(3);
		
		System.out.println(seller);
		
		DB.closeConnection();

	}

}
