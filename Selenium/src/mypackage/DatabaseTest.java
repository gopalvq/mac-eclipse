package mypackage;
		
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		

public class  DatabaseTest {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl = "jdbc:mysql://localhost:3306/dbPerson";					

				//Database Username		
				String username = "root";	
                
				//Database Password		
				String password = "password";				

				//Query to Execute		
				String query = "select * from tblPerson;";	
                
         	    //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String myName = rs.getString(1);								        
                            String myAge = rs.getString(2);					                               
                            System. out.println(myName+"  "+myAge);		
                    }		
      			 // closing DB Connection		
      			con.close();			
		}
}
