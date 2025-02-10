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
//        String create = "create table student(sid int auto_increment primary key,regno int,name varchar(20),age int,gpa double,check(age>=18))";
//
//        int x = st.executeUpdate(create);//RETURN VALUE(0) INT IF SUCCESSFULL
//        System.out.print(x);
//        if(x >= 0){
//            System.out.println("created table successfully");
//        }
//        else{
//            System.out.println("not created");
//        }//***********WE ARE DOING ABOVE -> CREATE FOR ONLY ONE TIME BECAUSE TABLE IS CREATED FOR ONLY ONE TIME
        //IF WE CHECK ALREADY TABLE IS CREATED INT HE MY SQL DATABASE

        //INSERT QUERY
        String insert = "insert into student (regno,name,age,gpa) values(1931,'sasi',19,8.2)";
        int x = st.executeUpdate(insert);//WE USE INT FOR INSERTION BECAUSE IT RETURNS LINE 0 ROWS UPADTED;

        if(x >= 0){
            System.out.println(x + " inserted data successfully");
        }
        else{
            System.out.println("error in insertion");
        }

//        while(res.next()){
//            System.out.println(res.getInt(1) + " " + res.getInt(2) + " " + res.getString(3) + " " + res.getInt(4) + " " + res.getDouble(5) + " ");
//        }

        //closing
        con.close();

    }
}
