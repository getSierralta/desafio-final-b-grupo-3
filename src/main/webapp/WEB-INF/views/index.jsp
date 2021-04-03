<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Hello ${name}!</title>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <img class="logo" src="../img/logo.png" alt="Logo"/>
        </div>
        <div class="menu">

            <div class="option">
                <div class="left_hand"></div>
                <img id="login" class="menu_title" src="../img/login.svg" alt="Login"/>
                <div class="right_hand"></div>
            </div>
            <div class="option">
                <div class="left_hand"></div>
                <img id="register" class="menu_title" src="../img/register.svg" alt="Register"/>
                <div class="right_hand"></div>
            </div>
        </div>
    </div>
    <div class="popup-login" title="Login">
        <div class="login-img-wrapper">
            <div class="login-img">
                <img src="../img/login_pic.png" alt="Login Image"/>
            </div>
        </div>
        <div class="login-form">
            <form id="login" method="post" action="/login" id="login">
                <label for="email">E-mail:</label><br>
                <input type="text" id="username" name="username"><br>
                <label for="password">Password:</label><br>
                 <input type="password" id="password" name="password">
                <input class="submit-button" type="submit" value_"Submit">
            </form>
        </div>
    </div>
    <div class="popup-register" title="Register">
            <div class="register-img-wrapper">
                <div class="register-img">
                    <img src="../img/registo_pic.png" alt="Register Image"/>
                </div>
            </div>
            <div class="register-form">
                <form id="register" action="/register" method="post">
                    <label for="fname">Name:</label><br>
                    <input class="input" type="text" id="fname" name="name"><br>
                    <label for="password">Email:</label><br>
                    <input class="input" type="text" id="lname" name="username"><br>
                    <label for="password">City:</label><br>
                    <input class="input" type="text" id="city" name="city"><br>
                    <label for="password">Password:</label><br>
                    <input class="input" type="password" id="password" name="password"><br>
                    <label for="password">Confirm Password:</label><br>
                    <input class="input" type="password" id="password" name="confirmPassword"><br>
                    <input class="submit-button" type="submit" value_"Submit">
                </form>
            </div>
        </div>
    <script src="../js/popup.js"></script>
</body>
</html>