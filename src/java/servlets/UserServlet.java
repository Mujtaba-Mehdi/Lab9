package servlets;

import dataaccess.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;


public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        
        String users = "Select * From user;";
        String role = "Select * From Role;";
        
        ArrayList<Role> roleList = new ArrayList<>();
        ArrayList<User> userList = new ArrayList<>();
        
        try {
            //for role
            ps = connection.prepareStatement(role);
            ResultSet roles = ps.executeQuery();
            
            
            while (roles.next()) {
                int roleID = roles.getInt(1);
                String roleName = roles.getString(2);
                Role r = new Role(roleID, roleName);
                roleList.add(r);
            }
            
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
            
            session.setAttribute("users", userList);
            session.setAttribute("roles", roleList);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
