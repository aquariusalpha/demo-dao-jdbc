package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	// forçando injeçao de dependência por meio do construtor abaixo
	public DepartmentDaoJDBC(Connection conn){
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = conn.prepareStatement(
					"SELECT department.* "
					+ "FROM Department " 
					+ "WHERE Department.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()){
				Department obj = instantiateDepartment(rs);
				return obj;
			}
				return null;
			}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep  = new Department();
		dep.setId(rs.getInt("id"));
		dep.setName(rs.getString("name"));
		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = conn.prepareStatement(
					"SELECT department.* "
					+ "FROM department " 
					+ "ORDER BY Name");
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			while (rs.next()){
				Department obj = instantiateDepartment(rs);
				list.add(obj);
			}
			return list;
			}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
