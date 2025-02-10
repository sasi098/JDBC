import java.sql.*;

public class AGGREGATE {
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
        Statement st = con.createStatement();//FOR SENDING SQL OBJECTS TO DATA BASE

        //FUNCTIONS
        String query = "select count(*),sum(gpa),max(gpa),min(gpa),avg(gpa) from student";
        String query2 = "select * from student";
        ResultSet res = st.executeQuery(query);
        //INDEX STARTS FROM 1 NOT 0

        while(res.next()){
            System.out.println("count of records : " + res.getInt(1));
            System.out.println("sum of gpa : " + res.getDouble(2));
            System.out.println("max of gpa : " + res.getDouble(3));
            System.out.println("min of gpa : " + res.getDouble(4));
            System.out.println("average of gpa : " + res.getDouble(5));
        }

        System.out.println("TABLE");
        ResultSet res2 = st.executeQuery(query2);
        while(res2.next()){
            System.out.println(res2.getInt(1) + " " + res2.getInt(2) + " " + res2.getString(3) + " " + res2.getInt(4) + " " + res2.getDouble(5) + " ");
        }

        con.close();
    }
}
