import model.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: herr
 * Date: 01.10.14
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class DBClass {
    public Connection createConnection() throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "12345");
        return connection;
    }
    //we get values from servlet by passing bean object to insertdetails method
    public int insertDetails(UserBean bb) throws SQLException, ClassNotFoundException
    {
        Connection con = createConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into userdetails values(?,?,?,?)");
        //set values to prepared statement object by getting values from bean object
        pstmt.setString(2,bb.getUserName());
        pstmt.setString(3,bb.getDateOfBirth());
        pstmt.setString(4,bb.getEmail());
        pstmt.setString(1,bb.getPhoneNo());
        int i = pstmt.executeUpdate();
        return i;

    }
    public List getAlldetails()throws SQLException, ClassNotFoundException
    {

        Connection con = createConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from userdetails");
        ResultSet rs = pstmt.executeQuery();
        List list = new ArrayList();
        while(rs.next())
        {
            UserBean ubean = new UserBean();
            ubean.setUserName(rs.getString(2));
            ubean.setDateOfBirth(rs.getString(3));
            ubean.setEmail(rs.getString(4));
            ubean.setPhoneNo(rs.getString(1));
            list.add(ubean);

        }
        return list;
    }
    public UserBean getDetails(String uname)throws SQLException, ClassNotFoundException
    {
        //here we will write code to get a single record from database
        Connection con = createConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from userdetails where user_name=?");
        pstmt.setString(1, uname);
        ResultSet rs = pstmt.executeQuery();
        List list = new ArrayList();
        UserBean ubean = new UserBean();
        while(rs.next())
        {
            ubean.setUserName(rs.getString(2));
            ubean.setDateOfBirth(rs.getString(3));
            ubean.setEmail(rs.getString(4));
            ubean.setPhoneNo(rs.getString(1));
        }
        ubean.setAction("update");
        return ubean;
    }
    public void UpateDetails(UserBean ubean, String name)throws SQLException, ClassNotFoundException
    {

        Connection con = createConnection();
        PreparedStatement pstmt = con.prepareStatement("update userdetails set date_of_birth=?,e_mail=?,phone_no=? where user_name=? ");
        //set values to prepared statement object by getting values from bean object
        pstmt.setString(1,ubean.getDateOfBirth());
        pstmt.setString(2,ubean.getEmail());
        pstmt.setString(3,ubean.getPhoneNo());
        pstmt.setString(4,name);
        pstmt.executeUpdate();
    }

    public void deleteDetails(String uname)throws SQLException, ClassNotFoundException
    {
        //here we will write code to get a single record from database
        Connection con = createConnection();
        PreparedStatement pstmt = con.prepareStatement("delete from userdetails where user_name=?");
        pstmt.setString(1, uname);
        pstmt.executeUpdate();
    }
}

