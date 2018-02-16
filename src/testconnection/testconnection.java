package testconnection;
import java.sql.*;
public class testconnection {
    String cname;
    int croll;
    String some;
    //getting the data from anthor gui class
    public void set(String s,int r){
        
        System.out.println("Hello your setter is working");
        cname=s;
        croll=r;
        some="insert into student (name,roll) values ('"+cname+"',"+String.valueOf(croll)+")";
        System.out.println(some);
    }
   //making the connection
    public void connn() {
        String url="jdbc:oracle:thin:@localhost:1521:XE";
       
       try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver Loaded sucessfully");
        Connection con = DriverManager.getConnection(url, "akash", "priya");
        System.out.println("Connection established sucessfully");
        //todo query
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(some);
        //while(rs.next()==true){
        //    System.out.println(rs.getString(1)+" "+rs.getInt(2));
        //}
        System.out.println("Your query run sucessfully");
        
        con.close();
    }
    catch(ClassNotFoundException e){
    System.out.println("Driver not loded");
    }
    catch(SQLException e){
        System.out.println("connection not Established");
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    }
}
