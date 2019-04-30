package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tmall.bean.User;
import tmall.util.DBUtil;

public class UserDAO {
	
	
	// Get the total number of users
	public int getTotal() {
		
		int total = 0;
		String sql = "select count(*) from User";
		
		 try {
			 
			 Connection c = DBUtil.getConnection();
			 Statement s = c.createStatement();
			 
			 ResultSet rs = s.executeQuery(sql);
			 
			 while (rs.next()) {
				 total = rs.getInt(1);
				 
			 } 
				 
		 }catch(SQLException e) {
			 
			 e.printStackTrace();
			
		 }
		return total;
	}
	
	// Create a user
	public void add(User bean) {
		
		String sql = "insert into user values(null, ?, ?)";
		
		try {
			Connection c = DBUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				
				int id = rs.getInt(1);
				bean.setId(id);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// Read a User
	public User get(int id){
		User user = null;
		String sql = "select * from User where id = " + id;
		
		try {
			Connection c = DBUtil.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				user = new User();
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return user;
		
	}
	
	// Update user
	public void update(User bean) {
		
		String sql = "update user set name = ? , password = ? where id = ?";
		try {
			
			Connection c = DBUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			ps.setInt(3, bean.getId());
			
			ps.execute();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	// Delete user (invalid action)
	public void delete(int id) {
		
		String sql = "delete from user where id = " + id;
		
		try {
			
			Connection c = DBUtil.getConnection();
			Statement s = c.createStatement();
			s.execute(sql);
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
