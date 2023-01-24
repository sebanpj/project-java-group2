package version_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	//for the user to register into application
	
	public void  userreg(String name,String username,String password,int age,String mobilenumber) throws ClassNotFoundException {
	 Scanner sc = new Scanner(System.in);
System.out.println("         welcome to  REGISTER THE USER module");
     System.out.println("Enter Name");//name
     name = sc.next();
     System.out.println("Age");//age
     age = sc.nextInt();
     System.out.println("enter MobileNumber or Email");//email/phone
    mobilenumber = sc.next();
   

	try {
		   Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
	         String user="root";                          //user name of my sql
	         String pass="Seb@43021";                   //password of my sql
	         String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
	     Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database

		
		String sql = "INSERT INTO userinfo(name_, age, emailorphone) VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		con.setAutoCommit(false);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, mobilenumber);
		ps.execute();
		con.commit();
		con.close();
		
		System.out.println("The user is registered sucessfully");
		System.out.println("THANKYOU for registering..........");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("The user is not registered");
		System.out.println("Please provide valid details");
	}
    
    
	}
    
	}
	
	

