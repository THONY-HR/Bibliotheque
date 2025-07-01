<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bibliothèque - Accueil</title>
</head>
<body>
    <h1>${message}</h1>
    <h2><%= request.getAttribute("message") %></h2>
    <%
        for(int i= 0; i< 5; i++){
            %><h3><%=request.getAttribute("message")%></h3><%
        }
    %>
    
    <p>Ceci est une page JSP gérée par Spring Boot.</p>
</body>
</html>
