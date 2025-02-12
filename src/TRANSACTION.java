import java.sql.*;
import java.util.*;
public class TRANSACTION {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:330/bank";
        String uname = "root";
        String pwd = "root";

        Connection con = DriverManager.getConnection(url,uname,pwd);
        if(con != null){
            System.out.println("Connection is established");
        }
        else{
            System.out.println("There is a problem in connection establishment");
        }

//        commit,rollback are in con
        con.setAutoCommit(false);//SETTING AUTO COOMIT TO FALSE
        Scanner in = new Scanner(System.in);
        System.out.println("Enter source account");
        int src = in.nextInt();
        System.out.println("Enter destination account");
        int dest = in.nextInt();
        System.out.println("Enter amount to be transferred: ");
        double amount = in.nextDouble();
        Statement st = con.createStatement();
        String withdrawq1 = "update account set accbal = accbal - "+ amount+" where accno = "+src;
        st.addBatch(withdrawq1);  // batch processing
        String depositq1 = "update account set accbal = accbal + "+ amount+" where accno = "+dest;
        st.addBatch(depositq1); // batch processing
        //execute the batch
        int[] res = st.executeBatch(); // all the queries - returns an array

        //logic for commit and rollback
        boolean flag = false;

        for(int i=0; i<res.length;i++){
            if(res[i] == 0){ // query failed
                flag = true; // failed and need to rollback
                break;
            }
        }

        if(flag == true){
            con.rollback(); // Tx aborted
            System.out.println("Transaction rolled back");
        }
        else{
            con.commit();
            System.out.println("Transaction committed");
        }

        ResultSet rs = st.executeQuery("select * from account");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getDouble(2)+"\t"+rs.getString(3));
        }

    }
}
