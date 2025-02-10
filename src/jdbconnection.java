import java.sql.*;

public class jdbconnection {
    public static void main(String[] args) throws Exception{
        //1)LOADING DRIVERS
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2)ESTABLISHING THE CONNECTION
        String url = "jdbc:mysql://localhost:330/world";
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

        //4)EXECUTE QUIRIES
        String query = "select * from city limit 5";
        ResultSet res = st.executeQuery(query); // TO EXECUTE QUERY INT HE DATABASEL

        //5)PROCESS RESULTS
        while(res.next()){
            System.out.println(res.getInt(1) + "  " + res.getString(2));//FOR CHAR USE getString() ||||| FOR INT USE getInt()
        }
        //6)CLOSING THE CONNECTION
        con.close();
    }
}
