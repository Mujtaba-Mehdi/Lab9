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

    public List<User> getAll(String email, boolean active, String firstname, String lastname, String password, String role) throws Exception {
        UserDB userDB = new UserDB();
        List<User> user = userDB.getAll(email, active, firstname, lastname, password, role);
        return user;
    }

    public void insert(String email, boolean active, String firstname, String lastname, String password, String role) throws Exception {
        User user = new User(email, active, firstname, lastname, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }

    public void update(String email, boolean active, String firstname, String lastname, String password, String role) throws Exception {
        User user = new User(email, active, firstname, lastname, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email, boolean active, String firstname, String lastname, String password, String role) throws Exception {
        User user = new User();
        user.setUserId(email, active, firstname, lastname, password, role);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }

}
