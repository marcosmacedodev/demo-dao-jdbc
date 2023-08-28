package daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import daos.SellerDAO;
import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;

public class SellerDaoImpl implements SellerDAO{

	private Connection conn;
	
	public SellerDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+"FROM seller INNER JOIN department "
					+"ON seller.DepartmentId = department.Id "
					+"WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				Date birthDate = rs.getDate("BirthDate");
				Double baseSalary = rs.getDouble("BaseSalary");
				String depName = rs.getString("DepName");
				Integer departmentId = rs.getInt("DepartmentId");
				return new Seller(id, name, email, birthDate, baseSalary, new Department(departmentId, depName));
			}
			return null;
		}
		catch(SQLException ex) {
			throw new DbException(ex.getMessage());
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
