package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author mujtaba
 */
public class RoleService {

    public Role get(int id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = RoleDB.get(id);
        return role;
    }

    public List<Role> getAll(int roleId, String role) throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> users = roleDB.getAll(roleId, role);
        return users;
    }

    public void insert(int roleId, String roleName) throws Exception {
        Role role = new Role(roleId, roleName);
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);
    }

    public void update(int roleId, String roleName) throws Exception {
        Role note = new Role(roleId, roleName);
        RoleDB roleDB = new RoleDB();
        roleDB.update(note);
    }

    public void delete(int roleId, String roleName) throws Exception {
        Role role = new Role();
        role.setRoleId(roleId);
        RoleDB roleDB = new RoleDB();
        roleDB.delete(role);
    }

}
