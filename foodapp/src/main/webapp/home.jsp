<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurant" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

// Fetch the username from the request attributes
String username = (String) request.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants Here</title>

<!-- Your existing CSS and styles remain unchanged -->
<style>
     body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background: url('https://example.com/background-image.jpg') no-repeat center center fixed; /* Add your background image URL here */
    background-size: cover;
    color: #333;
    line-height: 1.6;
    overflow-x: hidden;
}

.header {
    background-color: white; /* Slightly transparent background */
    color: black;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 1);
    position: fixed; /* Fix the header */
    width: 100%; /* Ensure it takes full width */
    top: 0; /* Stick to the top */
    z-index: 1000; /* Ensure it is on top of other elements */
}

.header-right {
    display: flex;
    align-items: center;
}

.profile {
    display: flex;
    align-items: center;
    margin-right: 20px;
}

.profile img {
    margin-right: 10px;
    height: 30px;
}

div.header .p {
    transform: scale(2); /* Adjust the scale factor as needed */
    margin: 0; /* Ensure no extra space is added */
    text-align: center;
    background: url('https://t3.ftcdn.net/jpg/05/93/72/56/360_F_593725698_sb8lB5w7WrwzHXlVYG36W25ZOgoEZjFB.jpg') no-repeat center center fixed;
    background-size: 15vw 15vh;
    background-size: cover;
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
    
}


.location {
    font-size: 20px;
    margin: 0;
    margin-right: 100px;
    
}

.restaurant-grid {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    padding: 50px;
    max-width: 1200px;
    margin: 70px auto 0 auto; /* Adjust top margin to account for fixed header */
    background-color: rgba(255, 255, 255, 0.8); /* Slightly transparent background */
    border-radius: 15px;
}

.restaurant-card {
    flex: 1 1 calc(33.33% - 90px); /* Ensure three cards per row */
    max-width: calc(33.33% - 70px); /* Ensure maximum width is one-third minus spacing */
    min-width: 300px; /* Ensure cards do not shrink below 300px */
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 1);
    padding: 15px;
    text-align: center;
    margin: 20px; /* Add space between cards */
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    position: relative; /* To position the status badge */
}

/*.restaurant-card:hover {
    transform: translateY(-10px);
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}*/

.restaurant-card img {
    width: 100%;
    height: 150px; /* Adjust height as needed */
    object-fit: cover;
    border-radius: 10px 10px 0 0;
    transition: opacity 0.3s ease;
    padding-top: 30px;
    border-radius: 15px;
}

.restaurant-card img:hover {
    opacity: 0.8;
}

.status-badge {
    position: absolute;
    top: 10px;
    left: 10px;
    padding: 5px 10px;
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
    font-weight: bold;
    border-radius: 5px;
}

.restaurant-name {
    font-family: "Times New Roman", Times, serif;
    font-size: 22px; /* Increased font size for the name */
    font-weight: bold;
    margin: 12px 0 6px;
    color: #333;
}

.details {
    font-family: "Times New Roman", Times, serif;
    width: 100%;
    text-align: left; /* Left-align text for details */
    font-size: 16px; /* Increased font size for details */
    color: #555;
}

.detail-item {
    margin: 6px 0;
}

.rating-cuisine {
    display: flex;
    justify-content: space-between; /* Space between rating and cuisine type */
    font-weight: 800;
}

.rating {
    font-weight: bold;
    color: #ff9800;
    margin-right: auto; /* Align rating to the left */
}

.cuisine-type {
    font-size: 18px; /* Increased font size for the cuisine type */
    color: green;
    text-align: right; /* Align to the right */
}

.active-badge {
    color: green;
    font-weight: 900;
    background-color: rgba(255, 255, 255, 0);
}

.inactive-badge {
    color: red;
    font-weight: bold;
    background-color: rgba(255, 255, 255, 0);
}

.order-btn {
    display: inline-block;
    width: 100%; /* Make the button span the entire width of the card */
    margin-top: 12px;
    padding: 10px 0;
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
    text-decoration: none;
    font-weight: bold;
    border-radius: 5px;
    text-align: center; /* Center the text within the button */
    transition: background-color 0.3s ease;
}

.order-btn:hover {
    background-color: rgba(0, 0, 0, 0.9);
}

@media (max-width: 768px) {
    .restaurant-card {
        flex: 1 1 calc(50% - 20px); /* Adjust width for smaller screens */
    }
}

@media (max-width: 480px) {
    .restaurant-card {
        flex: 1 1 100%; /* Single column on very small screens */
    }
}
    
</style>
</head>
<body>
    <div class="header">
        <div class="header-right">
            <div class="profile">
               <a href="ProfileServlet">
                   <img src="https://static.vecteezy.com/system/resources/thumbnails/016/774/581/small/3d-user-icon-on-transparent-background-free-png.png" 
                   alt="Profile" class="profile" height="50px">
               </a>
               <span>Welcome, <%= username != null ? username : "Guest" %>!</span> <!-- Display the username -->
            </div>
        </div>
		<div>
			<p style="color: green; font-size: 23px;" class="p">
				<b>TapFoods</b>
			</p>
		</div>
		<div class="location">
            <p>📍Bengaluru, Karnataka</p> <!-- Adjust the location as needed -->
        </div>
    </div>

    <div class="restaurant-grid">
        <%
        List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");

        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant restaurant : restaurantList) {
        %>
        <div class="restaurant-card">
            <div>
                <img alt="restaurant-image" src="<%= restaurant.getImagePath() %>">
                <div class="status-badge <%= restaurant.getIsActive() == 1 ? "active-badge" : "inactive-badge" %>">
                    <%= restaurant.getIsActive() == 1 ? "Open" : "Closed" %>
                </div>
            </div>
            <h2 class="restaurant-name"><%= restaurant.getName() %></h2>
            <div class="details">
                <div class="detail-item">
                    <span>🕒 <b>Delivery Time:</b></span>
                    <span><%= restaurant.getDeliveryTime() %> Min</span>
                </div>
                <div class="detail-item">
                    <span>📍 <b>Address:</b></span>
                    <span><%= restaurant.getAddress() %></span>
                </div>
                <div class="detail-item rating-cuisine">
                    <div>
                        <span>⭐ <b>Rating:</b></span>
                        <span class="rating"><%= restaurant.getRatings() %>/5</span>
                    </div>
                    <span class="cuisine-type"><%= restaurant.getCuisineType() %></span>
                </div>
                <a href="viewMenu?restaurentid=<%= restaurant.getRestaurantId() %>" class="order-btn">View Menu</a>
            </div>
            <form action="CartServlet" method="POST">
                <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>">
            </form>
        </div>
        <% 
            }
        } else {
        %>
        <div style="text-align: center; grid-column: 1/-1;">
            <h2>No restaurants available at the moment.</h2>
            <p>Please check back later!</p>
        </div>
        <% } %>
    </div>
</body>
</html>
