<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Hello ${name}!</title>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <img class="logo" src="../img/logo.png" alt="Logo"/>
        </div>
        <div class="menu">
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/play.svg" alt="Play"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/hs.svg" alt="High Scores"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/login.svg" alt="Login"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/register.svg" alt="Register"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
        </div>
    </div>
    <div class="login-wrapper hidden popup">
        <img class="login-img" sr="../img/login_pic.png" alt="Login Image"/>
        <div class="login-form">
            <form id="login">
                <label for="email">E-mail:</label><br>
                <input type="email" id="email" name="email"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password">
            </form>
        </div>
    </div>
</body>
</html>