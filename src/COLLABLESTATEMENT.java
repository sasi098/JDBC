import java.sql.*;
import java.util.Scanner;

public class COLLABLESTATEMENT {
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
        String query = "{call first_pro(?,?)}"; //CALLING THE STORED FUNCTION

        CallableStatement call = con.prepareCall(query);
        call.setInt(1,5);//SETTING A VALUE
        call.registerOutParameter(2,Types.INTEGER);
        call.execute();//EXECUTE THE STORED PROCEDURE

        int result = call.getInt(2);
        System.out.println(result);


    }
}

//CallableStatement Interface
//CallableStatement is used to call stored procedures and functions from the database.
//It can accept input parameters, output parameters, or both.
//        Stored Procedure
//A stored procedure is a set of SQL statements that perform a specific task.
//It can include conditional statements, loops, and other programming constructs.
//A stored procedure may or may not return a value.
//It can have input parameters, output parameters, or both.
//        Example: Stored Procedure
//sql
//        Copy
//Edit
//CREATE PROCEDURE first_pro(IN a INT, OUT b INT)
//BEGIN
//SET b = a;
//END;


//Stored Functions
//A stored function is similar to a stored procedure but always returns a value.
//It is mainly used for computations or data transformations.
//Example: Stored Function
//sql
//        Copy
//Edit

//CREATE FUNCTION add_ab(a INT, b INT)
//RETURNS INT DETERMINISTIC
//        BEGIN
//DECLARE c INT;
//SET c = a + b;
//RETURN c;
//END;
