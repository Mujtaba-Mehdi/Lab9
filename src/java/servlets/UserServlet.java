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
import models.User;


public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String users = "Select * From user;";
        
        try {
            PreparedStatement ps = connection.prepareStatement(users);
            ResultSet user = ps.executeQuery();
            ArrayList<User> userList = new ArrayList<>();
        
            while (user.next()){
                String email = user.getString(1);
                boolean active = user.getBoolean(2);
                String first_name = user.getString(3);
                String last_name = user.getString(4);
                String password = user.getString(5);
                int role = user.getInt(6);
                User addUser = new User(email, active, first_name, last_name, password);
                userList.add(addUser);
            }
            
            session.setAttribute("users", userList);
            
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
