<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body style="text-align: center;">
        
        <div style="float: left; padding:1%; width: 30%;" >
            <form action="" >
            <h1>Add User</h1>
            <input type="text" name="email" placeholder="Email"><br>
            <input type="text" name="firstname" placeholder="First Name"><br>
            <input type="text" name="lastname" placeholder="Last Name"><br>
            <input type="password" name="password" placeholder="Password"><br>
            <select name="role" style="width: 13.3em; height: 1.9em;">
                <option value="sysadmin">System Admin</option>
                <option value="reguser">Regular User</option>
                <option value="comadmin">Company Admin</option>
            </select><br>
            <input type="submit" value="Save" style="width: 13.3em; height: 2em;">
        </form>
        </div>
        
        
        <div style=" float: left; padding:1%; width: 32%; ">
            <form action="" >
            <h1>Manage User</h1>
            <table style="text-align: center; width: 100%; border: 1px solid black;">
                <tr>
                    <th style="text-align: center; border: 1px solid black;">Email</th>
                    <th style="text-align: center; border: 1px solid black;">First Name</th>
                    <th style="text-align: center; border: 1px solid black;">Last Name</th>
                    <th style="text-align: center; border: 1px solid black;">Role</th>
                    <th style="text-align: center; border: 1px solid black;">Edit</th>
                    <th style="text-align: center; border: 1px solid black;">Delete</th>
                </tr>
                
                <tr>
                </tr>
                <tr>
                </tr>
                <tr>
                </tr>
                
                <c:forEach var="user" items="${users}">
                    
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>TEMP</td>
                        <td>TEMP</td>
                        <td>TEMP</td>
                    </tr>
                    
                </c:forEach>
                
                
                
            </table>
        </form>
        </div>
        
        
        <div style="float: right; padding:1%; width: 32%;">
            <form action="">
                <h1>Edit User</h1>
                <input type="text" name="email" value="${User.email}"><br>
                <input type="text" name="firstname" value="${User.firstname}"><br>
                <input type="text" name="lastname" value="${User.lastname}"><br>
                <select name="role" value="${Role.role}" style="width: 13.3em; height: 1.9em;">
                    <option value="sysadmin">System Admin</option>
                    <option value="reguser">Regular User</option>
                    <option value="comadmin">Company Admin</option>
                </select><br>
                <input type="submit" value="Submit" style="width: 13.3em; height: 2em;"><br>
                <input type="submit" value="Cancel" style="width: 13.3em; height: 2em;">
            </form>
        </div>
        

    </body>
</html>