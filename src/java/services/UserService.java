package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class UserService {
    
        public Role get(int roleId) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleId);
        return role;
    }
    
    public List<User> getAll(String email, boolean active, String firstname, String lastname, String password) throws Exception {
        UserDB userDB = new UserDB();
        List<User> user = userDB.getAll(email);
        return user;
    }
    
    public void insert(String email, boolean active, String firstname, String lastname) throws Exception {
        User user = new User(email, active, firstname, lastname);
        UserDB noteDB = new UserDB();
        noteDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstname, String lastname) throws Exception {
        User user = new User(email, active, firstname, lastname);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email, boolean active, String firstname, String lastname, String password) throws Exception {
        User user = new User();
        user.setUserId(String email, boolean active, String firstname, String lastname, String password);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
    
    
}
