<%-- 
    Document   : login
    Created on : May 17, 2021, 1:43:41 PM
    Author     : Latiude 7480
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN FORM</title>
    </head>
    
    <body>
        <form method="post" action="login">
            Username : <input id="user" type="text" name="username">
            <br/>
            Password: <input id="pass" type = "text" name = "password" />
            <input type = "submit" value = "Submit" onclick="submit()"/>
        </form>
    </body>
</html>
