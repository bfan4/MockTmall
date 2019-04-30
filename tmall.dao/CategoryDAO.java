package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Category;
import tmall.util.DBUtil;

public class CategoryDAO {

	// Get the total number of object in Category table
	public int getTotal() {
		int total = 0;
		try {
			Connection c = DBUtil.getConnection();
			Statement s = c.createStatement();
			String sql = "select count(*) from Category";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	// Create 
	public void add(Category bean) {
		String sql = "insert into Category values(null, ?) ";
		try {
			
			Connection c = DBUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, bean.getName());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				
				int id = rs.getInt(1);
				bean.setId(id);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Read
	public Category get(int id) {
		Category bean = null;
		
		try {
			
			Connection c = DBUtil.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Category where id =" + id;
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				
				bean = new Category();
				bean.setName(rs.getString(2));
				bean.setId(id);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return bean;
	}
	
	// Update 
	public void update( Category bean) {
		String sql = "update Category set name = ? where id = ?";
		try {
			Connection c = DBUtil.getConnection();
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, bean.getId());
			ps.setString(2, bean.getName());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Delete
	public void delete(int id) {
		String sql = "delete from Category where id = " + id;
		try {
			
			Connection c = DBUtil.getConnection();
			Statement s = c.createStatement();
			s.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// List all of the items in the Category table
	public List<Category> list(){
		
		return list(0, Short.MAX_VALUE);
		
	}
	
	// List COUNT items from START 
	public List<Category> list(int start, int count){
		
		String sql = "select * from Category order by id desc limit ?,?";
		List<Category> beans = new ArrayList<Category> ();
		
		try {
			
			Connection c = DBUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Category bean = new Category();
				
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				beans.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return beans;
		
	}


	
}



















