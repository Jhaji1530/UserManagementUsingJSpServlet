package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import userDto.User;


public class UserDao 
{
	public Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jsp","root","root");
		return con;
	}
	public void insertUser(User user) throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps=getConnection().prepareStatement("insert into user values(?,?,?,?)");
		ps.setInt(1,user.getId());
		ps.setString(2,user.getName());
		ps.setLong(3,user.getPhone());
		ps.setString(4,user.getEmail());
		ps.execute();
	}
	public boolean validate(String email, int pass) throws ClassNotFoundException,SQLException
	{
		PreparedStatement ps=getConnection().prepareStatement("select * from user where email=? and phone=?");
		boolean result=false;
		ps.setString(1, email);
		ps.setLong(2, pass);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			 result=true;
		}
		return result;
	}
}