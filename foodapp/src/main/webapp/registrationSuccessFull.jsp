<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url('bg4.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .container {
            background-color: rgba(0, 0, 0, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #28a745;
        }
        
        p {
            color: #ffffff;
        }
        
        a {
            color: #000; /* Changed to black color */
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #fff; /* Changed to white color */
            border: 2px solid #000; /* Added border to the button */
            color: #000; /* Text color to black */
            text-decoration: none;
            font-size: 16px;
            margin-top: 20px;
        }
        .btn:hover {
            background-color: #f0f0f0; /* Slightly darker white for hover effect */
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration Successful</h1>
        <p>Thank you for registering! Your account has been created successfully.</p>
        <a href="index.html" class="btn">Go to Login</a>
    </div>
</body>
</html>
