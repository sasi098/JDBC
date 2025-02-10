import java.sql.*;

public class CRUD {
    public static void main(String[] args) throws Exception{
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
        Statement st = con.createStatement();//FOR SENDING SQL OBJECTS TO DATA BASE
        String create = "create table student(sid int auto_increment primary key,regno int,name varchar(20),age int,gpa double,check(age>=18))";

        int x = st.executeUpdate(create);//RETURN VALUE(0) INT IF SUCCESSFULL
        System.out.print(x);
        if(x >= 0){
            System.out.println("created table successfully");
        }
        else{
            System.out.println("not created");
        }



    }
}
