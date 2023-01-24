package version_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	
//for the admin to add a flight he/she should login with valid username and password
	public void newflight(String flightno ,String from, String to , String dd , String ad , String rate , String classofflight) throws ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		if(username.equals("Admin")&& password.equals("admin123") ) {
		System.out.println("Enter flight number:");
		flightno = sc.next();
		System.out.println("Enter the from location:");
		from = sc.next();
		System.out.println("Enter to location:");
		to = sc.next();
		System.out.println("Enter the departure date:");
		dd = sc.next();
		System.out.println("Enter arrival date:");
		ad = sc.next();
		System.out.println("Enter rate:");
		rate = sc.next();
		System.out.println("choose class");
		System.out.println("1.economy");
		System.out.println("2. Business");
		System.out.println("3. Eco/Bus");
		int c = sc.nextInt();// selecting for class of flight
		
		if(c==1) {
			classofflight= "eco";
		}else if(c == 2 ) {
			classofflight = "bus";
		}else if (c ==3 ) {
			classofflight = "Eco & bus";
		}
			
	
	try {
		
	Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
    String user="root";                          //user name of my sql
    String pass="Seb@43021";                   //password of my sql
    String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database

    String sql = "INSERT INTO flights(flightno, From_, To_, depdate, arrdate, rate, class ) VALUES (?,?,?,?,?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	con.setAutoCommit(false);
	ps.setString(1,  flightno  );
	ps.setString(2,from);
	ps.setString(3, to);
	ps.setString(4, dd);
	ps.setString(5, ad);
	ps.setString(6, rate);
	ps.setString(7, classofflight);
	ps.execute();
	con.commit();
	con.close();
	System.out.println("The flight is added");
	}
	catch(SQLException ex) {
		 ex.printStackTrace();
	}
	
	}else {
		System.out.println("The username or password is incorrect");
		
	}}
	
	
	public void deletflight(String flino) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		if(username.equals("Admin")&& password.equals("admin123") ) {
		
			System.out.println("DELETE FLIGHT MODULE");
			System.out.println("Enter the flight number to be deleted");
			flino = sc.next();
			
			 try{
				 
		         Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
		         String user="root";                          //user name of my sql
		         String pass="Seb@43021";                   //password of my sql
		         String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
		     Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database
		         String sql = "delete  from flights where flightno =?"; // for deleting the details from database 
		 		PreparedStatement ps = con.prepareStatement(sql);
		 		con.setAutoCommit(false);
		 		ps.setString(1, flino);
		 		ps.execute();
		 		con.commit();
		 		con.close();
		 		
		        System.out.println("The flight has been deleted from database");
		     }
		     catch(Exception ex){
		         ex.printStackTrace();
		         System.out.println("Some eroor has occured please try again later");
		     }
			}else{
				System.out.println("The username or password is incorrect");
		}
			}
		
		
	}

	
	
	

