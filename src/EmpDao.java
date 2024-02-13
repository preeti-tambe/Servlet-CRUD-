import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.Status;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
	
	public static Employee getEmployeeId(int id)
	{
		Employee e =new Employee();
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps =  con.prepareStatement("select * from user where id=?");
			
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPass(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCon(rs.getString(5));
			
			}
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return e;
		
	}
	
	public static List getAllEmployees(){  
        List list=(List) new ArrayList<Employee>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPass(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCon(rs.getString(5));  
                ((ArrayList<Employee>) list).add(e);  
            }  
            con.close();  
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	}  
          
        return list;  
    }  

	
	
	
	
	
	

}
