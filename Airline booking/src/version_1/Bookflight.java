package version_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bookflight{

	public void bookflight(String flightno,String AgeGroup,String flightclass,String totaltickets, String payoption) throws ClassNotFoundException {
		
Scanner sc = new Scanner(System.in);	
   System.out.println("Enter flight number");  
 flightno= sc.nextLine();
   System.out.println("Age Group");
    AgeGroup = sc.next();
     System.out.println("Select Class of Flight");
     System.out.println("1. Business class");
     System.out.println("2. Economy class");
     int m = sc.nextInt();
     if(m == 1) {
    	  flightclass = "Bus";
     }else if(m==2) {
    	 flightclass = "Eco";
     }else {
 		System.out.println("Please give valid selection");
 	}
     System.out.println("Enter Number of Tickets");
     totaltickets = sc.next();
     System.out.println("Select Payment options");
     System.out.println("1. Card ");
     System.out.println("2. Upi");
     int n = sc.nextInt();
     if(n==1)
     {System.out.println("Enter the card number: ");
    	 String cardno = sc.next();
    	 System.out.println("The payment request will be sent you through email please accept the request");
    	 payoption = "Card ";
     }else if(n==2) {
    	 System.out.println("Enter the UPI id: ");
    	 String cardno = sc.next();
    	 System.out.println("The payment request will be sent you through email please accept the request");
    	 payoption = "UPI";
     }else {
 		System.out.println("Please give valid selection");
 	}
      
 	try {
 		Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
        String user="root";                          //user name of my sql
        String pass="Seb@43021";                   //password of my sql
        String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
    Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database

        String sql = "INSERT INTO flightsbooked(flightno, age, class, numberofticket, payment) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		con.setAutoCommit(false);
		ps.setString(1,  flightno  );
		ps.setString(2, AgeGroup);
		ps.setString(3, flightclass);
		ps.setString(4, totaltickets);
		ps.setString(5, payoption);
		ps.execute();
		
		String sql2 = "select  max(ticketno) from flightsbooked" ;
		PreparedStatement ps2 = con.prepareStatement(sql2);
int ticno= 0;
		ResultSet rs = ps2.executeQuery();
		while(rs.next()) {
		 ticno = rs.getInt("max(ticketno)");
		}
		con.commit();
		con.close();
		System.out.println("The flight has been booked");
		System.out.println( "Your ticket number is: "+ticno);
 		System.out.println("Please proceed with the payment");
 		System.out.println("............THANKYOU for booking...........");
 	} catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		System.out.println("Sorry some Error has occured please try again later");
 	}

}
}
