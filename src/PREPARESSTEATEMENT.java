import java.sql.*;
import java.util.Scanner;

public class PREPARESSTEATEMENT {
    public static void main(String[] args) throws Exception{
        //1)LOADING DRIVERS
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2)ESTABLISHING THE CONNECTION
        String url = "jdbc:mysql://localhost:330/mydatabasse";
        String uname = "root";
        String pwd = "root";

        Connection con = DriverManager.getConnection(url,uname,pwd);


        if(con != null){
            System.out.println("Connection is established");
        }
        else{
            System.out.println("There is a problem in connection establishment");
        }

        //3)CREATING THE STATEMENT
//        Statement st = con.createStatement();//FOR SENDING SQL OBJECTS TO DATA BASE
        //1)STATEMENT INTERFACE
//        String query = "create table info(name varchar(20),age int,cgpa double)";
//        int x = st.executeUpdate(query);
//        if(x>=0){
//            System.out.print("creates");
//        }

        //2)PREPARED STATEMENT INTERFACE
//        String q1 = "insert into info values (?,?,?)";
//        PreparedStatement prep = con.prepareStatement(q1);
//
//        prep.setString(1,"lohith");
//        prep.setInt(2,19);
//        prep.setDouble(3,8.42);
//
//        int x = prep.executeUpdate();
//        if(x >= 0){
//            System.out.println(x + " records inserted");
//        }

        //UPDATION
//        prep = con.prepareStatement("update info set name=? where name=?");
//        prep.setString(1,"avinash");
//        prep.setString(2,"lohith");
//
//        int y = prep.executeUpdate();
//        if(y >= 0){
//            System.out.println(y + " rows uDpdated");
//        }

        //INSERTING DATA FROM INPUT
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name : ");
        String name = sc.nextLine();
        System.out.print("Enter age : ");
        int age = sc.nextInt();
        System.out.print("Enter gpa to be inserted : ");
        double gpa = sc.nextDouble();
        String query = "insert into info values(?,?,?)";
        PreparedStatement prep = con.prepareStatement(query);
        prep.setString(1,name);
        prep.setInt(2,age);
        prep.setDouble(3,gpa);
        prep.executeUpdate();

        ResultSet res = prep.executeQuery("select * from info");
        while(res.next()){
            System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getDouble(3));
        }

        con.close();
    }
}
