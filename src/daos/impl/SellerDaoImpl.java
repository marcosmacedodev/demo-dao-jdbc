package daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findAll() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(					
					"SELECT seller.*, department.Name as DepName "
					+"FROM seller INNER JOIN department "
					+"ON seller.DepartmentId = department.Id "
					+"ORDER BY Name");
			List<Seller> sellers = new ArrayList<Seller>();
			Department department = null;
			while(rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				Date birthDate = rs.getDate("BirthDate");
				Double baseSalary = rs.getDouble("BaseSalary");
				if(department == null) {
					String depName = rs.getString("DepName");
					Integer departmentId = rs.getInt("DepartmentId");
					department = new Department(departmentId, depName);
				}
				Seller seller = new Seller(id, name, email, birthDate, baseSalary, department);
				sellers.add(seller);
			}
			return sellers;
		}
		catch(SQLException ex) {
			throw new DbException(ex.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+"FROM seller INNER JOIN department "
					+"ON seller.DepartmentId = department.Id "
					+"WHERE DepartmentId = ? "
					+"ORDER BY Name"
					);
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			List<Seller> sellers = new ArrayList<Seller>();
			while(rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				Date birthDate = rs.getDate("BirthDate");
				Double baseSalary = rs.getDouble("BaseSalary");
				//String depName = rs.getString("DepName");
				//Integer departmentId = rs.getInt("DepartmentId");
				Seller seller = new Seller(id, name, email, birthDate, baseSalary, department);
				sellers.add(seller);
			}
			return sellers;
		}
		catch(SQLException ex) {
			throw new DbException(ex.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
