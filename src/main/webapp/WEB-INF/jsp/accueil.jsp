<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bibliotheque.app.entity.Utilisateur" %>

<html>
    <head>
        <title>Utilisateur</title>
    </head>
    <body>
    <%
        // Récupérer la liste
        List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("data");

        if (utilisateurs != null && !utilisateurs.isEmpty()) {
            Utilisateur user = utilisateurs.get(0); // Premier utilisateur

            // Afficher les informations
    %>
    <h1>Informations de l'utilisateur</h1>
    <p>ID: <%= user.getId() %></p>
    <p>Nom: <%= user.getNom() %></p>
    <p>Email: <%= user.getEmail() %></p>
    <p>Mot de passe: <%= user.getMotDePasse() %></p>
    <p>Rôle: <%= user.getRole().getRoles() %></p>
    <%
    } else {
    %>
    <p>Aucun utilisateur trouvé.</p>
    <%
        }
    %>
    </body>
</html>
