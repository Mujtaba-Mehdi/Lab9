package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

public class UserService {
       public User get(int id) throws Exception {
        UserDB userDB = new UserDB();
        User user = UserDB.get();
        return user;
    }
    
    public List<User> getAll(String email) throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll(email);
        return users;
    }
    
    public void insert(String email, String firstname, String lastname) throws Exception {
        User user = new User(email, firstname, lastname);
        UserDB noteDB = new UserDB();
        noteDB.insert(user);
    }
    
    public void update(String email, String firstname, String lastname) throws Exception {
        User note = new User(email, firstname, lastname);
        UserDB noteDB = new UserDB();
        noteDB.update(note);
    }
    
    public void delete(int userId) throws Exception {
        User user = new User();
        user.setUserId(userId);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }   
            
}
