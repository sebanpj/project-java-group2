package version_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

public class SearchFlight {
	
	public void searchflight(String FromLocation,String ToLocation ){
	   Scanner sc =new Scanner(System.in);
      System.out.println("       Welcome to SEARCH FLIGHT Module    ");
       System.out.println("Enter From Location :");
        FromLocation =sc.nextLine();                          //user enter from and to location
       System.out.println("Enter To Location  :");
      ToLocation =sc.nextLine();
       try{
  		 
           Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
           String user="root";                          //user name of my sql
           String pass="Seb@43021";                   //password of my sql
           String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
       Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database
    String sql = "select * from flights where From_ =? && To_ = ?" ; // query to select flight from given from and to location
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, FromLocation);//seting the values 
		ps.setString(2, ToLocation);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			String flightno = rs.getString("flightno");
    			String fromloc = rs.getString("From_");
    			String toloc = rs.getString("To_");    			//the results are taken from databse and storeed
    			String depdate = rs.getString("depdate");    			
    			String ardate =rs.getString("arrdate");    			
    			String ra =  rs.getString("rate");
    			String classf = rs.getString("class");
    			System.out.println("Flight number: "+ flightno);
    		System.out.println("From location: " +fromloc);       //results are printed for the user 
    		System.out.println("To location: "+toloc);
    		System.out.println("Departure Date:"+ depdate );
    		System.out.println("Arrival Date: "+ ardate);
    		System.out.println("Rate: " +ra);
    		System.out.println("Class of flight avilable: "+ classf );
    		}
       }
       catch(Exception ex){
           ex.printStackTrace();
           System.out.println("The flights to the given location is not availiable ");
       }
       
       
	}

}
