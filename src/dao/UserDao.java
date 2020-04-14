package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDao implements UserDaoInterface{

	@Override
	public int signup(User user) throws ClassNotFoundException{
		String INSERT_USERS_SQL = "insert into users (email,password) values (?,?)";
		int result = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			System.out.println(ps);
			result = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean loginUser(User user) {
		boolean status = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
