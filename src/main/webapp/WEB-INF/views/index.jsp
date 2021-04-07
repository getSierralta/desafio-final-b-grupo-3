<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../../css/style.css">
    <title>Desafio Upskill</title>
    <script src="../js/popup.js"></script>
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
                <span class="errorMessage" style="color:red;"> ${errorMessage}</span>
                <span class="errorMessage" style="color: red">${verifyMessage}</span>
                <span class="errorMessage" style="color: red">${tokenError}</span>
                <span class="errorMessage" style="color: green">${successPasswordChange}</span>
                <label for="username">E-mail:</label><br>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password" required>
                <span id="recover-pass">Forgot your password?</span>
                <input  id="login-yes" class="submit-button" type="submit" value_"Submit">
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
                    <input class="input" type="text" id="fname" name="name" required><br>
                    <span class="errorMessage" style="color: #ff0000">${errorMail}</span>
                    <label for="password">Email:</label><br>
                    <input class="input" type="text" id="lname" name="username" required><br>
                    <label for="password">City:</label><br>
                    <input class="input" type="text" id="city" name="city" required><br>
                    <span class="errorMessage" style="color: red">${errorPassword}</span>
                    <label for="password">Password:</label><br>
                    <input class="input" type="password" id="password" name="password" required><br>
                    <label for="password">Confirm Password:</label><br>
                    <input class="input" type="password" id="password" name="confirmPassword" required><br>
                    <input class="submit-button" type="submit" value_"Submit">
                </form>
            </div>
    </div>
    <div class="popup-recover-pass" title="Recover Password">
            <div class="recover-img-wrapper">
                <div class="recover-img">
                    <img src="../img/recover_pic.png" alt="Recover Image"/>
                </div>
            </div>
            <div class="recover-form">
                <form id="recover" method="post" action="/esqueciPassword" id="recover">
                    <label for="username">E-mail:</label><br>
                    <input type="text" id="username" name="username" required><br>
                    <input class="submit-button" type="submit" value_"Submit">
                </form>
            </div>
        </div>

</body>
</html>