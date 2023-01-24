package version_1;
import java.util.Scanner;
import java.sql.*;

public class Cancel_flight {
	public void cancelflight(String flightno, int ticno, String cardno) {
    	Scanner sc = new Scanner(System.in);
		System.out.println("            "+"Welcome to CANCEL FLIGHTS module"+"         ");
		System.out.println("Enter the ticket number: ");
		 ticno = sc.nextInt();//inputing ticket number
		System.out.println("\n"+"Enter flight number: "); 
		 flightno = sc.next();// inputing flight  number
		System.out.println("\n"+"Choose refund method:"); //choose between payment option
		System.out.println("1.Card "+"\n"+"2. UPI");
		int n = sc.nextInt();
		if(n==1) {
			System.out.println("            "+"Enter card details:"+"            ");
			System.out.println("Enter the card number");
			 cardno= sc.next();
			
		}else if(n==2) {
			System.out.println("            "+"Enter upi details"+"            ");
			System.out.println("Enter upi id:");
			 cardno = sc.next();
			
		}else {
			System.out.println("Please give valid selection");
		}	
	 try{
		 
         Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
         String user="root";                          //user name of my sql
         String pass="Seb@43021";                   //password of my sql
         String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
     Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database
         String sql = "delete  from flightsbooked where ticketno = "+ticno + ""; // for deleting the details from database 
 		PreparedStatement ps = con.prepareStatement(sql);
 		con.setAutoCommit(false);
 		ps.execute();
 		con.commit();
 		con.close();
 		System.out.println("         RECIPT       "); // to get the ticket number from data base 
 		System.out.println(" Your ticket number: "+ ticno);
 		System.out.println("Has cancelled and the refund will be done in 3 banking days to "+ cardno);
 		System.out.println("THANKYOU......");
        
     }
     catch(Exception ex){
         ex.printStackTrace();
         System.out.println("Some eroor has occured please try again later");
     }
	}}



 
 
	
	

	


