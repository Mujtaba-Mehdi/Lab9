<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <form action="" style="display: inline-block">
            <h1>Add User</h1>
            <input type="text" name="email" placeholder="Email"><br>
            <input type="text" name="firstname" placeholder="First Name"><br>
            <input type="text" name="lastname" placeholder="Last Name"><br>
            <input type="text" name="password" placeholder="Password"><br>
            <select name="role">
                <option value="sysadmin">System Admin</option>
                <option value="reguser">Regular User</option>
                <option value="comadmin">Company Admin</option>
            </select><br>
            <input type="submit" value="Save" style="width: 13.3em; height: 2em;">
        </form>

        <form action="" style="display: inline-block">
            <h1>Manage User</h1>
            <table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
                <tr>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                    <td>TEMP</td>
                </tr>
            </table>
        </form>
        <form action="" style="display: inline-block">
            <h1>Edit User</h1>
            <input type="text" name="email" value="${User.email}"><br>
            <input type="text" name="firstname" value="${User.firstname}"><br>
            <input type="text" name="lastname" value="${User.lastname}"><br>
            <select name="role" value="${Role.role}">
                <option value="sysadmin">System Admin</option>
                <option value="reguser">Regular User</option>
                <option value="comadmin">Company Admin</option>
            </select><br>
            <input type="submit" value="Submit" style="width: 13.3em; height: 2em;"><br>
            <input type="submit" value="Cancel" style="width: 13.3em; height: 2em;">
        </form>

    </body>
</html>
