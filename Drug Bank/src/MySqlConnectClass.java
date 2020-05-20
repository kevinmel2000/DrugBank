import java.sql.*;
import javax.swing.JOptionPane;

public class MySqlConnectClass {
	public static Connection connectDb(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection ret=DriverManager.getConnection("jdbc:mysql://localhost/mysql?useSSL=false","root","root");
		    
		    return ret;
			//here user is root
			//password is root (configure it manually)
			//Default database is mysql
			
			
			//JOptionPane.showMessageDialog(null,"Connection Established");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			//JOptionPane.showMessageDialog(null,"ji vai problem ekhanei");
			return null;
		}
	}
}
