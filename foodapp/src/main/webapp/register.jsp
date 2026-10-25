<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            color: #000;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url('bg4.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .overlay {
            display: flex;
            justify-content: center;
            align-items: center;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            
        }
        .container {
            padding: 20px;
            border-radius: 25px;
            border: 2px solid #ffffff; /* White border */
            width: 80%; /* Adjusted to use percentage */
            max-width: 800px; /* Increased max-width */
            color: #000;
            backdrop-filter: blur(8px);
            background-color: rgba(0, 0, 0, 0.8);
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #ffffff;
            font-size: 36px;
        }
        .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .column {
            flex: 0 0 48%;
            display: flex;
            flex-direction: column;
            margin-bottom: 15px; /* Added margin for better spacing */
            position: relative; /* Added for icon positioning */
        }
        .full-width {
            flex: 0 0 100%;
            color: #ffffff;
        }
        .container label {
            color: #ffffff; /* White color for labels */
            margin-bottom: 5px;
        }
        .container input[type="text"],
        .container input[type="email"],
        .container input[type="password"],
        .container input[type="tel"],
        .container textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0; /* Reduced margin */
            border: 3px solid #ffffff; /* Increased border thickness */
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0); /* Transparent input background */
            color: #fff; /* Changed text color to white */
            box-sizing: border-box;
        }
        .container input::placeholder,
        .container textarea::placeholder {
            /* White placeholder color */
            font-size: 16px; /* Increased font size */
        }
        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #ffffff;
            border: none;
            border-radius: 5px;
            color: #000000;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
        }
        .container p {
            margin-top: 20px;
            text-align: center;
            color: #ffffff;
        }
        .container a {
            color: #ffffff;
            text-decoration: none;
        }
        .container a:hover {
            text-decoration: underline;
        }
        .toggle-visibility {
            position: absolute;
            right: 10px;
            top: 65%;
            transform: translateY(-50%);
            cursor: pointer;
            z-index: 1;
            font-size: 1rem; /* Decreased the size of the eye icon */
            color: #fff; /* White color for the icon */
        }
        .error-message {
            color: #ff0000; /* Red color for error messages */
            font-size: 14px;
            display: none; /* Hidden by default */
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
</head>
<body>
    <div class="overlay">
        <div class="container">
            <h2>Registration</h2>
            <form action="RegisterationServlet" method="post" onsubmit="return validatePasswords()">
                <div class="row">
                    <div class="column">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name" placeholder="Name" required>
                    </div>
                    <div class="column">
                        <label for="username">Username</label>
                        <input type="text" name="username" id="username" placeholder="Username" required>
                    </div>
                </div>
                <div class="row"> 
                    <div class="column">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" placeholder="Email" required>
                    </div>
                    <div class="column">
                        <label for="phoneNo">Phone</label>
                        <input type="tel" name="phoneNo" id="phoneNo" placeholder="Phone Number" required>
                    </div>
                </div>
                <div class="row">
                    <div class="column">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" placeholder="Password" required>
                        <i class="ri-eye-off-line toggle-visibility" id="togglePassword"></i>
                    </div>
                    <div class="column">
                        <label for="confirmPassword">Confirm Password</label>
                        <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required>
                        <i class="ri-eye-off-line toggle-visibility" id="toggleConfirmPassword"></i>
                        <span class="error-message" id="error-message">Passwords do not match</span>
                    </div>
                </div>
                <div class="row">
                    <div class="full-width">
                        <label for="address">Address</label>
                        <textarea name="address" id="address" placeholder="Address" rows="3" required></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="full-width">
                        <label><input type="checkbox" required> <b>I hereby declare that the above information provided is true and correct </b></label>
                    </div>
                </div>
                <input type="submit" value="Register">
            </form>
            <p><b>Already have an account?</b> <a href="index.html"><b>Login here</b></a></p>
        </div>
    </div>
    <script>
        const toggleVisibility = (inputId, toggleId) => {
            const input = document.getElementById(inputId);
            const toggleIcon = document.getElementById(toggleId);

            toggleIcon.addEventListener('click', () => {
                if (input.type === 'password') {
                    input.type = 'text';
                    toggleIcon.classList.remove('ri-eye-off-line');
                    toggleIcon.classList.add('ri-eye-line');
                } else {
                    input.type = 'password';
                    toggleIcon.classList.remove('ri-eye-line');
                    toggleIcon.classList.add('ri-eye-off-line');
                }
            });
        }

        toggleVisibility('password', 'togglePassword');
        toggleVisibility('confirmPassword', 'toggleConfirmPassword');

        const validatePasswords = () => {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const errorMessage = document.getElementById("error-message");

            if (password !== confirmPassword) {
                errorMessage.style.display = "block";
                return false; // Prevent form submission
            } else {
                errorMessage.style.display = "none";
                return true; // Allow form submission
            }
        }
    </script>
</body>
</html>
