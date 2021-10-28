package models;

/**
 *
 * @author mujta
 */
public class User {
    String email;
    boolean active;
    String firstname;
    String lastname;
    String password;

    public User(String email, boolean active, String firstname, String lastname, String password) {
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public User(String email, String firstname, String lastname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User(String email, boolean active, String firstname, String lastname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
            
    
    
}
