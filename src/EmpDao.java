import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sun.org.apache.xerces.internal.util.Status;

public class EmpDao {
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root" , "abc123");
			
		}
		catch(Exception e)
		{
			
		}
		return con;
		
	}
	
	public static int save(Employee e)
	{
		int Status =0;
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps =  con.prepareStatement("insert into user (name,password,email,con values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCon());
			
		    Status = ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return Status;
		
	}
	
	public static int update(Employee e)
	{
		int Status =0;
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps =  con.prepareStatement("update user set name=?,pass=?,email=?,con=?; where id=?");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCon());
			ps.setInt(5, e.getId());
			
		    Status = ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return Status;
		
	}
	
	public static int delete(Employee e)
	{
		int Status =0;
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps =  con.prepareStatement("delete from user set  where id=?");
			
			
			ps.setInt(1, e.getId());
			
		    Status = ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return Status;
		
	}
	
	
	
	
	
	

}
