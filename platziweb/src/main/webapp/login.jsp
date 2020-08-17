<%--
  Created by IntelliJ IDEA.
  User: Dany
  Date: 16/8/2020
  Time: 10:58 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- Comentario JSP --%>
<%! int i = 0; %>
<form action="<%=request.getContextPath() %>/abc123" method="get">
    <table>
        <tr>
            <td><label for="userInput">User:</label></td>
            <td><input type="text" name="user" id="userInput"></td>
            <td> <label for="userEnterprise">Enterpise:</label></td>
            <td><input type="text" name="enterprise" id="userEnterprise"></td>
        </tr>
    </table>
    <input type="submit" value="Send">

    <% for(i=0; i<10; i++){ %>
    <label for="">Hola2 <%=i%></label>
    <% } %>


</form>
</body>
</html>
