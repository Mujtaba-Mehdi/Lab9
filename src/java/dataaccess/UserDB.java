package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Role;
import models.User;
import servlets.UserServlet;

/**
 *
 * @author mujta
 */
public class UserDB {
    
    private ArrayList<Role> roleList;
    private ArrayList<User> userList;

    public static User get() {

        return null;
    }

    public ArrayList<User> getAll() throws SQLException {


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        
        String users = "Select * From user;";
       
        RoleDB roleDB = new RoleDB();
        roleList = roleDB.getAll();
        userList = new ArrayList<>();
        
        try {
            
            //for users
            ps = connection.prepareStatement(users);
            ResultSet user = ps.executeQuery();
            
        
            while (user.next()){
                String email = user.getString(1);
                boolean active = user.getBoolean(2);
                String first_name = user.getString(3);
                String last_name = user.getString(4);
                String password = user.getString(5);
                int userRole = user.getInt(6);
                
                Role newRole = roleList.get(userRole - 1);
                
                User addUser = new User(email, active, first_name, last_name, password, newRole.getRoleName());
                userList.add(addUser);
            }
            
            pool.freeConnection(connection);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userList;
    }

    public void insert(User user) throws SQLException {
        
        //connect
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        //get correct role id, hack way
        int role = 99;
        
        switch (user.role) {
            case "system admin":
                role = 1;
                break;
            case "regular user":
                role = 2;
                break;
            case "company admin":
                role = 3;
                break;
        }
        
        //prepare insertion
        String sql = "INSERT INTO user "
                + "values('" + user.email 
                + "', "+ user.active
                +  ", '"+ user.firstname
                + "', '"+ user.lastname
                + "', '"+ user.password
                + "', "+ role + ");";

        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(String email) throws SQLException {
        
        //connect
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        //prepare deletion
        String sql = "DELETE FROM user WHERE email= '"
                + email +"';";
        
        //execute and close
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
           
    }

    public void update(User user) {

    }

}
