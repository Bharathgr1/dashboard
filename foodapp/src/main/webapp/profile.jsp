<%@ page import="com.foodapp.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    <% if (user!= null) { %>
        <p><strong>Name:</strong> <%= user.getName() %></p>
        <p><strong>Email:</strong> <%= user.getEmail() %></p>
        <p><strong>Phone:</strong> <%= user.getPhone() %></p>
        <p><strong>Address:</strong> <%= user.getAddress() %></p>
        <!-- Add other user fields as needed -->
    <% } else { %>
        <p>User information is not available.</p>
    <% } %>
</body>
</html>
